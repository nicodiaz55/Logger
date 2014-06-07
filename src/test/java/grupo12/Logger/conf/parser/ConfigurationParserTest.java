package grupo12.Logger.conf.parser;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import grupo12.Logger.conf.Configuration;
import grupo12.Logger.conf.ConfigurationParser;

import org.junit.Before;
import org.junit.Test;

public class ConfigurationParserTest {

	ConfigurationParser parser;
	
	@Before
	public void setUp() throws Exception {
		parser = new ConfigurationParser();
	}
	
	@Test
	public void testGetConfigurationsWithExistingPropertiesFile() {
		// We test if the ConfigurationParser parsed the default properties file:
		List<Configuration> configurations = parser.getConfigurations();
		List<Configuration> expected = new ArrayList<Configuration>();
		
		Parser propParser = new PropertiesParser(parser.defaultPropertiesFile);
		propParser.init();
		propParser.loadConfigurations(expected);
		
		// Don't forget the default configuration:
		Configuration def = new Configuration();
		def.configureAsDefault();
		expected.add(def);
		
		assertEquals(expected, configurations);
	}

	@Test
	public void testGetConfigurationsWithExistingXMLFile() {
		// We test if the ConfigurationParser parsed the default xml file:
		
		// We set a properties file that doesn't exists first, so it looks for the xml instead:
		parser.setPropertiesFile("");
		
		List<Configuration> configurations = parser.getConfigurations();
		List<Configuration> expected = new ArrayList<Configuration>();
		
		Parser xmlParser = new XMLParser(parser.defaultXMLFile);
		xmlParser.init();
		xmlParser.loadConfigurations(expected);
		
		// Don't forget the default configuration:
		Configuration def = new Configuration();
		def.configureAsDefault();
		expected.add(def);
		
		assertEquals(expected, configurations);
	}
	
	@Test
	public void testGetConfigurationsWithoutConfigurationFiles() {
		// We test if the ConfigurationParser parsed the default configuration:
		
		// We set a properties file that doesn't exists first, so it looks for the xml instead:
		parser.setPropertiesFile("");
		// And also a xml file that doesn't exists, so it loads the default configuration:
		parser.setXMLFile("");
		
		List<Configuration> configurations = parser.getConfigurations();
		List<Configuration> expected = new ArrayList<Configuration>();
		
		// The default configuration:
		Configuration configuration = new Configuration();
		configuration.configureAsDefault();
		expected.add(configuration);
		
		assertEquals(expected, configurations);
	}
}
