package es.usc.rai.coego.martin.demiurgo.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import es.usc.rai.coego.martin.demiurgo.Demiurgo;
import es.usc.rai.coego.martin.demiurgo.exceptions.ValueCastException;
import es.usc.rai.coego.martin.demiurgo.parsing.ClassVisitor;
import es.usc.rai.coego.martin.demiurgo.parsing.CodeVisitor;
import es.usc.rai.coego.martin.demiurgo.parsing.ErrorHandler;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoClass;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoObject;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoRoom;
import es.usc.rai.coego.martin.demiurgo.universe.User;
import es.usc.rai.coego.martin.demiurgo.universe.UserRole;
import es.usc.rai.coego.martin.demiurgo.universe.World;
import es.usc.rai.coego.martin.demiurgo.values.IntegerValue;
import es.usc.rai.coego.martin.demiurgo.values.ObjectValue;
import es.usc.rai.coego.martin.demiurgo.values.ReturnValueTypes;
import es.usc.rai.coego.martin.demiurgo.values.ValueInterface;

public class COETest {
	private World world;
	private DemiurgoRoom room;
	
	
	@Before
	public void setUp() throws Exception {
		world = new World("world1");
		room = new DemiurgoRoom("/room", world, 0);
		world.newRoom(room);
	}
	
