package grupo12.Logger.conf;

import java.util.Arrays;
import java.util.List;

/**
 * This class stores the configuration for a single @{link Logger}.
 * 
 * @author Grupo 12
 */
public class Configuration {
	
	public static final String defaultName = "Logger";
	public static final String defaultLevel = "INFO";
	public static final String defaultFormatter = "%d{HH:mm:ss} - %p - %t - %m";
	public static final String defaultOutput = "console";
	public static final String defaultSeparator = "-";
	public static final String defaultFilter = ".*"; // REGEX
	public static final String defaultLevels = "TRACE,DEBUG,INFO,WARNING,ERROR,FATAL";
	
	private String name;
	private String level;
	private String filter;
	private List<String> formatters;
	private List<String> separators;
	private List<String> outputs;
	private List<String> availableLevels;
	
	/**
	 * Creates an empty configuration. Use the "set" methods to load the configuration.
	 */
	public Configuration() {
		name = defaultName;
		level = defaultLevel;
		filter = defaultFilter;
		formatters = Arrays.asList(defaultFormatter.split(","));
		separators = Arrays.asList(defaultSeparator.split(","));
		outputs = Arrays.asList(defaultOutput.split(","));
		availableLevels = Arrays.asList(defaultLevels.split(","));
	}
	
	/**
	 * Returns the name of the Logger.
	 * 
	 * @return name of the logger.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the level of the Logger.
	 * 
	 * @return the level.
	 */
	public String getLevel() {
		return level;
	}
	
	/**
	 * Returns the level of the Logger.
	 * 
	 * @return the level.
	 */
	public String getFilter() {
		return filter;
	}
	/**
	 * Returns a list of separators.
	 * 
	 * @return list of separators.
	 */
	public List<String> getSeparators() {
		return separators;
	}
	
	/**
	 * Returns a list of outputs.
	 * 
	 * @return list of outputs.
	 */
	public List<String> getOutputs() {
		return outputs;
	}

	/**
	 * Returns a list of patterns.
	 * 
	 * @return list of patterns.
	 */
	public List<String> getFormatters() {
		return formatters;
	}
	
	/**
	 * Sets the name of the Logger.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the level.
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	
	/**
	 * Sets the filter.
	 */
	public void setFilter(String filter) {
		this.filter = filter;
	}
	/**
	 * Sets a list of separators.
	 * The separators must be comma-separated.
	 */
	public void setSeparators(String separators) {
		this.separators = Arrays.asList(separators.split(","));
	}
	
	/**
	 * Sets a list of outputs.
	 * The outputs must be comma-separated.
	 */
	public void setOutputs(String outputs) {
		this.outputs = Arrays.asList(outputs.split(","));
	}
	
	/**
	 * Sets a list of formatters.
	 * The formatters must be comma-separated.
	 */
	public void setFormatters(String formatters) {
		this.formatters = Arrays.asList(formatters.split(","));
	}
	
	// TODO: revisar que poner por default.
	public void configureAsDefault() {
		name = defaultName;
		level = defaultLevel;
		filter = defaultFilter;
		formatters = Arrays.asList(defaultFormatter.split(","));
		separators = Arrays.asList(defaultSeparator.split(","));
		outputs = Arrays.asList(defaultOutput.split(","));
		availableLevels = Arrays.asList(defaultLevels.split(","));
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Configuration)) {
			return false;
		}
		
		Configuration other = (Configuration) o;
		
		if (!name.equals(other.name)) {
			return false;
		}
		if (!level.equals(other.level)) {
			return false;
		}
		if (!filter.equals(other.filter)) {
			return false;
		}
		if (!formatters.equals(other.formatters)) {
			return false;
		}
		if (!separators.equals(other.separators)) {
			return false;
		}
		if (!outputs.equals(other.outputs)) {
			return false;
		}
		if (!availableLevels.equals(other.availableLevels)) {
			return false;
		}
		else {
			return true;
		}
		
	
	}
	@Override
	public int hashCode() {
		int h=47;
		int p=37;
		int j=17;
		
		int levelLen = level.length();
		for (int i = 0; i < levelLen; i++) {
		    h = 31*h + level.charAt(i);
		  }
		int nameLen = name.length();
		for (int i = 0; i < nameLen; i++) {
		    p = 31*p + name.charAt(i);
		  }
		int filterLen = filter.length();
		for (int i = 0; i < filterLen; i++) {
		    j = 31*j + filter.charAt(i);
		  }
		return (h*formatters.size())+(p*separators.size())+(j*outputs.size());
	}
	public List<String> getAvailableLevels() {
		return availableLevels;
	}
	
	public void setAvailableLevels(String levels) {
		availableLevels = Arrays.asList(levels.split(","));
	}
}
