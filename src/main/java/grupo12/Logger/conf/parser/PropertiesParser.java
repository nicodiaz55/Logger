package grupo12.Logger.conf.parser;

import grupo12.Logger.conf.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class PropertiesParser implements Parser {
	
	private Properties conf;
	private String file;
	private boolean ready;
	
	/**
	 * Creates a parser for Properties files, so we can load the configuration for each {@link grupo12.Logger.api.Logger Logger} to create.
	 * 
	 * @param propertiesFile to parse
	 */
	public PropertiesParser(String propertiesFile) {
		file = propertiesFile;
		ready = false;
	}

	/**
	 * Parses a properties file containing the configuration for each {@link grupo12.Logger.api.Logger Logger}.
	 * 
	 * @param a {@link Configuration} List to edit
	 */
	@Override
	public List<Configuration> loadConfigurations() {
		List<Configuration> configurationList = new ArrayList<Configuration>();
		
		if (!canParse()) {
			return configurationList; // empty
		}
		
		// Get each level available:
		String levels = conf.getProperty("levels");
		
		// Get each name of the Loggers:
		List<String> names = Arrays.asList(conf.getProperty("names").split(","));
		
		// Create a configuration for each name: 
		for (String name : names) {
			Configuration configuration = createConfiguration(name, levels);
			configurationList.add(configuration);
		}
		
		return configurationList;
	}

	/**
	 * Loads a Properties file.
	 * 
	 * @param file to load
	 * @return boolean to indicate if the file was loaded correctly or not.
	 */
	public boolean init() {
		String getFile;
		try {
			getFile = this.getClass().getResource("/" + file).toURI().getPath();
		} catch (Exception e) {
			return false;
		}
		
		InputStream input = null;
		conf = new Properties();
		try {
			input = new FileInputStream(getFile);
			conf.load(input);
		} catch (IOException ex) {
			ready = false;
			return false; // empty
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					ready = false;
					return false; // empty
				}
			}
		}
		ready = true;
		return true;
	}
	
	// TODO: revisar que poner por default si getProperty falla (no esta en el archivo)
	/**
	 * Creates a Configuration instance for each {@link grupo12.Logger.api.Logger Logger} name in the properties file
	 */
	private Configuration createConfiguration(String name, String levels) {
		// Get the rest of its parameters:
		String level = conf.getProperty(name + ".level", "");
		String filter = conf.getProperty(name + ".filter", "");
		String formatters = conf.getProperty(name + ".formatters", "");
		String separators = conf.getProperty(name + ".separators", "");
		String outputs = conf.getProperty(name + ".outputs", "");

		Configuration configuration = new Configuration();
		configuration.setName(name);
		configuration.setAvailableLevels(levels);
		configuration.setLevel(level);
		configuration.setFilter(filter);
		configuration.setFormatters(formatters);
		configuration.setSeparators(separators);
		configuration.setOutputs(outputs);
							
		return configuration;
	}

	@Override
	public void setFile(String file) {
		this.file = file;
	}

	@Override
	public boolean canParse() {
		return ready;
	}
}
