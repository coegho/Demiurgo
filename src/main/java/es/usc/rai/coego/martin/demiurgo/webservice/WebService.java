package es.usc.rai.coego.martin.demiurgo.webservice;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
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
import es.usc.rai.coego.martin.demiurgo.json.AllClassesResponse;
import es.usc.rai.coego.martin.demiurgo.json.AllRoomPathsResponse;
import es.usc.rai.coego.martin.demiurgo.json.CheckRoomResponse;
import es.usc.rai.coego.martin.demiurgo.json.CreateClassRequest;
import es.usc.rai.coego.martin.demiurgo.json.CreateClassResponse;
import es.usc.rai.coego.martin.demiurgo.json.CreateRoomRequest;
import es.usc.rai.coego.martin.demiurgo.json.DeleteVariableRequest;
import es.usc.rai.coego.martin.demiurgo.json.DeleteVariableResponse;
import es.usc.rai.coego.martin.demiurgo.json.DestroyClassRequest;
import es.usc.rai.coego.martin.demiurgo.json.DestroyClassResponse;
import es.usc.rai.coego.martin.demiurgo.json.DestroyObjectRequest;
import es.usc.rai.coego.martin.demiurgo.json.DestroyObjectResponse;
import es.usc.rai.coego.martin.demiurgo.json.DestroyRoomRequest;
import es.usc.rai.coego.martin.demiurgo.json.DestroyRoomResponse;
import es.usc.rai.coego.martin.demiurgo.json.ExecuteCodeRequest;
import es.usc.rai.coego.martin.demiurgo.json.ExecuteCodeResponse;
import es.usc.rai.coego.martin.demiurgo.json.GetPendingRoomsResponse;
import es.usc.rai.coego.martin.demiurgo.json.JsonAction;
import es.usc.rai.coego.martin.demiurgo.json.JsonClass;
import es.usc.rai.coego.martin.demiurgo.json.JsonPendingRoom;
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
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoClass;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoObject;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoRoom;
import es.usc.rai.coego.martin.demiurgo.universe.RootObjectClass;
import es.usc.rai.coego.martin.demiurgo.universe.User;
import es.usc.rai.coego.martin.demiurgo.universe.UserRole;
import es.usc.rai.coego.martin.demiurgo.universe.Witness;
import es.usc.rai.coego.martin.demiurgo.universe.World;
import es.usc.rai.coego.martin.demiurgo.webservice.auth.DemiurgoPrincipal;
import es.usc.rai.coego.martin.demiurgo.webservice.auth.Secured;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.IncorrectClaimException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MissingClaimException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.lang.Strings;

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
		DemiurgoObject obj = u.getObj();
		if (obj != null) {
			w.addPendingRoom(obj.getLocation().getRealLocation());
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
		List<Action> actions = new ArrayList<>(w.getActions().values());
		Collections.sort(actions);
		List<Action> allActions = actions.stream().filter(a -> a.hasWitness(u)).collect(Collectors.toList());

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
			narrations.add(Demiurgo.filterActionToUser(a.getNarration(), username));
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
		DemiurgoRoom room = Demiurgo.getWorld(world).getRoom(path);

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
		DemiurgoRoom room = w.getRoom(req.getPath());
		if (room == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Cannot find room '" + req.getPath() + "'")
					.build();
		}

		// We define witnesses before executing code
		// This way, exiting users can see their last action before exit room
		List<User> users = room.getUsers();
		List<Witness> witnesses = new ArrayList<>();
		for (User u : users) {
			witnesses.add(new Witness(u, u.getDecision()));
		}

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
			if (req.isCreateAction()) {
				Action action = new Action(room, room.getPrenarration(), witnesses);
				Demiurgo.getWorld(world).addAction(action);
				room.clearDecisionsAndPrenarration();

				res.setAction(action.toJson());
			}

		} catch (ParseCancellationException e) {
			res.setStatus(new ResponseStatus(false, Strings.collectionToDelimitedString(
					errors.getErrors().stream().map(de -> de.getMessage()).collect(Collectors.toList()), "\n")));
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
				e.printStackTrace();
				// Demiurgo.getLogger().severe(e.getMessage());
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
		DemiurgoRoom room = w.getRoom(path);
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

	@GET
	@Path("/allclasses")
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("gm")
	public Response getAllClasses() {
		AllClassesResponse res = new AllClassesResponse();
		String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
		World w = Demiurgo.getWorld(world);

		List<JsonClass> l = new ArrayList<>();
		for (DemiurgoClass cl : w.getClasses()) {
			if (!(cl instanceof RootObjectClass))
				l.add(cl.toJson());
		}
		
		res.setClasses(l);
		return Response.ok(res).build();
	}

	@GET
	@Path("/getclass")
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("gm")
	public Response getDemiurgoClass(@QueryParam("classname") String classname) {
		String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
		World w = Demiurgo.getWorld(world);
		DemiurgoClass cl = w.getClassFromName(classname.toLowerCase());
		if (cl == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Cannot found class " + classname).build();
		}

		return Response.ok(cl.toJson()).build();
	}

	@POST
	@Path("/createclass")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("gm")
	public Response createClass(CreateClassRequest req) {
		CreateClassResponse res = new CreateClassResponse();
		String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
		World w = Demiurgo.getWorld(world);

		if (w.getClassFromName(req.getName().toLowerCase()) != null) {
			// Class already exists
			res.setStatus(new ResponseStatus(false, "Class " + req.getName() + " already exists"));
			return Response.ok(res).build();
		}
		InputStream is = new ByteArrayInputStream(req.getCode().getBytes(StandardCharsets.UTF_8));
		ParseTree tree;

		ErrorHandler errors = new ErrorHandler();
		try {
			tree = Demiurgo.parseStream(is, errors);
		} catch (IOException e) {
			Demiurgo.getLogger().severe(e.getMessage());
			return Response.serverError().build();
		}

		if (errors.hasErrors()) {
			res.setStatus(new ResponseStatus(false, Strings.collectionToDelimitedString(errors.getErrors(), "\n")));
			return Response.ok(res).build();
		}

		DemiurgoClass newClass = new DemiurgoClass(req.getName().toLowerCase(), req.getCode(), w);
		try {
			ClassVisitor eval = new ClassVisitor(newClass);
			eval.visit(tree);
		} catch (RuntimeException e) {
			if (e.getCause() instanceof DemiurgoException) {
				DemiurgoException ex = (DemiurgoException) e.getCause();
				res.setStatus(new ResponseStatus(false, ex.getMessage()));
				return Response.ok(res).build();
			} else {
				Demiurgo.getLogger().severe(e.getMessage());
				return Response.serverError().build();
			}
		}
		w.addClass(newClass);
		res.setCreatedClass(newClass.toJson());
		res.setStatus(new ResponseStatus());
		return Response.ok(res).build();
	}

	@POST
	@Path("/modifyclass")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("gm")
	public Response modifyClass(CreateClassRequest req) {
		CreateClassResponse res = new CreateClassResponse();
		String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
		World w = Demiurgo.getWorld(world);

		DemiurgoClass oldClass = w.getClassFromName(req.getName().toLowerCase());
		
		if(oldClass instanceof RootObjectClass) {
			res.setStatus(new ResponseStatus(false,"Cannot modify class object"));
			return Response.ok(res).build();
		}

		InputStream is = new ByteArrayInputStream(req.getCode().getBytes(StandardCharsets.UTF_8));
		ParseTree tree = null;

		ErrorHandler errors = new ErrorHandler();
		try {
			tree = Demiurgo.parseStream(is, errors);
		} catch (RuntimeException e) {
			if (e.getCause() instanceof DemiurgoException) {
				DemiurgoException ex = (DemiurgoException) e.getCause();
				res.setStatus(new ResponseStatus(false, ex.getMessage()));
				return Response.ok(res).build();
			}
		} catch (IOException e) {
			Demiurgo.getLogger().severe(e.getMessage());
			return Response.serverError().build();
		}

		if (errors.hasErrors()) {
			res.setStatus(new ResponseStatus(false, Strings.collectionToDelimitedString(errors.getErrors(), "\n")));
			return Response.ok(res).build();
		}

		DemiurgoClass newClass = new DemiurgoClass(req.getName().toLowerCase(), req.getCode(), w);
		try {
			ClassVisitor eval = new ClassVisitor(newClass);
			eval.visit(tree);
		} catch (RuntimeException e) {
			if (e.getCause() instanceof DemiurgoException) {
				DemiurgoException ex = (DemiurgoException) e.getCause();
				res.setStatus(new ResponseStatus(false, ex.getMessage()));
				return Response.ok(res).build();
			} else {
				e.printStackTrace();// Demiurgo.getLogger().severe(e.getMessage());
				return Response.serverError().build();
			}
		}

		w.modifyClass(oldClass, newClass);

		res.setCreatedClass(oldClass.toJson());
		res.setStatus(new ResponseStatus());
		return Response.ok(res).build();
	}

	@POST
	@Path("/createroom")
	@RolesAllowed("gm")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createRoom(CreateRoomRequest req) {
		String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
		World w = Demiurgo.getWorld(world);
		DemiurgoRoom room = w.newRoom(req.getPath());

		return Response.ok(room.toJson()).build();
		// TODO: could this fail?
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
			List<JsonPendingRoom> pendingRooms = new ArrayList<>();
			for (DemiurgoRoom r : w.getPendingRooms()) {
				pendingRooms.add(r.toJsonPendingRoom());
			}
			res.setPendingRooms(pendingRooms);
			res.setNumUsers(w.getAllUsers().size());
			res.setNoObjUsers(w.getAllUsers().stream().filter(u -> (u.getObj() == null && u.getRole() == UserRole.USER))
					.map(u -> u.getUsername()).collect(Collectors.toList()));
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

		String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
		World w = Demiurgo.getWorld(world);

		if (w == null) {
			res.setStatus(new ResponseStatus(false, "invalid world"));
		} else {
			List<String> paths = new ArrayList<>();
			for (DemiurgoRoom r : w.getAllRooms()) {
				paths.add(r.getLongPath());
			}
			res.setPaths(paths);
		}

		return res;
	}
	
	@POST
	@Path("/delvar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("gm")
	public Response deleteVariable(DeleteVariableRequest req) {
		DeleteVariableResponse res = new DeleteVariableResponse();
		String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
		World w = Demiurgo.getWorld(world);
		DemiurgoRoom room = w.getRoom(req.getPath());
		if(room == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("Cannot find room " + req.getPath()).build();
		}
		else if(room.getVariable(req.getVarName()) != null) {
			room.removeVariable(req.getVarName());
			res.setStatus(new ResponseStatus());
		}
		else {
			res.setStatus(new ResponseStatus(false, "Cannot find variable " + req.getVarName()));
		}
		return Response.ok(res).build();
	}
	
	@POST
	@Path("destroyobj")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("gm")
	public Response destroyObject(DestroyObjectRequest req) {
		DestroyObjectResponse res = new DestroyObjectResponse();
		String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
		World w = Demiurgo.getWorld(world);
		w.getObject(req.getObjId()).destroyObject(req.isDestroyContents());
		return Response.ok(res).build();
	}
	
	@POST
	@Path("destroyclass")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("gm")
	public Response destroyClass(DestroyClassRequest req) {
		DestroyClassResponse res = new DestroyClassResponse();
		String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
		World w = Demiurgo.getWorld(world);
		w.getClassFromName(req.getClassname()).destroyClass();
		return Response.ok(res).build();
	}
	
	@POST
	@Path("destroyroom")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed("gm")
	public Response destroyRoom(DestroyRoomRequest req) {
		DestroyRoomResponse res = new DestroyRoomResponse();
		String world = ((DemiurgoPrincipal) securityContext.getUserPrincipal()).getWorld();
		World w = Demiurgo.getWorld(world);
		w.getRoom(req.getPath()).destroyLocation();
		return Response.ok(res).build();
	}
}