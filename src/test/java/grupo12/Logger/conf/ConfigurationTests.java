package grupo12.Logger.conf;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class ConfigurationTests {
	
	@Test
	public void defaultConfiguration() {
		// Setup:
		Configuration conf = new Configuration("default.cfg");
		List<String> strings;
		
		// Check level:
		strings = conf.getLevels();
		assertEquals(1, strings.size());
		assertTrue(strings.contains(Configuration.defaultLevel));
		
		// Check message format:
		strings = conf.getPatterns();
		assertEquals(1, strings.size());
		assertTrue(strings.contains(Configuration.defaultPattern));
		
		// Check separator:
		strings = conf.getSeparators();
		assertEquals(1, strings.size());
		assertTrue(strings.contains(Configuration.defaultSeparator));
		
		// Check output:
		strings = conf.getOutputs();
		assertEquals(1, strings.size());
		assertTrue(strings.contains(Configuration.defaultOutput));
	}
	
	@Test
	// Tests a multiple configuration (multiple outputs, patterns, levels and separators)
	public void customConfiguration() {
		// Setup:
		Configuration conf = new Configuration("user.cfg");
		List<String> strings;
		
		// Check levels:
		strings = conf.getLevels();
		assertEquals(3, strings.size());
		assertEquals("INFO",strings.get(0));
		assertEquals("DEBUG",strings.get(1));
		assertEquals("FATAL",strings.get(2));
		
		// Check message formats:
		strings = conf.getPatterns();
		assertEquals(3, strings.size());
		assertEquals("%d{HH:mm:ss} %n %m", strings.get(0));
		assertEquals("%d{HH:mm:ss} %n %p %n %m", strings.get(1));
		assertEquals("%d{HH:mm:ss} %n %t %n %m", strings.get(2));
		
		// Check separators:
		strings = conf.getSeparators();
		assertEquals(3, strings.size());
		assertEquals("|", strings.get(0));
		assertEquals("-", strings.get(1));
		assertEquals("/", strings.get(2));
		
		// Check outputs:
		strings = conf.getOutputs();
		assertEquals(3, strings.size());
		assertEquals("log1.txt", strings.get(0));
		assertEquals("log2.txt", strings.get(1));
		assertEquals("console", strings.get(2));
	}

	@Test
	public void loadFileWithoutLevelInfo() {
		// Setup:
		Configuration conf = new Configuration("withoutLevels.cfg");
		List<String> strings;
		
		// Check level:
		strings = conf.getLevels();
		assertEquals(1, strings.size());
		assertTrue(strings.contains(Configuration.defaultLevel));
	}
	
	@Test
	public void loadFileWithoutOutputsInfo() {
		// Setup:
		Configuration conf = new Configuration("withoutOutputs.cfg");
		List<String> strings;
		
		// Check level:
		strings = conf.getOutputs();
		assertEquals(1, strings.size());
		assertTrue(strings.contains(Configuration.defaultOutput));
	}
	
	@Test
	public void loadFileWithoutPatternsInfo() {
		// Setup:
		Configuration conf = new Configuration("withoutPatterns.cfg");
		List<String> strings;
		
		// Check level:
		strings = conf.getPatterns();
		assertEquals(1, strings.size());
		assertTrue(strings.contains(Configuration.defaultPattern));
	}
	
	@Test
	public void loadFileWithoutSeparatorInfo() {
		// Setup:
		Configuration conf = new Configuration("withoutSeparators.cfg");
		List<String> strings;
		
		// Check level:
		strings = conf.getSeparators();
		assertEquals(1, strings.size());
		assertTrue(strings.contains(Configuration.defaultSeparator));
	}
}
