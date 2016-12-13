package es.usc.rai.coego.martin.demiurgo.webservice;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;

import es.usc.rai.coego.martin.demiurgo.Demiurgo;
import es.usc.rai.coego.martin.demiurgo.exceptions.DemiurgoException;
import es.usc.rai.coego.martin.demiurgo.json.AllRoomPathsResponse;
import es.usc.rai.coego.martin.demiurgo.json.CheckRoomResponse;
import es.usc.rai.coego.martin.demiurgo.json.CreateRoomRequest;
import es.usc.rai.coego.martin.demiurgo.json.ExecuteCodeRequest;
import es.usc.rai.coego.martin.demiurgo.json.ExecuteCodeResponse;
import es.usc.rai.coego.martin.demiurgo.json.GetPendingRoomsResponse;
import es.usc.rai.coego.martin.demiurgo.json.JsonAction;
import es.usc.rai.coego.martin.demiurgo.json.MyUserResponse;
import es.usc.rai.coego.martin.demiurgo.json.NarrateActionRequest;
import es.usc.rai.coego.martin.demiurgo.json.NarrateActionResponse;
import es.usc.rai.coego.martin.demiurgo.json.PastActionsResponse;
import es.usc.rai.coego.martin.demiurgo.json.ResponseStatus;
import es.usc.rai.coego.martin.demiurgo.json.RoomHistoryResponse;
import es.usc.rai.coego.martin.demiurgo.json.SubmitDecisionRequest;
import es.usc.rai.coego.martin.demiurgo.parsing.ClassVisitor;
import es.usc.rai.coego.martin.demiurgo.parsing.CodeVisitor;
import es.usc.rai.coego.martin.demiurgo.parsing.ErrorHandler;
import es.usc.rai.coego.martin.demiurgo.universe.Action;
import es.usc.rai.coego.martin.demiurgo.universe.User;
import es.usc.rai.coego.martin.demiurgo.universe.UserDefinedClass;
import es.usc.rai.coego.martin.demiurgo.universe.World;
import es.usc.rai.coego.martin.demiurgo.universe.WorldObject;
import es.usc.rai.coego.martin.demiurgo.universe.WorldRoom;
import es.usc.rai.coego.martin.demiurgo.webservice.auth.DemiurgoPrincipal;
import es.usc.rai.coego.martin.demiurgo.webservice.auth.Secured;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.IncorrectClaimException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MissingClaimException;
import io.jsonwebtoken.SignatureException;

@Path("/")
@Secured
@PermitAll
public class WebService {
	@Context
	SecurityContext securityContext;

	@GET
	@Path("/me")
	@Produces(MediaType.APPLICATION_JSON)
	public MyUserResponse me() {
		MyUserResponse me = new MyUserResponse();

		String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
		String username = securityContext.getUserPrincipal().getName();
		User u = Demiurgo.getWorld(world).getUser(username);

		if (u != null) {
			me.setStatus(new ResponseStatus());
			me.setUser(u.toJson());
			me.setWorld(world);
			return me;
		} else
			me.setStatus(new ResponseStatus(false, "user not found"));

		return me;
	}

	///////////// USER SERVICES/////////////
	@POST
	@Path("/submitdecision")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("user")
	public Response submitDecision(SubmitDecisionRequest req) {
		String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
		World w = Demiurgo.getWorld(world);
		String username = securityContext.getUserPrincipal().getName();
		User u = Demiurgo.getWorld(world).getUser(username);

		u.setDecision(req.getDecision());
		WorldObject obj = u.getObj();
		if (obj != null && obj.getLocation() instanceof WorldRoom) {
			w.getPendingRooms().add((WorldRoom) obj.getLocation());
		} else {
			// TODO: characters without room
		}
		return Response.ok().build();
	}

	@GET
	@Path("/pastactions")
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("user")
	public Response seePastActions(@QueryParam("first") @DefaultValue("-10") String first,
			@QueryParam("count") @DefaultValue("10") String max) {
		PastActionsResponse res = new PastActionsResponse();
		String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
		World w = Demiurgo.getWorld(world);
		String username = securityContext.getUserPrincipal().getName();
		User u = Demiurgo.getWorld(world).getUser(username);

		List<String> narrations = new ArrayList<>();

		// We get all actions with this user involved in them
		List<Action> allActions = w.getActions().values().stream().filter(a -> a.getWitnesses().contains(u))
				.collect(Collectors.toList());

		int f, l;
		f = Integer.parseInt(first);
		if (f < 0)
			f = allActions.size() + f;
		if (f < 0)
			f = 0;
		l = f + Integer.parseInt(max);
		if (l >= allActions.size())
			l = allActions.size();

		List<Action> someActions = allActions.subList(f, l);
		for (Action a : someActions) {
			narrations.add(a.getNarration()); // TODO: filter content
		}
		res.setStatus(new ResponseStatus());
		res.setActions(narrations);

		return Response.ok(res).build();
	}

