package grupo12.Logger.api;

import static org.junit.Assert.*;
import grupo12.Logger.level.Level;
import grupo12.Logger.output.Output;
import grupo12.Logger.output.filter.RegexFilter;
import grupo12.Logger.output.writer.ConsoleWriter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class LoggerTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	private Logger logger;
	
	@Before
	public void setUp() throws Exception {
		logger = new Logger("Test");
	}
	
	@Test
	public void contructor() {
		assertEquals(null, logger.getLevel());
		assertEquals("Test", logger.getName());
	}
	
	@Test
	public void logAMessage() {
		logger.setLevel(Level.FATAL);
		Output output = new Output();
		output.setWriter(new ConsoleWriter());
		logger.addOutput(output);
		logger.init();
		
		System.setOut(new PrintStream(outContent));	
			
		logger.trace("bar1", null);
		logger.trace("bar1");
		logger.debug("bar2", null);
		logger.debug("bar2");
		logger.info("bar3", null);
		logger.info("bar3");
		logger.warn("bar4", null);
		logger.warn("bar4");
		logger.error("bar5", null);
		logger.error("bar5");
		logger.fatal("foo", null);
		logger.fatal("foo");
		
		assertEquals("foo\nfoo\n", outContent.toString());
		
		System.setOut(null);
		
		logger.end();
	}
	
	@Test
	public void logAMessageWithFilter() {
		logger.setLevel(Level.INFO);
		Output output = new Output();
		output.setWriter(new ConsoleWriter());
		logger.addOutput(output);
		
		logger.setFilter(new RegexFilter("bar")); // only log bar messages
		
		logger.init();
		
		System.setOut(new PrintStream(outContent));	
		
		logger.info("foo");
		
		assertEquals("", outContent.toString());
		
		logger.trace("bar");
		
		assertEquals("", outContent.toString());
		
		logger.info("bar");
		
		assertEquals("bar\n", outContent.toString());
		
		System.setOut(null);
		
		logger.end();
	}
	
	@Test
	public void turnOnAndTurnOffTheLogger() {
		logger.setLevel(Level.INFO);
		Output output = new Output();
		output.setWriter(new ConsoleWriter());
		logger.addOutput(output);
		
		logger.setFilter(new RegexFilter("bar")); // only log bar messages	
		logger.init();
		System.setOut(new PrintStream(outContent));	
		
		logger.info("foo", null);
		assertEquals("", outContent.toString());
		
		logger.trace("bar", null);
		assertEquals("", outContent.toString());
		
		logger.info("bar", null);
		assertEquals("bar\n", outContent.toString());
		
		logger.turnOff();
		logger.info("bar", null);
		assertEquals("bar\n", outContent.toString());
		
		logger.turnOn();
		logger.info("bar", null);
		assertEquals("bar\nbar\n", outContent.toString());		
		
		
		System.setOut(null);
		
		logger.end();
	}
}
