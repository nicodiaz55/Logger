package grupo12.Logger.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

/**
 * This class stores the configuration for a single @{link Logger}.
 * 
 * @author Grupo 12
 */
public class Configuration {
	
	public static final String defaultLevel = "INFO";
	public static final String defaultPattern = "%d{HH:mm:ss} - %p - %t - %m";
	public static final String defaultOutput = "console";
	public static final String defaultSeparator = "-";
	
	private Properties conf;
	
	/**
	 * Creates an empty configuration. Use the "set" methods to load the configuration.
	 */
	public Configuration() {
		conf = new Properties();
	}
	
	/**
	 * Creates the configuration from a properties file.
	 * Use only if the file contains a single {@link Logger} configuration.
	 * 
	 * @param file with the configuration of the logger.
	 */
	public Configuration(String file) {
		this();
		loadFromFile(file);
	}

	
	/**
	 * Loads a properties file and stores the configuration.
	 * If it ocurrs and error with the file, it loads the default configuration.
	 * 
	 * @param file with the configuration.
	 */
	private void loadFromFile(String file) {
		String getFile = this.getClass().getResource("/" + file).getFile();
		InputStream input = null;
		try {
			input = new FileInputStream(getFile);
			conf.load(input);
		} catch (IOException ex) {
			//ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					//e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Returns the name of the Logger.
	 * 
	 * @return name of the logger.
	 */
	public String getName() {
		return conf.getProperty("name");
	}
	
	/**
	 * Returns a list of levels.
	 * 
	 * @return list of levels.
	 */
	public ArrayList<String> getLevels() {
		return new ArrayList<String>(Arrays.asList(conf.getProperty("level", defaultLevel).split(",")));
	}
	
	/**
	 * Returns a list of separators.
	 * 
	 * @return list of separators.
	 */
	public ArrayList<String> getSeparators() {
		return new ArrayList<String>(Arrays.asList(conf.getProperty("separator", defaultSeparator).split(",")));
	}
	
	/**
	 * Returns a list of outputs.
	 * 
	 * @return list of outputs.
	 */
	public ArrayList<String> getOutputs() {
		return new ArrayList<String>(Arrays.asList(conf.getProperty("output", defaultOutput).split(",")));
	}

	/**
	 * Returns a list of patterns.
	 * 
	 * @return list of patterns.
	 */
	public ArrayList<String> getFormatters() {
		return new ArrayList<String>(Arrays.asList(conf.getProperty("pattern", defaultPattern).split(",")));
	}
	
	/**
	 * Sets the name of the Logger.
	 */
	public void setName(String name) {
		conf.setProperty("name", name);
	}
	
	/**
	 * Sets the list of levels.
	 * The levels must be comma-separated.
	 */
	public void setLevels(String levels) {
		conf.setProperty("level", levels);
	}
	
	/**
	 * Sets a list of separators.
	 * The separators must be comma-separated.
	 */
	public void setSeparators(String separators) {
		conf.setProperty("separator", separators);
	}
	
	/**
	 * Sets a list of outputs.
	 * The outputs must be comma-separated.
	 */
	public void setOutputs(String outputs) {
		conf.setProperty("output", outputs);
	}

	/**
	 * Sets a list of formatters.
	 * The formatters must be comma-separated.
	 */
	public void setFormatters(String formatters) {
		conf.setProperty("pattern", formatters);
	}
}
