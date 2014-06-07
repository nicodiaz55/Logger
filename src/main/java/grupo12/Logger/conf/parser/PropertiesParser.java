package grupo12.Logger.conf.parser;

import grupo12.Logger.conf.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
	public void loadConfigurations(List<Configuration> configurations) {
		if (!canParse()) {
			return;
		}
		createConfigurations(conf, configurations);
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
			getFile = this.getClass().getResource("/" + file).getFile();
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
	
	/**
	 * Creates a Configuration instance for each {@link grupo12.Logger.api.Logger Logger} named in the properties file, and
	 * stores them in an ArrayList. 
	 */
	private void createConfigurations(Properties conf, List<Configuration> configurations) {
		// We get each name of the Loggers:
		List<String> names = Arrays.asList(conf.getProperty("names").split(","));
		
		// TODO: ver si el null (en asList) pasa:
		if (names != null) {
			String level, filter, formatters, separators, outputs;

			// Create a configuration for each name (Logger):
			for (String name : names) {
				level = conf.getProperty(name + ".level", "");
				filter = conf.getProperty(name + ".filter", "");
				formatters = conf.getProperty(name + ".formatters", "");
				separators = conf.getProperty(name + ".separators", "");
				outputs = conf.getProperty(name + ".outputs", "");

				Configuration aConfiguration = new Configuration();
				aConfiguration.setLevel(level);
				aConfiguration.setFilter(filter);
				aConfiguration.setFormatters(formatters);
				aConfiguration.setSeparators(separators);
				aConfiguration.setOutputs(outputs);
				aConfiguration.setName(name);
				
				configurations.add(aConfiguration);
			}
		}	
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
