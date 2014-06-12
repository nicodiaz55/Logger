package grupo12.Logger.conf;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import grupo12.Logger.conf.parser.*;


public class ConfigurationParser {
	
	// Default properties and xml configuration files:
	public final static String defaultPropertiesFile = "logger-config.properties";
	public final static String defaultXMLFile = "logger-config.xml";
	
	// Parsers:
	private static final String propertiesParser = "properties";
	private static final String xmlParser = "xml";
	
	private List<Configuration> configurations; 
	private Map<String, Parser> parsers;
	
	public ConfigurationParser(String file) {
		configurations = null;
		parsers = new LinkedHashMap<String, Parser>(); // keeps the order by insertion of the keys when iterated
		if (file == null) {
			addDefaultParsers();
		} else {
			addCustomParser(file);
		}
		
	}
	
	private void addCustomParser(String file) {
		ParserFactory factory = new ParserFactory();
		Parser parser = factory.getParser(file);
		if (parser != null) {
			String fileType = file.substring(file.lastIndexOf("."));
			parsers.put(fileType, parser);
		}
	}

	private void addDefaultParsers() {
		// We first search for the Properties File:
		parsers.put(propertiesParser, new PropertiesParser(defaultPropertiesFile));
		// Then the XML Parser:
		parsers.put(xmlParser, new XMLParser(defaultXMLFile));
	}
	
	public List<Configuration> getConfigurations() {
		configurations = loadConfiguration();
		addDefaultConfiguration(); // We always add it
		return configurations;
	}
	
	private void addDefaultConfiguration() {
		Configuration defconf = new Configuration();
		defconf.configureAsDefault();
		configurations.add(defconf);	
	}

	private List<Configuration> loadConfiguration() {
		// The LinkedHashMap keeps the order of insertion defined in the method addParsers():
		for (Parser parser : parsers.values()) {
			// If the configuration file exists:
			if (parser.init()) {
				return parser.loadConfigurations();
			}
		}
		return new ArrayList<Configuration>();
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