	///////////// GM SERVICES/////////////
	@GET
	@Path("/checkroom")
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("gm")
	public CheckRoomResponse checkRoom(@QueryParam(value = "path") String path) {
		CheckRoomResponse res = new CheckRoomResponse();

		String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
		WorldRoom room = Demiurgo.getWorld(world).getRoom(path);

		if (room != null) {
			res.setRoom(room.toJson());

			// Looking for unpublished action
			List<Action> actions = room.getActions().stream().filter(p -> !p.isPublished())
					.collect(Collectors.toList());
			if (actions.size() > 0) {
				res.setUnpublishedAction(actions.get(0).toJson());
			}

			return res;
		} else {
			res.setStatus(new ResponseStatus(false, "Cannot find room '" + path + "'"));
			return res;
		}

	}

	@POST
	@Path("/executecode")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("gm")
	public Response executeCode(ExecuteCodeRequest req) {
		ExecuteCodeResponse res = new ExecuteCodeResponse();

		String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
		World w = Demiurgo.getWorld(world);
		WorldRoom room = w.getRoom(req.getPath());
		if (room == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Cannot find room '" + req.getPath() + "'")
					.build();
		}
		
		//We define witnesses before executing code
		//This way, exiting users can see their last action before exit room
		List<User> witnesses = room.getUsers();

		InputStream is = new ByteArrayInputStream(req.getCode().getBytes(StandardCharsets.UTF_8));
		ParseTree tree;
		CodeVisitor eval = new CodeVisitor(room);

		ErrorHandler errors = new ErrorHandler();
		try {

			tree = Demiurgo.parseStream(is, errors);
			eval.visit(tree);

			// if there are no errors catched, everything is ok at this point
			w.getLogger().info(req.getCode() + "\n###Execution complete###");
			res.setStatus(new ResponseStatus());
			room.appendPrenarration(eval.getPrenarration());
			Action action = new Action(0, room, room.getPrenarration(), witnesses);
			Demiurgo.getWorld(world).addAction(action);
			room.clearDecisionsAndPrenarration();
			
			res.setAction(action.toJson());

		} catch (ParseCancellationException e) {
			// Syntax error
			res.setStatus(new ResponseStatus(false, errors.getErrors().get(0).getMessage()));
			return Response.ok(res).build();
		} catch (RuntimeException e) {
			if (e.getCause() instanceof DemiurgoException) {
				// Semantic error
				// DemiurgoException ex = (DemiurgoException) e.getCause();
				w.getLogger().info(req.getCode() + "\n###" + e.getMessage() + "###");
				res.setStatus(new ResponseStatus(false, e.getMessage()));
				// store prenarration
				room.appendPrenarration(eval.getPrenarration());
			} else {
				// Unexpected internal error
				Demiurgo.getLogger().severe(e.getCause().getMessage());
				;
				return Response.serverError().build();
			}
		} catch (IOException e) {
			// Unexpected IO error
			Demiurgo.getLogger().severe(e.getCause().getMessage());
			;
			return Response.serverError().build();
		}

		return Response.ok(res).build();

	}

	@GET
	@Path("/action")
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("gm")
	public Response getAction(@QueryParam("id") long id) {
		String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
		World w = Demiurgo.getWorld(world);
		Action a = w.getAction(id);
		if (a != null) {
			return Response.ok(a.toJson()).build();
		}
		return Response.status(Response.Status.NOT_FOUND).build();
	}

	@POST
	@Path("/narrateaction")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("gm")
	public Response narrateAction(NarrateActionRequest req) {
		NarrateActionResponse res = new NarrateActionResponse();
		String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
		World w = Demiurgo.getWorld(world);
		// Search action by id
		Action action = w.getAction(req.getId());

		action.setNarration(req.getNarration());
		action.setPublished(true);

		res.setStatus(new ResponseStatus());
		res.setAction(action.toJson());
		return Response.ok(res).build();
	}

