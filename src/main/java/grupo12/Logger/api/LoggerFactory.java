package grupo12.Logger.api;

import grupo12.Logger.conf.Configuration;

import java.util.ArrayList;
import java.util.Hashtable;

public class LoggerFactory {

	private static final String DEFAULTCONF = "Default";
	private static final String DEFAULTNAME = "DefaultLogger";
	
	private Hashtable<String, Logger> loggers;
	private LoggerBuilder builder;
	
	public LoggerFactory() {
		loggers = new Hashtable<String, Logger>();		
		builder = new LoggerBuilder();
		addDefaultLogger(DEFAULTNAME);
		loadConfiguration();
	}
	
	private void loadConfiguration() {
		
		ArrayList<String> configurationFiles = new ArrayList<String>();
		configurationFiles.add("logger-config.properties");
		configurationFiles.add("logger-config.xml");
			
		/* TODO: llamar a alguna clase, darle esa lista, y que me arme un array de Configuration.
		 * Cada Configuration tiene la configuración de un logger (incluye su nombre).
		 */
		
		ArrayList<Configuration> parsedConfigurations = new ArrayList<Configuration>(); // aca me devuelven la lista.
		
		// Construct every logger from the configuration file:
		for (Configuration conf : parsedConfigurations) {
			Logger log = builder.build(conf);
			loggers.put(log.getName(), log);
		}
	}

	public Logger getLoger() {
		return loggers.get("Logger");
	}
	
	public Logger getLogger(String name) {
		Logger log = loggers.get(name);

		// Returns a default Logger:
		if (log == null) {
			log = addDefaultLogger(name);
		}

		return log;
	}

	private Logger addDefaultLogger(String name) {
		Logger log = null;
		log = builder.build(new Configuration(DEFAULTCONF));
		loggers.put(name, log);
		return log;
	}
}
