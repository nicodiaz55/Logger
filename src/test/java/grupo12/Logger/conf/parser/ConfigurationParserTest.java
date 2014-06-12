package grupo12.Logger.conf.parser;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import grupo12.Logger.conf.Configuration;
import grupo12.Logger.conf.ConfigurationParser;

import org.junit.Before;
import org.junit.Test;

public class ConfigurationParserTest {

	ConfigurationParser defaultParser;
	
	@Before
	public void setUp() throws Exception {
		defaultParser = new ConfigurationParser(null); // Default parser
	}
	
	@Test
	public void notSupportedFile() {
		ConfigurationParser customParser = new ConfigurationParser("file.txt");
		
		List<Configuration> configurations = customParser.getConfigurations(); 
		
		// Whe should get the default configuration only:
		List<Configuration> expected = new ArrayList<Configuration>();
		Configuration def = new Configuration();
		def.configureAsDefault();
		expected.add(def);
		
		assertEquals(expected, configurations);
	}
	
	@Test
	public void testGetCustomConfigurationsWithPropertiesFile() {
		ConfigurationParser customParser = new ConfigurationParser(ConfigurationParser.defaultPropertiesFile);
		
		// We test if the ConfigurationParser parsed the default properties file:
		List<Configuration> configurations = customParser.getConfigurations(); 
		
		Parser propParser = new PropertiesParser(ConfigurationParser.defaultPropertiesFile);
		propParser.init();
		List<Configuration> expected = propParser.loadConfigurations();
		
		// Don't forget the default configuration:
		Configuration def = new Configuration();
		def.configureAsDefault();
		expected.add(def);
		
		assertEquals(expected, configurations);
	}
	
	@Test
	public void testGetCustomConfigurationsWithXMLFile() {
		ConfigurationParser customParser = new ConfigurationParser(ConfigurationParser.defaultXMLFile);
		
		// We test if the ConfigurationParser parsed the default properties file:
		List<Configuration> configurations = customParser.getConfigurations(); 
		
		Parser xmlParser = new XMLParser(ConfigurationParser.defaultXMLFile);
		xmlParser.init();
		List<Configuration> expected = xmlParser.loadConfigurations();
		
		// Don't forget the default configuration:
		Configuration def = new Configuration();
		def.configureAsDefault();
		expected.add(def);
		
		assertEquals(expected, configurations);
	}
	
	@Test
	public void testGetDefaultConfigurationsWithExistingPropertiesFile() {
		// We test if the ConfigurationParser parsed the default properties file:
		List<Configuration> configurations = defaultParser.getConfigurations(); 
		
		Parser propParser = new PropertiesParser(ConfigurationParser.defaultPropertiesFile);
		propParser.init();
		List<Configuration> expected = propParser.loadConfigurations();
		
		// Don't forget the default configuration:
		Configuration def = new Configuration();
		def.configureAsDefault();
		expected.add(def);
		
		assertEquals(expected, configurations);
	}

	@Test
	public void testGetDefaultConfigurationsWithExistingXMLFile() {
		// We test if the ConfigurationParser parsed the default xml file:
		
		// We set a properties file that doesn't exists first, so it looks for the xml instead:
		defaultParser.setPropertiesFile("");
		
		List<Configuration> configurations = defaultParser.getConfigurations();
		
		Parser xmlParser = new XMLParser(ConfigurationParser.defaultXMLFile);
		xmlParser.init();
		List<Configuration> expected = xmlParser.loadConfigurations();
		
		// Don't forget the default configuration:
		Configuration def = new Configuration();
		def.configureAsDefault();
		expected.add(def);
		
		assertEquals(expected, configurations);
	}
	
	@Test
	public void testGetDefaultConfigurationsWithoutConfigurationFiles() {
		// We test if the ConfigurationParser parsed the default configuration:
		
		// We set a properties file that doesn't exists first, so it looks for the xml instead:
		defaultParser.setPropertiesFile("");
		// And also a xml file that doesn't exists, so it loads the default configuration:
		defaultParser.setXMLFile("");
		
		List<Configuration> configurations = defaultParser.getConfigurations();
		List<Configuration> expected = new ArrayList<Configuration>();
		
		// The default configuration:
		Configuration configuration = new Configuration();
		configuration.configureAsDefault();
		expected.add(configuration);
		
		assertEquals(expected, configurations);
	}
}
