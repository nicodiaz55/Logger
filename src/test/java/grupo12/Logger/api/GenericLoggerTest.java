package grupo12.Logger.api;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import grupo12.Logger.level.Level;
import grupo12.Logger.message.LogMessage;
import grupo12.Logger.output.Output;
import grupo12.Logger.output.filter.RegexFilter;
import grupo12.Logger.output.writer.ConsoleWriter;

import org.junit.Before;
import org.junit.Test;

public class GenericLoggerTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	private GenericLogger logger;
	private LogMessage trace;
	private LogMessage debug;
	private LogMessage info;
	private LogMessage warning;
	private LogMessage error;
	private LogMessage fatal;
	
	@Before
	public void setUp() throws Exception {
		logger = new GenericLogger("Test");
		trace = new LogMessage(Level.TRACE, "trace", null, null, "Test");
		debug = new LogMessage(Level.DEBUG, "debug", null, null, "Test");
		info = new LogMessage(Level.INFO, "info", null, null, "Test");
		warning = new LogMessage(Level.WARNING, "warn", null, null, "Test");
		error = new LogMessage(Level.ERROR, "error", null, null, "Test");
		fatal = new LogMessage(Level.FATAL, "fatal", null, null, "Test");
	}
	
	@Test
	public void constructor() {
		assertEquals(null, logger.getLevel());
		assertEquals(null, logger.getFilter());
		assertEquals("Test", logger.getName());
		assertTrue(logger.getOutputs().isEmpty());
	}
	
	@Test
	public void allMessagesAreLoggedIfNoLevelIsSet() {
		assertEquals(null, logger.getLevel());
		
		assertTrue(logger.isPublishable(trace));
		assertTrue(logger.isPublishable(debug));
		assertTrue(logger.isPublishable(info));
		assertTrue(logger.isPublishable(warning));
		assertTrue(logger.isPublishable(error));
		assertTrue(logger.isPublishable(fatal));
		
		assertFalse(logger.isPublishable(null));
	}
	
	@Test
	public void logsOnlyMessagesInLevelRange() {
		logger.setLevel(Level.INFO);
		
		assertEquals(Level.INFO, logger.getLevel());
		
		assertFalse(logger.isPublishable(trace));
		assertFalse(logger.isPublishable(debug));
		assertTrue(logger.isPublishable(info));
		assertTrue(logger.isPublishable(warning));
		assertTrue(logger.isPublishable(error));
		assertTrue(logger.isPublishable(fatal));
		
		assertFalse(logger.isPublishable(null));
	}

	@Test
	public void logAMessage() {
		logger.setLevel(Level.INFO);
		Output output = new Output();
		output.setWriter(new ConsoleWriter());
		logger.addOutput(output);
		assertFalse(logger.getOutputs().isEmpty());
		logger.init();
		
		System.setOut(new PrintStream(outContent));	
		
		logger.log("foo", Level.INFO, null);
		
		assertEquals("foo\n", outContent.toString());
		
		logger.log("bar", Level.TRACE, null);
		
		assertEquals("foo\n", outContent.toString());
		
		System.setOut(null);
		
		logger.end();
	}
	
	@Test
	public void logAMessageWithFilter() {
		logger.setLevel(Level.INFO);
		Output output = new Output();
		output.setWriter(new ConsoleWriter());
		logger.addOutput(output);
		assertFalse(logger.getOutputs().isEmpty());
		
		logger.setFilter(new RegexFilter("bar")); // only log bar messages
		
		logger.init();
		
		System.setOut(new PrintStream(outContent));	
		
		logger.log("foo", Level.INFO, null);
		
		assertEquals("", outContent.toString());
		
		logger.log("bar", Level.TRACE, null);
		
		assertEquals("", outContent.toString());
		
		logger.log("bar", Level.INFO, null);
		
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
		assertFalse(logger.getOutputs().isEmpty());
		
		logger.setFilter(new RegexFilter("bar")); // only log bar messages	
		logger.init();
		System.setOut(new PrintStream(outContent));	
		
		logger.log("foo", Level.INFO, null);
		assertEquals("", outContent.toString());
		
		logger.log("bar", Level.TRACE, null);
		assertEquals("", outContent.toString());
		
		logger.log("bar", Level.INFO, null);
		assertEquals("bar\n", outContent.toString());
		
		logger.turnOff();
		logger.log("bar", Level.INFO, null);
		assertEquals("bar\n", outContent.toString());
		
		logger.turnOn();
		logger.log("bar", Level.INFO, null);
		assertEquals("bar\nbar\n", outContent.toString());		
		
		
		System.setOut(null);
		
		logger.end();
	}
}
