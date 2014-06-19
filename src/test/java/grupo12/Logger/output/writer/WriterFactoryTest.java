package grupo12.Logger.output.writer;

import static org.junit.Assert.*;
import grupo12.Logger.output.writer.ConsoleWriter;
import grupo12.Logger.output.writer.FileWriter;
import grupo12.Logger.output.writer.WriterFactory;

import org.junit.Test;

public class WriterFactoryTest {

	@Test
	public void getCorrectWriter() {
		WriterFactory factory = new WriterFactory();
		
		assertEquals(new ConsoleWriter(), factory.getWriter("console"));
		assertEquals(new FileWriter("foo"), factory.getWriter("foo"));
	}
	
	@Test
	public void equalsTesting() {
		assertTrue(new ConsoleWriter().equals(new ConsoleWriter()));
		assertFalse(new ConsoleWriter().equals(new FileWriter("foo")));
		assertFalse(new FileWriter("foo").equals(new ConsoleWriter()));
		assertFalse(new FileWriter("foo").equals(new FileWriter("bar")));
		assertTrue(new FileWriter("foo").equals(new FileWriter("foo")));
	}

}