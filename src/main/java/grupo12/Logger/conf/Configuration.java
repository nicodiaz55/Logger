package grupo12.Logger.conf;

import java.util.ArrayList;
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
	
	private List<String> levels;
	private List<String> formatters;
	private List<String> separators;
	private List<String> outputs;
	private String name;
	
	/**
	 * Creates an empty configuration. Use the "set" methods to load the configuration.
	 */
	public Configuration() {
		name = "";
		levels = null;
		formatters = null;
		separators = null;
		outputs = null;
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
	 * Returns a list of levels.
	 * 
	 * @return list of levels.
	 */
	public List<String> getLevels() {
		return levels;
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
	 * Sets the list of levels.
	 * The levels must be comma-separated.
	 */
	public void setLevels(String levels) {
		this.levels = Arrays.asList(levels.split(","));
	}
	
	/**
	 * If it exists, it adds a level to the end of the levels array list
	 * @param level to be added
	 */
	public void addLevel(String level) {
		if (this.levels == null){
			this.levels = Arrays.asList(level.split(","));
		} else {
			levels.add(level);
		}
	}
	
	/**
	 * Sets a list of separators.
	 * The separators must be comma-separated.
	 */
	public void setSeparators(String separators) {
		this.separators = Arrays.asList(separators.split(","));
	}
	
	/**
	 * If it exists, it adds a separator to the end of the separators array list
	 * @param separator to be added
	 */
	public void addSeparator(String separator){
		if (this.separators == null) {
			this.separators = new ArrayList<String>(Arrays.asList(separator.split(",")));
		} else {
			separators.add(separator);
		}
	}
	
	/**
	 * Sets a list of outputs.
	 * The outputs must be comma-separated.
	 */
	public void setOutputs(String outputs) {
		this.outputs = Arrays.asList(outputs.split(","));
	}
	
	/**
	 * If it exists, it adds an output to the end of the outputs array list
	 * @param output to be added
	 */
	public void addOutput(String output) {
		if (this.outputs == null) {
			this.outputs = Arrays.asList(output.split(","));
		} else {
			outputs.add(output);
		}
	}
	
	/**
	 * Sets a list of formatters.
	 * The formatters must be comma-separated.
	 */
	public void setFormatters(String formatters) {
		this.formatters = Arrays.asList(formatters.split(","));
	}
	
	/**
	 * If it exists, it adds a formatter to the end of the formatters array list
	 * @param formatter to be added
	 */
	public void addFormatter(String formatter) {
		if (this.formatters == null) {
			this.formatters = Arrays.asList(formatter.split(","));
		} else {
			formatters.add(formatter);
		}
	}
	
	public void configureAsDefault() {
		name = defaultName;
		levels = Arrays.asList(defaultLevel.split(","));
		formatters = Arrays.asList(defaultFormatter.split(","));
		separators = Arrays.asList(defaultSeparator.split(","));
		outputs = Arrays.asList(defaultOutput.split(","));
	}
}
