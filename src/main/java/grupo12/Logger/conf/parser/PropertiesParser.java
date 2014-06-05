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
	
	/**
	 * Creates a parser for Properties files, so we can load the configuration for each {@link grupo12.Logger.api.Logger Logger} to create.
	 */
	public PropertiesParser(String propertiesFile) {
		file = propertiesFile;
	}

	/**
	 * Parses a properties file containing the configuration for each {@link grupo12.Logger.api.Logger Logger}.
	 * 
	 * @return a {@link Configuration} List
	 */
	@Override
	public void loadConfigurations(List<Configuration> configurations) {
		createConfigurations(conf, configurations);
	}

	/**
	 * Loads a Properties file.
	 * 
	 * @param file to load
	 * @return boolean to indicate if the file was loaded correctly or not.
	 */
	public boolean init() {
		String getFile = this.getClass().getResource("/" + file).getFile();
		
		InputStream input = null;
		conf = new Properties();
		try {
			input = new FileInputStream(getFile);
			conf.load(input);
		} catch (IOException ex) {
			return false; // empty
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					return false; // empty
				}
			}
		}
		return true;
	}
	
	/**
	 * Creates a Configuration instance for each {@link grupo12.Logger.api.Logger Logger} named in the properties file, and
	 * stores them in an ArrayList. 
	 */
	private void createConfigurations(Properties conf, List<Configuration> configurations) {
		// We get each name of the Loggers:
		ArrayList<String> names = new ArrayList<String>(Arrays.asList(conf.getProperty("names").split(",")));;
		
		// TODO: ver si el null (en asList) pasa:
		if (names != null) {
			String levels, formatters, separators, outputs;

			// Create a configuration for each name (Logger):
			for (String name : names) {
				levels = conf.getProperty(name + ".levels");
				formatters = conf.getProperty(name + ".formatters");
				separators = conf.getProperty(name + ".separators");
				outputs = conf.getProperty(name + ".outputs");
				
				Configuration aConfiguration = new Configuration();
				aConfiguration.setLevels(levels);
				aConfiguration.setFormatters(formatters);
				aConfiguration.setSeparators(separators);
				aConfiguration.setOutputs(outputs);
				aConfiguration.setName(name);
				
				configurations.add(aConfiguration);
			}
		}	
	}
}
