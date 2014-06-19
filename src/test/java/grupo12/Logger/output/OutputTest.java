package grupo12.Logger.output;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import grupo12.Logger.format.Formatter;
import grupo12.Logger.format.JsonFormatter;
import grupo12.Logger.format.Pattern;
import grupo12.Logger.level.Level;
import grupo12.Logger.message.LogMessage;
import grupo12.Logger.output.filter.Filter;
import grupo12.Logger.output.filter.RegexFilter;
import grupo12.Logger.output.writer.ConsoleWriter;
import grupo12.Logger.output.writer.FileWriter;
import grupo12.Logger.output.writer.Writer;

import org.junit.Before;
import org.junit.Test;

public class OutputTest {

	private Output output;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUp() throws Exception {
		output = new Output();
	}
	
	@Test
	public void initAnOutputWithABadWriter() {
		System.setOut(new PrintStream(outContent));
		Writer writer = new FileWriter(null); // bad file writer.
		output.setWriter(writer);
		output.init();
		assertFalse(output.isOn());
		assertTrue(outContent.toString().contains("Warning: Output not initialized. Reason: "));
		System.setOut(null);
	}
	
	@Test
	public void isOffWithoutWriterAndFormatter() {
		output.init();
		assertFalse(output.isOn());
		output.setFormatter(null);
		output.setWriter(null);
		assertFalse(output.isOn());
	}

	@Test
	public void isOffWithFormatterButNoWriter() {
		Formatter formatter = new JsonFormatter();
		output.setFormatter(formatter);;
		output.init();
		assertFalse(output.isOn());
	}
	
	@Test
	public void isOnWithWriterButNoFormatter() {
		Writer aWriter = new ConsoleWriter();
		output.setWriter(aWriter);
		output.init();
		assertTrue(output.isOn());
	}
	
	@Test
	public void endOutputSetsItOff() {
		Writer aWriter = new ConsoleWriter();
		output.setWriter(aWriter);
		
		output.init();
		assertTrue(output.isOn());

		output.end();
		assertFalse(output.isOn());
	}
	
	@Test
	public void endOutputWithoutWriterStaysOff() {
		
		output.init();
		assertFalse(output.isOn());

		output.end();
		assertFalse(output.isOn());
	}
	
	@Test
	public void changeWriter() {
		Writer aWriter = new ConsoleWriter();
		output.setWriter(aWriter);
		output.init();
		assertTrue(output.isOn());
		
		Writer otherWriter = new FileWriter("testFile.txt");
		output.setWriter(otherWriter);
		assertFalse(output.isOn());
		
		output.init();
		assertTrue(output.isOn());
		output.end();
		assertFalse(output.isOn());
		
		File file = new File("testFile.txt");
		file.delete();
	}
	
	@Test
	public void turnOnAnEndedOutputDoesntTurnsOn() {
		Writer aWriter = new ConsoleWriter();
		output.setWriter(aWriter);
		output.init();
		assertTrue(output.isOn());

		output.end();
		assertFalse(output.isOn());
		
		output.turnOn();
		assertFalse(output.isOn());
	}
	
	@Test
	public void turnOnAnOutput() {
		Writer aWriter = new ConsoleWriter();
		output.setWriter(aWriter);
		output.init();
		assertTrue(output.isOn());
		
		output.turnOn();
		assertTrue(output.isOn());
	}
	
	@Test
	public void turnOff() {
		Writer aWriter = new ConsoleWriter();
		output.setWriter(aWriter);
		output.init();
		assertTrue(output.isOn());
		
		output.turnOff();
		assertFalse(output.isOn());
	}
	
	@Test
	public void turnOffWithoutWriter() {
		output.init();
		assertFalse(output.isOn());
		
		output.turnOff();
		assertFalse(output.isOn());
	}
	
	@Test
	public void turnOnAnOutputAfterTurnedItOff() {
		Writer aWriter = new ConsoleWriter();
		output.setWriter(aWriter);
		output.init();
		assertTrue(output.isOn());
		
		output.turnOff();
		output.turnOn();
		assertTrue(output.isOn());
	}
	
	@Test
	public void logsIfTurnedOn() {
		System.setOut(new PrintStream(outContent));
		Writer aWriter = new ConsoleWriter();
		output.setWriter(aWriter);
		output.init();		
		output.log(new LogMessage(Level.INFO, "message", null, null, "logger"));
		assertEquals("message\n", outContent.toString());
		System.setOut(null);
	}
	
	@Test
	public void logsIfTurnedOnWithFormatter() {
		System.setOut(new PrintStream(outContent));
		Formatter formatter = new Pattern("%p %n %m", "-");
		Writer aWriter = new ConsoleWriter();
		output.setWriter(aWriter);
		output.setFormatter(formatter);
		output.init();		
		output.log(new LogMessage(Level.INFO, "message", null, null, "logger"));
		assertEquals("INFO - message\n", outContent.toString());
		System.setOut(null);
	}
	
	@Test
	public void wontLogIfTurnedOff() {
		System.setOut(new PrintStream(outContent));
		Writer aWriter = new ConsoleWriter();
		output.setWriter(aWriter);
		output.init();		
		output.turnOff();
		output.log(new LogMessage(Level.INFO, "message", null, null, "logger"));
		assertEquals("", outContent.toString());
		System.setOut(null);
	}
	
	@Test
	public void logsWithoutFormatterAndWithoutFilter() {
		System.setOut(new PrintStream(outContent));
		Writer aWriter = new ConsoleWriter();
		output.setWriter(aWriter);
		output.init();		
		output.log(new LogMessage(Level.INFO, "message", null, new Exception(), "logger"));
		assertEquals("message\n", outContent.toString());
		System.setOut(null);
	}
	
	@Test
	public void logsWithoutFormatter() {
		System.setOut(new PrintStream(outContent));
		Writer aWriter = new ConsoleWriter();
		Filter aFilter = new RegexFilter(".*");
		output.setWriter(aWriter);
		output.setFilter(aFilter);
		output.init();		
		output.log(new LogMessage(Level.INFO, "message", null, new Exception(), "logger"));
		assertEquals("message\n", outContent.toString());
		System.setOut(null);
	}
	
	@Test
	public void doesNotLogsBecauseFilterWithoutFormatter() {
		System.setOut(new PrintStream(outContent));
		Writer aWriter = new ConsoleWriter();
		Filter aFilter = new RegexFilter("NO");
		output.setWriter(aWriter);
		output.setFilter(aFilter);
		output.init();		
		output.log(new LogMessage(Level.INFO, "message", null, new Exception(), "logger"));
		assertEquals("", outContent.toString());
		System.setOut(null);
	}
	
	@Test
	public void doesNotLogsBecauseFilter() {
		System.setOut(new PrintStream(outContent));
		Writer aWriter = new ConsoleWriter();
		Filter aFilter = new RegexFilter("WARNING - message");
		Formatter aFormatter = new Pattern("%p - %m", "-");
		output.setWriter(aWriter);
		output.setFilter(aFilter);
		output.setFormatter(aFormatter);
		output.init();		
		output.log(new LogMessage(Level.INFO, "message", null, new IOException(), "logger"));
		assertEquals("", outContent.toString());
		System.setOut(null);
	}
}
