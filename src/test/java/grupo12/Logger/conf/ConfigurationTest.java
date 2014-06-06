package grupo12.Logger.conf;

import static org.junit.Assert.*;
import grupo12.Logger.conf.Configuration;

import java.util.List;

import org.junit.Test;

public class ConfigurationTest {
	
	@Test
	public void defaultConfiguration() {
		// Setup:
		Configuration conf = new Configuration();
		conf.configureAsDefault();
		List<String> strings;
		
		// Check name:
		assertEquals(Configuration.defaultName, conf.getName());
		
		// Check level:
		assertEquals(Configuration.defaultLevel, conf.getLevel());
		
		// Check message format:
		strings = conf.getFormatters();
		assertEquals(1, strings.size());
		assertTrue(strings.contains(Configuration.defaultFormatter));
		
		// Check separator:
		strings = conf.getSeparators();
		assertEquals(1, strings.size());
		assertTrue(strings.contains(Configuration.defaultSeparator));
		
		// Check output:
		strings = conf.getOutputs();
		assertEquals(1, strings.size());
		assertTrue(strings.contains(Configuration.defaultOutput));
	}
}