	@Test
	public void createNewObject() {
		String code = "new object()";
		
		ErrorHandler errors = new ErrorHandler();
		InputStream is = new ByteArrayInputStream(code.getBytes(StandardCharsets.UTF_8));
		try {
			ParseTree tree = Demiurgo.parseStream(is, errors);
			CodeVisitor vis = new CodeVisitor(room);
			vis.visit(tree);
			assertTrue(room.getObjects().size() > 0);
			assertEquals(world.getRootClass(), room.getObjects().get(0).getDemiurgoClass());
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void createClass() {
		String code =
				String.join("\n",
						"newclass {\n",
						"int integer",
						"str string",
						"method() { }",
						"}");
		
		DemiurgoClass cl = new DemiurgoClass("newclass", code, world);
		
		ErrorHandler errors = new ErrorHandler();
		InputStream is = new ByteArrayInputStream(code.getBytes(StandardCharsets.UTF_8));
		try {
			ParseTree tree = Demiurgo.parseStream(is, errors);
			ClassVisitor vis = new ClassVisitor(cl);
			vis.visit(tree);
			
			assertEquals(world.getRootClass(),cl.getParentClass());
			assertEquals(cl.getField("integer").getInnerType(), ReturnValueTypes.INT);
			assertEquals(cl.getField("string").getInnerType(), ReturnValueTypes.STRING);
			assertTrue(cl.getMethod("method").getArgsValues().size() == 0);
			
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void updateClass() {
		String oldcode = String.join("\n",
				"oldclass {",
				"}");
		
		String newcode = String.join("\n",
				"newclass {",
				"int var1",
				"str var2",
				"int out = method(int in) {",
				"}",
				"}");
		
		DemiurgoClass oldclass = new DemiurgoClass("oldclass", oldcode, world);
		oldclass.setParentClass(world.getRootClass());
		
		DemiurgoObject obj = new DemiurgoObject(oldclass, room, new HashMap<String, ValueInterface>());
		
		DemiurgoClass newclass = new DemiurgoClass("newclass", newcode, world);
		
		ErrorHandler errors = new ErrorHandler();
		InputStream is = new ByteArrayInputStream(newcode.getBytes(StandardCharsets.UTF_8));
		try {
			ParseTree tree = Demiurgo.parseStream(is, errors);
			ClassVisitor vis = new ClassVisitor(newclass);
			vis.visit(tree);
			
			oldclass.modifyTo(newclass);
			obj.updateClass();
			
			assertEquals(world.getRootClass(),oldclass.getParentClass());
			assertEquals(oldclass.getField("var1").getInnerType(), ReturnValueTypes.INT);
			assertEquals(oldclass.getField("var2").getInnerType(), ReturnValueTypes.STRING);
			assertTrue(oldclass.getMethod("method").getArgsValues().size() == 1);
			assertTrue(oldclass.getMethod("method").getReturnArgumentName() != null);
			
			assertEquals(obj.getField("var1").getInnerType(), ReturnValueTypes.INT);
			assertEquals(obj.getField("var2").getInnerType(), ReturnValueTypes.STRING);
			
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void MoveObject() {
		DemiurgoRoom room2 = world.newRoom("/anew/room");
		DemiurgoObject obj = new DemiurgoObject(world.getRootClass(), room);
		String code = "#"+obj.getId()+" >> @/anew/room";
		
		ErrorHandler errors = new ErrorHandler();
		InputStream is = new ByteArrayInputStream(code.getBytes(StandardCharsets.UTF_8));
		try {
			ParseTree tree = Demiurgo.parseStream(is, errors);
			CodeVisitor vis = new CodeVisitor(room);
			vis.visit(tree);
			assertEquals(obj.getLocation(), room2);
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void callMethod() {
		String classcode = String.join("\n",
				"newclass {",
				"int vAr = 5",
				"method() {",
				"var = 7",
				"}",
				"}");
		
		String code = String.join("\n",
				"newclass oBj = new newclass()",
				"obJ.method()");
		
		DemiurgoClass newclass = new DemiurgoClass("newclass", classcode, world);
		
		ErrorHandler errors = new ErrorHandler();
		InputStream is = new ByteArrayInputStream(classcode.getBytes(StandardCharsets.UTF_8));
		try {
			ParseTree tree = Demiurgo.parseStream(is, errors);
			ClassVisitor vis = new ClassVisitor(newclass);
			vis.visit(tree);
			
			world.addClass(newclass);
			
			is = new ByteArrayInputStream(code.getBytes(StandardCharsets.UTF_8));
			tree = Demiurgo.parseStream(is, errors);
			CodeVisitor vis2 = new CodeVisitor(room);
			vis2.visit(tree);
			
			assertTrue(room.getVariable("obj").getInnerType() == ReturnValueTypes.OBJECT);
			assertTrue(room.getVariable("obj").getValueAsString().equals("#0"));
			
			DemiurgoObject obj = ((ObjectValue)room.getVariable("obj")).getObj();
			assertNotNull(obj);
			assertNotNull(obj.getField("vAr"));
			assertTrue(obj.getField("vAr").getType() == ReturnValueTypes.INT);
			assertEquals(((IntegerValue)obj.getField("Var")).getValue(), 7);
			
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void forLoop() {
		IntegerValue var;
		var = Mockito.mock(IntegerValue.class);
		room.setVariable("var", var);
		
		String code = String.join("\n",
				"for(a : seq(1,10)) {",
				"var = a }");
		
		ErrorHandler errors = new ErrorHandler();
		InputStream is = new ByteArrayInputStream(code.getBytes(StandardCharsets.UTF_8));
		try {
			ParseTree tree = Demiurgo.parseStream(is, errors);
			CodeVisitor vis = new CodeVisitor(room);
			vis.visit(tree);
			
			verify(var, times(10)).assign(Mockito.any());
		} catch (IOException e) {
			fail(e.getMessage());
		} catch (ValueCastException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Test
	public void setUserObject() {
		User user1 = new User("user1", UserRole.USER);
		world.addUser(user1);
		DemiurgoObject obj = new DemiurgoObject(world.getRootClass(), room);
		
		String code = "$useR1 -> #0";
		
		ErrorHandler errors = new ErrorHandler();
		InputStream is = new ByteArrayInputStream(code.getBytes(StandardCharsets.UTF_8));
		try {
			ParseTree tree = Demiurgo.parseStream(is, errors);
			CodeVisitor vis = new CodeVisitor(room);
			vis.visit(tree);
			
			assertEquals(user1.getObj(), obj);
			
		} catch (IOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void ifLoop() {
		IntegerValue var;
		var = Mockito.mock(IntegerValue.class);
		room.setVariable("var", var);
		
		String code = String.join("\n",
				"if(false) {",
				"var = a }");
		
		ErrorHandler errors = new ErrorHandler();
		InputStream is = new ByteArrayInputStream(code.getBytes(StandardCharsets.UTF_8));
		try {
			ParseTree tree = Demiurgo.parseStream(is, errors);
			CodeVisitor vis = new CodeVisitor(room);
			vis.visit(tree);
			
			verify(var, times(0)).assign(Mockito.any());
		} catch (IOException e) {
			fail(e.getMessage());
		} catch (ValueCastException e) {
			throw new RuntimeException(e);
		}
	}
}
