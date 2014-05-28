package grupo12.Logger.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

/**
 * This class stores the configuration for the @{link Logger},
 * loaded from a file.  
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
	 * Creates the configuration from a file.
	 * 
	 * @param file with the configuration.
	 */
	public Configuration(String file) {
		loadFromFile(file);
	}

	/**
	 * Loads the file and stores the configuration.
	 * If it ocurrs and error with the file, it loads the default configuration.
	 * 
	 * @param file with the configuration.
	 */
	private void loadFromFile(String file) {
		String getFile = this.getClass().getResource("/" + file).getFile();
		InputStream input = null;
		conf = new Properties();
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
	public ArrayList<String> getPatterns() {
		return new ArrayList<String>(Arrays.asList(conf.getProperty("pattern", defaultPattern).split(",")));
	}
}
