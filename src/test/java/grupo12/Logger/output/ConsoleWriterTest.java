package grupo12.Logger.output;

import static org.junit.Assert.*;

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
	public void testWrite() {
		Writer console = new ConsoleWriter();
		String message = "test Message";
		
		try {
			console.init();
			console.write(message);
			console.end();
		} catch (NotInitializedException e) {
			fail(e.getMessage());
		}
		
		assertEquals(message + "\n", outContent.toString());
	}

}
