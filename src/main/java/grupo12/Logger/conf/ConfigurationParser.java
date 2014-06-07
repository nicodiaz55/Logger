package grupo12.Logger.conf;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import grupo12.Logger.conf.parser.*;


public class ConfigurationParser {
	
	// Default properties and xml configuration files:
	public final String defaultPropertiesFile = "logger-config.properties";
	public final String defaultXMLFile = "logger-config.xml";
	
	// Parsers:
	private static final String propertiesParser = "Properties";
	private static final String xmlParser = "XML";
	
	private List<Configuration> configurations; 
	private Map<String, Parser> parsers;
	
	public ConfigurationParser() {
		configurations = new ArrayList<Configuration>();
		parsers = new LinkedHashMap<String, Parser>(); // keeps the order by insertion of the keys when iterated
		addParsers();
	}
	
	private void addParsers() {
		// We first search for the Properties File:
		parsers.put(propertiesParser, new PropertiesParser(defaultPropertiesFile));
		// Then the XML Parser:
		parsers.put(xmlParser, new XMLParser(defaultXMLFile));
	}
	
	public List<Configuration> getConfigurations() {
		loadConfiguration();
		addDefaultConfiguration(); // We always add it
		return configurations;
	}
	
	private void addDefaultConfiguration() {
		Configuration defconf = new Configuration();
		defconf.configureAsDefault();
		configurations.add(defconf);	
	}

	private void loadConfiguration() {
		// The LinkedHashMap keeps the order of insertion defined in the method addParsers():
		for (Parser parser : parsers.values()) {
			// If the configuration file exists:
			if (parser.init()) {
				parser.loadConfigurations(configurations);
				return;
			}
		}
	}
	
	public void setPropertiesFile(String file) {
		Parser parser = parsers.get(propertiesParser);
		parser.setFile(file);
	}
	
	public void setXMLFile(String file) {
		Parser parser = parsers.get(xmlParser);
		parser.setFile(file);
	}
}
