package grupo12.Logger.conf;

import static org.junit.Assert.*;
import grupo12.Logger.conf.Configuration;

import java.util.Arrays;
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
		
		conf1.setName("");
		conf2.setName("");
		conf1.setLevel("");
		conf2.setLevel("");
		conf1.setFormatters("");
		conf2.setFormatters("");
		conf1.setSeparators("");
		conf2.setSeparators("");
		conf1.setOutputs("");
		conf2.setOutputs("");
		conf1.setFilter("1");
		conf2.setFilter("2");
		
		assertFalse(conf1.equals(conf2));
		
		conf1.setName("");
		conf2.setName("");
		conf1.setLevel("");
		conf2.setLevel("");
		conf1.setFormatters("");
		conf2.setFormatters("");
		conf1.setSeparators("");
		conf2.setSeparators("");
		conf1.setOutputs("");
		conf2.setOutputs("");
		conf1.setFilter("");
		conf2.setFilter("");
		conf1.setAvailableLevels("1,2");
		conf2.setAvailableLevels("2");
		
		assertFalse(conf1.equals(conf2));
		
		Object foo = new Object();
		assertFalse(conf1.equals(foo));
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
		
		// Check filter:
		assertEquals(Configuration.defaultFilter, conf.getFilter());
		
		// Check formatters:
		strings = conf.getFormatters();
		assertEquals(1, strings.size());
		assertTrue(strings.contains(Configuration.defaultFormatter));
		
		// Check separators:
		strings = conf.getSeparators();
		assertEquals(1, strings.size());
		assertTrue(strings.contains(Configuration.defaultSeparator));
		
		// Check outputs:
		strings = conf.getOutputs();
		assertEquals(1, strings.size());
		assertTrue(strings.contains(Configuration.defaultOutput));
		
		// Check available levels:
		strings = conf.getAvailableLevels();
		assertEquals(6, strings.size());
		List<String> expected = Arrays.asList(Configuration.defaultLevels.split(","));
		assertEquals(expected, strings);
	}
	
	@Test
	public void sameHashCode(){
		
		Configuration conf1 = new Configuration();
		conf1.setFilter("^[Hh]");
		conf1.setLevel("INFO");
		conf1.setName("Pepe");
		conf1.setOutputs("console,mamasa,out.txt,tuvieja");
		conf1.setSeparators(" ;,-/");
		conf1.setFormatters("%d{HH:mm:ss} - %p - %t - %m");
	
		Configuration conf2 = new Configuration();
		conf2.setFilter("^[Hh]");
		conf2.setLevel("INFO");
		conf2.setName("Pepe");
		conf2.setOutputs("console,mamasa,out.txt,tuvieja");
		conf2.setSeparators(" ;,-/");
		conf2.setFormatters("%d{HH:mm:ss} - %p - %t - %m");
		
		assertTrue(conf1.hashCode()==conf2.hashCode());
	}
}
