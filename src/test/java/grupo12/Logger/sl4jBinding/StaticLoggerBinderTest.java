package grupo12.Logger.sl4jBinding;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

public class StaticLoggerBinderTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void overallTest() {
		
		StaticLoggerBinder slb = StaticLoggerBinder.getSingleton();
		ILoggerFactory  adapterFactory = slb.getLoggerFactory();
		Logger logger = adapterFactory.getLogger("LoggerSlf4j");
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		logger.trace("bar1");
		logger.debug("bar2");
		logger.info("bar3");
		logger.warn("bar4");
		logger.error("bar5");
		logger.getName();
		
		assertEquals("LoggerSlf4j / bar1\nLoggerSlf4j / bar2\nLoggerSlf4j / bar3\nLoggerSlf4j / bar4\nLoggerSlf4j / bar5\n", outContent.toString());
		assertEquals(logger.getName(),"LoggerSlf4j");
		assertTrue(logger.isDebugEnabled());
		assertTrue(logger.isErrorEnabled());
		assertTrue(logger.isInfoEnabled());
		assertTrue(logger.isTraceEnabled());
		assertTrue(logger.isWarnEnabled());
		
	}

}
