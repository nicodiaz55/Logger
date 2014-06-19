package grupo12.Logger.api;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoggerTest {

	@Test
	public void loggerName() {
		Logger logger = new Logger("MyLogger");
		
		assertEquals("MyLogger", logger.getName());
	}
}
