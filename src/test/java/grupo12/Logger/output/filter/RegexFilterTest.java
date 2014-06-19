package grupo12.Logger.output.filter;

import static org.junit.Assert.*;
import grupo12.Logger.format.Formatter;
import grupo12.Logger.format.Pattern;
import grupo12.Logger.level.Level;
import grupo12.Logger.message.LogMessage;
import grupo12.Logger.output.filter.Filter;
import grupo12.Logger.output.filter.RegexFilter;

import org.junit.Test;

public class RegexFilterTest {

	private Filter filter;
	private static LogMessage message1 = new LogMessage(Level.INFO, "test message 1", null, null, "Logger");
	private static LogMessage message2 = new LogMessage(Level.WARNING, "test message 2", null, null, "Logger");
	private static LogMessage message3 = new LogMessage(Level.ERROR, "test message 3", null, null, "Logger");
	
	@Test
	public void getRegex() {
		RegexFilter regfilter = new RegexFilter(".*");
		assertEquals(".*", regfilter.getRegex());
	}
	
	@Test
	public void allPass() {
		filter = new RegexFilter(".*");
		
		// Regex: .*  -> all messages pass.
		assertTrue(filter.filter(message1));
		assertTrue(filter.filter(message2));
		assertTrue(filter.filter(message3));
	}
	
	@Test
	public void nothingPass() {
		filter = new RegexFilter("no pass");

		assertFalse(filter.filter(message1));
		assertFalse(filter.filter(message2));
		assertFalse(filter.filter(message3));
	}

	@Test
	public void onlyMessage1Pass() {
		filter = new RegexFilter(".*message 1");

		assertTrue(filter.filter(message1));
		assertFalse(filter.filter(message2));
		assertFalse(filter.filter(message3));
	}
	
	@Test
	public void filterFormattedMessages() {
		filter = new RegexFilter(".*");
		Formatter formatter = new Pattern("%d{HH:mm:ss} %n %p %n %m", "|");
		
		formatter.format(message1);
		formatter.format(message2);
		formatter.format(message3);
		
		assertTrue(filter.filter(message1));
		assertTrue(filter.filter(message2));
		assertTrue(filter.filter(message3));
	}
	
	@Test
	public void filterFormattedMessagesNothingPass() {
		filter = new RegexFilter("nope");
		Formatter formatter = new Pattern("%d{HH:mm:ss} %n %p %n %m", "|");
		
		formatter.format(message1);
		formatter.format(message2);
		formatter.format(message3);
		
		assertFalse(filter.filter(message1));
		assertFalse(filter.filter(message2));
		assertFalse(filter.filter(message3));
	}
	
	@Test
	public void onlyFormattedMessage1Pass() {
		filter = new RegexFilter(".*O INFO O.*");
		Formatter formatter = new Pattern("%d{HH:mm:ss} %n %p %n %m", "O");
		
		formatter.format(message1);
		formatter.format(message2);
		formatter.format(message3);
		
		assertTrue(filter.filter(message1));
		assertFalse(filter.filter(message2));
		assertFalse(filter.filter(message3));
	}
}
