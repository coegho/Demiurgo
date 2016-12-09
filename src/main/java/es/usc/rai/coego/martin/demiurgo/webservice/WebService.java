package es.usc.rai.coego.martin.demiurgo.webservice;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
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
import org.glassfish.jersey.internal.Errors;

import es.usc.rai.coego.martin.demiurgo.Demiurgo;
import es.usc.rai.coego.martin.demiurgo.exceptions.DemiurgoException;
import es.usc.rai.coego.martin.demiurgo.json.AllRoomPathsResponse;
import es.usc.rai.coego.martin.demiurgo.json.CheckRoomResponse;
import es.usc.rai.coego.martin.demiurgo.json.ExecuteCodeRequest;
import es.usc.rai.coego.martin.demiurgo.json.ExecuteCodeResponse;
import es.usc.rai.coego.martin.demiurgo.json.FixCodeRequest;
import es.usc.rai.coego.martin.demiurgo.json.GetPendingRoomsResponse;
import es.usc.rai.coego.martin.demiurgo.json.JsonAction;
import es.usc.rai.coego.martin.demiurgo.json.JsonDecision;
import es.usc.rai.coego.martin.demiurgo.json.JsonObject;
import es.usc.rai.coego.martin.demiurgo.json.JsonRoom;
import es.usc.rai.coego.martin.demiurgo.json.JsonUser;
import es.usc.rai.coego.martin.demiurgo.json.JsonVariable;
import es.usc.rai.coego.martin.demiurgo.json.MyUserResponse;
import es.usc.rai.coego.martin.demiurgo.json.NarrateActionRequest;
import es.usc.rai.coego.martin.demiurgo.json.NarrateActionResponse;
import es.usc.rai.coego.martin.demiurgo.json.ResponseStatus;
import es.usc.rai.coego.martin.demiurgo.parsing.ClassVisitor;
import es.usc.rai.coego.martin.demiurgo.parsing.CodeVisitor;
import es.usc.rai.coego.martin.demiurgo.parsing.ErrorHandler;
import es.usc.rai.coego.martin.demiurgo.universe.Action;
import es.usc.rai.coego.martin.demiurgo.universe.User;
import es.usc.rai.coego.martin.demiurgo.universe.UserDefinedClass;
import es.usc.rai.coego.martin.demiurgo.universe.World;
import es.usc.rai.coego.martin.demiurgo.universe.WorldObject;
import es.usc.rai.coego.martin.demiurgo.universe.WorldRoom;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;
import es.usc.rai.coego.martin.demiurgo.webservice.auth.DemiurgoPrincipal;
import es.usc.rai.coego.martin.demiurgo.webservice.auth.Secured;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.IncorrectClaimException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MissingClaimException;
import io.jsonwebtoken.SignatureException;