	@GET
	@Path("/history")
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("gm")
	public Response seeRoomHistory(@QueryParam("path") String path,
			@QueryParam("first") @DefaultValue("0") String first,
			@QueryParam("count") @DefaultValue("15") String count) {
		RoomHistoryResponse res = new RoomHistoryResponse();
		String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
		World w = Demiurgo.getWorld(world);
		WorldRoom room = w.getRoom(path);
		if (room == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Cannot find room " + path).build();
		}
		List<Action> allActions = room.getActions().stream().filter(a -> a.isPublished()).collect(Collectors.toList());
		int f, l;
		f = Integer.parseInt(first);
		if (f < 0)
			f = allActions.size() + f;
		if (f < 0)
			f = 0;
		l = f + Integer.parseInt(count);
		if (l >= allActions.size())
			l = allActions.size();

		List<JsonAction> actions = new ArrayList<>();
		for (Action a : allActions.subList(f, l)) {
			actions.add(a.toJson());
		}
		res.setActions(actions);
		res.setTotalActions(allActions.size());
		res.setStatus(new ResponseStatus());
		return Response.ok(res).build();
	}

	// TODO
	@POST
	@Path("/newclass")
	@Produces(MediaType.APPLICATION_JSON)
	public String newClass(@FormParam("token") String token, @FormParam("name") String name,
			@FormParam("code") String code) {
		try {
			Jws<Claims> cl = Jwts.parser().require("role", "admin").setSigningKey(Demiurgo.getKey())
					.parseClaimsJws(token);
			String world = (String) cl.getBody().get("world");
			World w = Demiurgo.getWorld(world);
			// ErrorHandler errors = new ErrorHandler();
			InputStream is = new ByteArrayInputStream(code.getBytes(StandardCharsets.UTF_8));
			ParseTree tree;

			ErrorHandler errors = new ErrorHandler();
			tree = Demiurgo.parseStream(is, errors);

			UserDefinedClass newClass = new UserDefinedClass(name, w);
			w.addClass(newClass);
			ClassVisitor eval = new ClassVisitor(newClass);
			eval.visit(tree);

			/*
			 * if (errors.hasErrors()) { for (String e : errors.getErrors()) {
			 * System.err.println(e); // TODO: Output this and check errors }
			 * w.removeClass(newClass.getClassName()); }
			 */
			return "OK";
		} catch (SignatureException | MissingClaimException | IncorrectClaimException | IOException e) {
			System.err.println(e.getLocalizedMessage());
			return "ERROR";
		}
	}

	@POST
	@Path("/createroom")
	@RolesAllowed("gm")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createRoom(CreateRoomRequest req) {
		String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
		World w = Demiurgo.getWorld(world);
		WorldRoom room = w.newRoom(req.getPath());
		
		return Response.ok(room.toJson()).build();
		//TODO: could this fail?
	}

	@GET
	@Path("/pendingrooms")
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("gm")
	public GetPendingRoomsResponse getPendingRooms() {
		GetPendingRoomsResponse res = new GetPendingRoomsResponse();
		try {
			String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
			World w = Demiurgo.getWorld(world);
			if (w == null) {
				res.setStatus(new ResponseStatus(false, "cannot find room"));
				return res;
			}
			List<String> pendingRooms = new ArrayList<>();
			for (WorldRoom r : w.getPendingRooms()) {
				pendingRooms.add(r.getLongPath());
			}
			res.setPendingRooms(pendingRooms);
			return res;
		} catch (SignatureException | MissingClaimException | IncorrectClaimException e) {
			System.err.println(e.getLocalizedMessage());
			res.setStatus(new ResponseStatus(false, e.getLocalizedMessage()));
			return res;
		}
	}

	// TODO: is this method useful?
	@GET
	@Path("/noroomdecisions")
	@Produces(MediaType.APPLICATION_JSON)
	public String getNoRoomDecisions(@QueryParam("token") String token) {
		try {
			Jws<Claims> cl = Jwts.parser().require("role", "admin").setSigningKey(Demiurgo.getKey())
					.parseClaimsJws(token);
			String world = (String) cl.getBody().get("world");
			World w = Demiurgo.getWorld(world);
			if (w == null)
				return "ERROR";
			// return w.getDecisions().toString();
			return "OK";
		} catch (SignatureException | MissingClaimException | IncorrectClaimException e) {
			System.err.println(e.getLocalizedMessage());
			return "ERROR";
		}
	}

	@GET
	@Path("/roompaths")
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("gm")
	public AllRoomPathsResponse getAllRoomPaths() {
		AllRoomPathsResponse res = new AllRoomPathsResponse();
		try {
			String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
			World w = Demiurgo.getWorld(world);

			if (w == null) {
				res.setStatus(new ResponseStatus(false, "invalid world"));
			} else {
				List<String> paths = new ArrayList<>();
				for (WorldRoom r : w.getAllRooms()) {
					paths.add(r.getLongPath());
				}
				res.setPaths(paths);
			}

		} catch (SignatureException | MissingClaimException | IncorrectClaimException e) {
			System.err.println(e.getLocalizedMessage());
			res.setStatus(new ResponseStatus(false, e.getLocalizedMessage()));
		}
		return res;
	}
}