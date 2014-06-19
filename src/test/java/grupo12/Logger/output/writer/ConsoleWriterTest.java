package grupo12.Logger.output.writer;

import static org.junit.Assert.*;
import grupo12.Logger.output.writer.ConsoleWriter;
import grupo12.Logger.output.writer.NotInitializedException;
import grupo12.Logger.output.writer.Writer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConsoleWriterTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
	@Test
	public void testWrite() throws NotInitializedException {
		Writer console = new ConsoleWriter();
		String message = "test Message";
		
		console.init();
		assertTrue(console.canWrite());
		console.write(message);
		console.end();
		
		assertEquals(message + "\n", outContent.toString());
	}

}
