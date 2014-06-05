package grupo12.Logger.conf;

import java.util.ArrayList;
import java.util.List;

import grupo12.Logger.conf.parser.*;


public class ConfigurationParser {
	
	private static final String propertiesFile = "logger-config.properties";
	private static final String xmlFile = "logger-config.xml";
	
	private List<Configuration> configurations; 
	private List<Parser> parsers;
	
	public ConfigurationParser() {
		configurations = new ArrayList<Configuration>();
		parsers = new ArrayList<Parser>();
		parsers.add(new PropertiesParser(propertiesFile));
		parsers.add(new XMLParser(xmlFile));
	}
	
	
	public List<Configuration> getConfigurations() {
		loadConfiguration();
		return configurations;
	}
	
	private void loadConfiguration() {		
		for (Parser parser : parsers) {
			// If the configuration file exists:
			if (parser.init()) {
				parser.loadConfigurations(configurations);
				return;
			}
		}
	}	
}
