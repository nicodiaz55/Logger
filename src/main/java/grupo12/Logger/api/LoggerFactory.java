package grupo12.Logger.api;

import grupo12.Logger.conf.Configuration;
import grupo12.Logger.conf.ConfigurationParser;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Factory of Loggers. This is the main class you can use to
 * get Loggers. It uses the configuration files to create them.
 * 
 * @author Grupo 12
 */
public class LoggerFactory {

	private static final String DEFAULTCONF = "default.cfg";
	private static final String DEFAULTNAME = "Logger";
	
	private Hashtable<String, Logger> loggers;
	private LoggerBuilder builder;
	
	/**
	 * Creates a new Logger Factory.
	 */
	public LoggerFactory() {
		loggers = new Hashtable<String, Logger>();		
		builder = new LoggerBuilder();
		loadConfiguration();
	}
	
	/**
	 * Initialices the factory. Search and load the
	 * configuration files (via ConfigurationParser)
	 * and then stores the Loggers.
	 */
	private void loadConfiguration() {		
		// Get the configurations:
		ConfigurationParser parser = new ConfigurationParser();
		ArrayList<Configuration> parsedConfigurations = parser.getConfigurations();
		
		// We add the Default Logger (it's always available):
		parsedConfigurations.add(new Configuration(DEFAULTCONF));
		
		// Construct every logger:
		for (Configuration conf : parsedConfigurations) {
			Logger log = builder.build(conf);
			loggers.put(log.getName(), log);
		}
	}

	/**
	 * Returns the default {@link Logger}.
	 * 
	 * @return a Logger with default configuration, named "Logger"
	 */
	public Logger getLogger() {
		return loggers.get(DEFAULTNAME);
	}
	
	/**
	 * Returns the {@link Logger} with the specified name.
	 * If no Logger exists with that name, it returns a new Logger
	 * with that name and default configuration.
	 * 
	 * All the names and configurations are stored in a configuration file.
	 * 
	 * @param name of the Logger
	 * @return the Logger
	 */
	public Logger getLogger(String name) {
		Logger log = loggers.get(name);

		// Returns a new default Logger:
		if (log == null) {
			log = addDefaultLogger(name);
		}

		return log;
	}

	/**
	 * Creates a new default {@link Logger}.
	 * 
	 * @param name of the Logger
	 * @return the new default logger
	 */
	private Logger addDefaultLogger(String name) {
		Logger log = builder.build(new Configuration(DEFAULTCONF));
		loggers.put(name, log);
		return log;
	}
}