@Path("/webservice")
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
		try {
			String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
			String username = securityContext.getUserPrincipal().getName();
			User u = Demiurgo.getWorld(world).getUser(username);

			if (u != null) {
				me.setStatus(new ResponseStatus());
				JsonUser ju = new JsonUser();
				ju.setName(u.getUsername());
				ju.setObjId(u.getObjId());
				ju.setWorld(world);
				ju.setRole(u.getRole().toString());
				me.setUser(ju);
				return me;
			} else
				me.setStatus(new ResponseStatus(false, "user not found"));
		} catch (SignatureException | MissingClaimException | IncorrectClaimException e) {
			System.err.println(e.getLocalizedMessage());
			me.setStatus(new ResponseStatus(false, e.getLocalizedMessage()));
		}
		return me;
	}

	@GET
	@Path("/checkroom")
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("gm")
	public CheckRoomResponse checkRoom(@QueryParam(value = "path") String path) {
		CheckRoomResponse res = new CheckRoomResponse();
		try {
			String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
			WorldRoom room = Demiurgo.getWorld(world).getRoom(path);

			if (room != null) {
				JsonRoom r = new JsonRoom();
				r.setId(room.getId());
				r.setLongPath(path);

				List<JsonVariable> variables = new ArrayList<>();
				for (Entry<String, ValueInterface> v : room.getVariables().entrySet()) {
					variables.add(
							new JsonVariable(v.getKey(), v.getValue().getValueAsString(), v.getValue().getTypeName()));
				}
				r.setVariables(variables);

				List<JsonObject> objects = new ArrayList<>();
				for (WorldObject o : room.getObjects()) {
					List<JsonVariable> fields = new ArrayList<>();
					for (Entry<String, ValueInterface> v : o.getFields().entrySet()) {
						fields.add(new JsonVariable(v.getKey(), v.getValue().getValueAsString(),
								v.getValue().getTypeName()));
					}
					objects.add(new JsonObject(o.getId(), o.getClassName(), o.getLocId(), fields));
				}
				r.setObjects(objects);

				List<JsonDecision> decisions = new ArrayList<>();
				for (User u : room.getDecidingUsers()) {
					decisions.add(new JsonDecision(u.getUsername(), u.getDecision()));
				}
				r.setDecisions(decisions);
				res.setRoom(r);
				return res;
			} else {
				System.err.println("Cannot find room '" + path + "'");
				res.setStatus(new ResponseStatus(false, "Cannot find room '" + path + "'"));
				return res;
			}
		} catch (SignatureException | MissingClaimException | IncorrectClaimException e) {
			res.setStatus(new ResponseStatus(false, e.getLocalizedMessage()));
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
		InputStream is = new ByteArrayInputStream(req.getCode().getBytes(StandardCharsets.UTF_8));
		ParseTree tree;
		WorldRoom room = Demiurgo.getWorld(world).getRoom(req.getPath());
		if (room == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Cannot find room '" + req.getPath() + "'")
					.build();
		}
		CodeVisitor eval = new CodeVisitor(room);

		Action.Status status;
		String goodCode;

		ErrorHandler errors = new ErrorHandler();
		try {
			
			tree = Demiurgo.parseStream(is, errors);
			eval.visit(tree);

			// if there are no errors catched, everything is ok at this point
			status = Action.Status.READY;
			goodCode = req.getCode();
			res.setStatus(new ResponseStatus());

		} catch (ParseCancellationException e) {
			// Syntax error
			res.setErrorStartIndex(0);
			res.setStatus(new ResponseStatus(false, errors.getErrors().get(0).getMessage()));
			return Response.ok(res).build();
		} catch (RuntimeException e) {
			if (e.getCause() instanceof DemiurgoException) {
				// Semantic error
				DemiurgoException ex = (DemiurgoException) e.getCause();
				res.setStatus(new ResponseStatus(false, e.getMessage()));
				status = Action.Status.FIX;
				goodCode = req.getCode().substring(0, ex.getStartIndex());
				// points out unexecuted code
				res.setErrorStartIndex(ex.getStartIndex());
			} else {
				// Unexpected internal error
				System.err.println(e.getCause().getMessage()); // TODO: Logger?
				return Response.serverError().entity(e.getMessage()).build();
			}
		} catch (IOException e) {
			// Unexpected IO error
			return Response.serverError().entity(e.getMessage()).build();
		}

		// TODO: only part of code
		Action action = new Action(0, room, goodCode, eval.getPrenarration(), status);
		Demiurgo.getWorld(world).addAction(action);

		List<String> witnesses = new ArrayList<>();
		for (User u : action.getWitnesses()) {
			witnesses.add(u.getUsername());
		}
		DateFormat df = DateFormat.getInstance();
		res.setAction(new JsonAction(action.getId(), action.getCode(), action.getNarration(),
				action.getRoom().getLongPath(), witnesses, df.format(action.getDate()), action.getStatus().toString()));

		return Response.ok(res).build();

	}

	@POST
	@Path("/narrateaction")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("gm")
	public Response narrateAction(NarrateActionRequest req) {
		NarrateActionResponse res = new NarrateActionResponse();
		String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
		WorldRoom room = Demiurgo.getWorld(world).getRoom(req.getRoom());
		if (room == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Cannot find room '" + req.getRoom() + "'")
					.build();
		}
		// Search action by id
		Action action = room.getActions().stream().filter(p -> p.getId() == req.getId()).collect(Collectors.toList())
				.get(0);

		if (action.getStatus() == Action.Status.FIX) {
			// The code must be fixed, cannot publish action
			res.setStatus(new ResponseStatus(false, "The code must be fixed, cannot publish action"));
			return Response.ok(res).build();
		}
		action.setNarration(req.getNarration());
		action.setStatus(Action.Status.PUBLISHED);
		res.setStatus(new ResponseStatus());
		return Response.ok(res).build();
	}

	@POST
	@Path("/fixcode")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("gm")
	public Response fixActionCode(FixCodeRequest req) {
		ExecuteCodeResponse res = new ExecuteCodeResponse();

		String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
		InputStream is = new ByteArrayInputStream(req.getNewCode().getBytes(StandardCharsets.UTF_8));
		ParseTree tree;
		WorldRoom room = Demiurgo.getWorld(world).getRoom(req.getPath());
		if (room == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Cannot find room '" + req.getPath() + "'")
					.build();
		}

		// Selecting previous action
		Action action = room.getActions().stream().filter(p -> p.getId() == req.getId()).collect(Collectors.toList())
				.get(0);

		if (action.getStatus() == Action.Status.FIX) {
			// The code does not need a fix
			res.setStatus(new ResponseStatus(false, "The code does not need a fix"));
			return Response.ok(res).build();
		}
		CodeVisitor eval = new CodeVisitor(room);

		Action.Status status;
		String goodCode;

		try {
			ErrorHandler errors = new ErrorHandler();;
			tree = Demiurgo.parseStream(is, errors );
			eval.visit(tree);

			// if there are no errors catched, everything is ok at this point
			status = Action.Status.READY;
			goodCode = req.getNewCode();
			res.setStatus(new ResponseStatus());

		} catch (ParseCancellationException e) {
			// Syntax error
			res.setErrorStartIndex(0);
			res.setStatus(new ResponseStatus(false, Errors.getErrorMessages().get(0).getMessage()));
			return Response.ok(res).build();
		} catch (RuntimeException e) {
			if (e.getCause() instanceof DemiurgoException) {
				// Semantic error
				DemiurgoException ex = (DemiurgoException) e.getCause();
				res.setStatus(new ResponseStatus(false, e.getMessage()));
				status = Action.Status.FIX;
				goodCode = req.getNewCode().substring(0, ex.getStartIndex());
				// points out unexecuted code
				res.setErrorStartIndex(ex.getStartIndex());
			} else {
				// Unexpected internal error
				System.err.println(e.getCause().getMessage()); // TODO: Logger?
				return Response.serverError().entity(e.getMessage()).build();
			}
		} catch (IOException e) {
			// Unexpected IO error
			return Response.serverError().entity(e.getMessage()).build();
		}

		action.setCode(action.getCode() + goodCode);
		action.setNarration(action.getNarration() + eval.getPrenarration());
		action.setWitnesses(new ArrayList<>(room.getUsers()));
		action.setStatus(status);

		List<String> witnesses = new ArrayList<>();
		for (User u : action.getWitnesses()) {
			witnesses.add(u.getUsername());
		}
		DateFormat df = DateFormat.getInstance();
		res.setAction(new JsonAction(action.getId(), action.getCode(), action.getNarration(),
				action.getRoom().getLongPath(), witnesses, df.format(action.getDate()), action.getStatus().toString()));

		return Response.ok(res).build();
	}

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
			tree = Demiurgo.parseStream(is, errors );

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
	@Produces(MediaType.APPLICATION_JSON)
	public String createRoom(@FormParam("token") String token, @FormParam("path") String path) {
		try {
			Jws<Claims> cl = Jwts.parser().require("role", "admin").setSigningKey(Demiurgo.getKey())
					.parseClaimsJws(token);
			String world = (String) cl.getBody().get("world");
			WorldRoom room = Demiurgo.getWorld(world).newRoom(path);
			return (room != null) ? "OK" : "ERROR";
		} catch (SignatureException | MissingClaimException | IncorrectClaimException e) {
			System.err.println(e.getLocalizedMessage());
			return "ERROR";
		}
	}

	@POST
	@Path("/submitdecision")
	@Produces(MediaType.APPLICATION_JSON)
	public String submitDecision(@FormParam("token") String token, @FormParam("text") String text) {
		try {
			Jws<Claims> cl = Jwts.parser().require("role", "player").setSigningKey(Demiurgo.getKey())
					.parseClaimsJws(token);
			String world = (String) cl.getBody().get("world");
			String user = (String) cl.getBody().getSubject();
			World w = Demiurgo.getWorld(world);
			w.getUser(user).setDecision(text);
			WorldObject obj = w.getUser(user).getObj();
			if (obj != null && obj.getLocation() instanceof WorldRoom) {
				w.getPendingRooms().add((WorldRoom) obj.getLocation());
			} else {
				// TODO: characters without room
			}
			return "OK";
		} catch (SignatureException | MissingClaimException | IncorrectClaimException e) {
			System.err.println(e.getLocalizedMessage());
			return "ERROR";
		}
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