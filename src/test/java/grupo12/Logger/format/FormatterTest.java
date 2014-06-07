package grupo12.Logger.format;

import static org.junit.Assert.*;
import grupo12.Logger.level.Level;
import grupo12.Logger.message.LogMessage;

import org.junit.Before;
import org.junit.Test;

public class FormatterTest {

	Formatter formatter;
	LogMessage message;
	
	@Before
	public void setUp() throws Exception {
		message = new LogMessage(Level.INFO, "Test message", null, null, "MyLogger");
	}
	
	@Test
	public void JSONFormat() {
		formatter = new JsonFormatter();
		
		formatter.format(message);
		
		String expected = "{‘datetime’: ‘" + message.getTimestamp().toString() + "’, ‘level’: ‘" + message.getLevel().toString() + "’, ‘logger’: ‘" + message.getLoggerName() + "’, ‘message’: ‘" + message.getMessage() + "’}";
		
		assertEquals(expected, message.toString());
	}

	@Test
	public void formatterFactoryReturnsCorrectFormatter() {
		FormatterFactory factory = new FormatterFactory();
		Formatter formatter = factory.getFormatter("%d{HH:mm:ss}", "-");
		
		assertEquals(new Pattern("%d{HH:mm:ss}", "-"), formatter);
		
		formatter = factory.getFormatter("JSON", "/");
		
		assertEquals(new JsonFormatter(), formatter);
	}
}
