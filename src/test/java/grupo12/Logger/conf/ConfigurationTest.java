package grupo12.Logger.conf;

import static org.junit.Assert.*;
import grupo12.Logger.conf.Configuration;

import java.util.List;

import org.junit.Test;

public class ConfigurationTest {
	
	@Test
	public void equalsConfiguration() {
		Configuration conf1 = new Configuration();
		Configuration conf2 = new Configuration();
		
		conf1.configureAsDefault();
		conf2.configureAsDefault();
		
		assertTrue(conf1.equals(conf2));
	}

	@Test
	public void notEqualsConfiguration() {
		Configuration conf1 = new Configuration();
		Configuration conf2 = new Configuration();
		
		conf1.setName("1");
		conf2.setName("2");
		
		assertFalse(conf1.equals(conf2));
		
		conf1.setName("");
		conf2.setName("");
		conf1.setLevel("1");
		conf2.setLevel("2");
		
		assertFalse(conf1.equals(conf2));
		
		conf1.setName("");
		conf2.setName("");
		conf1.setLevel("");
		conf2.setLevel("");
		conf1.setFormatters("1");
		conf2.setFormatters("2");
		
		assertFalse(conf1.equals(conf2));
		
		conf1.setName("");
		conf2.setName("");
		conf1.setLevel("");
		conf2.setLevel("");
		conf1.setFormatters("");
		conf2.setFormatters("");
		conf1.setSeparators("1");
		conf2.setSeparators("2");
		
		assertFalse(conf1.equals(conf2));
		
		conf1.setName("");
		conf2.setName("");
		conf1.setLevel("");
		conf2.setLevel("");
		conf1.setFormatters("");
		conf2.setFormatters("");
		conf1.setSeparators("");
		conf2.setSeparators("");
		conf1.setOutputs("1");
		conf2.setOutputs("2");
		
		assertFalse(conf1.equals(conf2));
	}
	
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
