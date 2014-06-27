package grupo12.Logger.api;

import grupo12.Logger.conf.Configuration;
import grupo12.Logger.conf.ConfigurationParser;

import java.util.List;
import java.util.Hashtable;

/**
 * Factory of Loggers. This is the main class you can use to
 * get Loggers. It uses configuration files to create them.
 * 
 * @author Grupo 12
 */
public class LoggerFactory {

	/**
	 * The unique instance of this class.
	 */
	private static final LoggerFactory INSTANCE = new LoggerFactory();
	
	/**
	 * Return the singleton of this class.
	 * 
	 * @return the LoggerFactory singleton
	 */
	public static final LoggerFactory getInstance() {
		return INSTANCE;
	}
	
	/**
	 * The name of the Default Logger.
	 */
	public static final String DEFAULTNAME = "Logger";

	private Hashtable<String, Logger> loggers;
	private LoggerBuilder builder;
	private boolean loaded;
	
	/**
	 * Creates a new Logger Factory.
	 */
	private LoggerFactory() {
		loggers = new Hashtable<String, Logger>();
		builder = new LoggerBuilder();
		loaded = false;
	}

	
	
	/**
	 * Initializes the factory. Search and load the
	 * configuration files (via ConfigurationParser)
	 * and then stores the Loggers.
	 * 
	 * If no file is provided, it loads the default configuration files.
	 * 
	 * @param file containing the configuration.
	 */
	public void setConfigurationFile(String file) {
		// Get the configurations:
		ConfigurationParser parser = new ConfigurationParser(file);
		List<Configuration> parsedConfigurations = parser.getConfigurations();

		// Construct every logger:
		for (Configuration conf : parsedConfigurations) {
			Logger log = builder.build(conf);
			loggers.put(log.getName(), log);
		}
		loaded = true;
	}

	/**
	 * Returns the default {@link Logger}.
	 * 
	 * @return a Logger with default configuration, named "Logger"
	 */
	public Logger getLogger() {
		return getLogger(DEFAULTNAME);
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
		if (!loaded) {
			setConfigurationFile(null);
		}
		
		Logger log = loggers.get(name);

		// Returns a new default Logger:
		if (log == null) {
			log = addDefaultLogger(name);
		}

		return log;
	}

	/**
	 * Creates a new {@link Logger} with default configuration (except it's name).
	 * 
	 * @param name of the Logger
	 * @return the new default logger
	 */
	private Logger addDefaultLogger(String name) {
		Configuration defaultConf = new Configuration();
		defaultConf.configureAsDefault();
		defaultConf.setName(name);

		Logger log = builder.build(defaultConf);
		loggers.put(name, log);
		return log;
	}
}
