package grupo12.Logger.conf.parser;

import grupo12.Logger.conf.Configuration;

import java.util.List;

/**
 * A Parser interface. Defines all the things a Parser must do.
 * 
 * @author Grupo 12
 */
public interface Parser {

	/**
	 * Inits the parser
	 * 
	 * @return true if was initialized, false if not.
	 */
	public boolean init();

	/**
	 * Returns if the Parser can parse the file.
	 * 
	 * @return true or false
	 */
	public boolean canParse();
	
	/**
	 * Loads and returns the configurations parsed.
	 * 
	 * @return a list of Configuration
	 */
	public List<Configuration> loadConfigurations();

	/**
	 * Especifies the file that must be parsed.
	 * 
	 * @param file to parse
	 */
	public void setFile(String file);
}
