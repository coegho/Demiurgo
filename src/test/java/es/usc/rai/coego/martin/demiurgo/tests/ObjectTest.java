package es.usc.rai.coego.martin.demiurgo.tests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;

import es.usc.rai.coego.martin.demiurgo.Demiurgo;
import es.usc.rai.coego.martin.demiurgo.parsing.ClassVisitor;
import es.usc.rai.coego.martin.demiurgo.parsing.CodeVisitor;
import es.usc.rai.coego.martin.demiurgo.parsing.ErrorHandler;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoClass;
import es.usc.rai.coego.martin.demiurgo.universe.DemiurgoRoom;
import es.usc.rai.coego.martin.demiurgo.universe.World;
import es.usc.rai.coego.martin.demiurgo.values.ReturnValueTypes;

public class ObjectTest {
	private World world;
	private DemiurgoRoom room;
	
	
	@Before
	public void setUp() throws Exception {
		world = new World("world1");
		room = new DemiurgoRoom("\room", world, 0);
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
						"int integer\n",
						"str string\n",
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
}
