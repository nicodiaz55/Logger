package grupo12.Logger.output.writer;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;

public class CustomWriterTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private Writer writer;
	
	@Test
	public void badCustomWriterCantWrite() throws NotInitializedException {
		writer = new CustomWriter("this class doesn't exists.class", new ArrayList<String>());
		assertFalse(writer.canWrite());
		try {
			writer.init();
			fail("The writer should not be initialized");
		} catch (NotInitializedException e) {
			assertFalse(writer.canWrite());
		}
		writer.end();
		assertFalse(writer.canWrite());
	}

	@Test
	public void goodCustomWriterCanWrite() throws NotInitializedException {
		// It's a console writer:
		writer = new CustomWriter("grupo12.Logger.output.writer.Foo.class", new ArrayList<String>());
		assertFalse(writer.canWrite());
		writer.init();
		assertTrue(writer.canWrite());
	}

	@Test
	public void goodCustomWriterWrites() throws NotInitializedException {
		System.setOut(new PrintStream(outContent));	
		// It's a console writer:
		writer = new CustomWriter("grupo12.Logger.output.writer.Foo.class", new ArrayList<String>());
		writer.init();
		writer.write("foo message");
		assertEquals("foo message" + "\n", outContent.toString());
		System.setOut(null);
		writer.end();
		assertFalse(writer.canWrite());
	}
	
	@Test
	public void goodCustomCantWriteIfNotInitialized() throws NotInitializedException {
		System.setOut(new PrintStream(outContent));	
		// It's a console writer:
		writer = new CustomWriter("grupo12.Logger.output.writer.Foo.class", new ArrayList<String>());
		assertFalse(writer.canWrite());
		writer.write("foo message");
		assertFalse(writer.canWrite());
		assertEquals("", outContent.toString());
		System.setOut(null);
		writer.end();
		assertFalse(writer.canWrite());
	}
}
