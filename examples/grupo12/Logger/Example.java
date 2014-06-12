package grupo12.Logger;

import java.io.IOException;

import grupo12.Logger.api.Logger;
import grupo12.Logger.format.Formatter;
import grupo12.Logger.api.LoggerFactory;
import grupo12.Logger.format.Pattern;
import grupo12.Logger.level.Level;
import grupo12.Logger.output.ConsoleWriter;
import grupo12.Logger.output.Output;
import grupo12.Logger.output.Writer;


public class Example {

	public static void main(String[] args) {
		createLoggerFromConfigurationFile();
		createLoggerManualMode();
	}

	// Recommended way to create a Logger:
	private static void createLoggerFromConfigurationFile() {
		
		// We need a LoggerFactory to start:
		LoggerFactory factory = LoggerFactory.getInstance();
		
		/* With a configuration file we can configure easyly a lot of parameters of our Loggers
		 * For example, we can also define our custom Level names and ordering.
		 * If we want to load our custom configuration file, simply call this method:
		 */
		//factory.setConfigurationFile("myfile.xml");
		
		/* We now support xml and properties files. Please specify what file type it's your configuration
		 * file like this: myfile.xml or myfile.properties
		 */ 
		
		/* If you don't set a configuration file, or it can be loaded, we load a default configuration,
		 * specified in the file logger-config.properties or logger-config.xml (if they exists).
		 */
		
		Logger logger = factory.getLogger(); // Preloaded default logger;
		
		// We can get a default logger with this method, always:		
		//Logger logger = factory.getLogger("MyLogger");
		
		// We need to init the logger:
		logger.init();
		
		// Now we can log!
		logger.trace("Trace message");
		logger.debug("Debug message");
		logger.info("Info message");
		logger.warn("Warning message");
		logger.error("Error message");
		logger.fatal("Fatal error message");
		
		// These messages won't be logged:
		logger.turnOff(); // Turn off the logger.
		logger.trace("Unlogged Trace message");
		logger.debug("Unlogged Debug message");
		logger.info("Unlogged Info message");
		logger.warn("Unlogged Warning message");
		logger.error("Unlogged Error message");
		logger.fatal("Unlogged Fatal error message");
		
		// Now these messages are logged:
		logger.turnOn(); // Turn on the logger.
		logger.trace("Trace message 2");
		logger.debug("Debug message 2");
		logger.info("Info message 2");
		logger.warn("Warning message 2");
		logger.error("Error message 2");
		logger.fatal("Fatal error message 2");
		
		// We can pass an exception too:
		logger.error("An exception occured:", new IOException("IO exception"));
		
		logger.end(); // Always end the logger!
	}
	
	private static void createLoggerManualMode() {
		// We create our logger:
		Logger logger = new Logger("MyLogger");
		
		// We need a Level for our logger:
		logger.setLevel(Level.WARNING); // Only logs warning, error and fatal messages.
		// We can only use the Levels TRACE, DEBUG, INFO, WARNING, ERROR and FATAL in this mode.
		
		// We need a Formatter for our message:
		Formatter formatter = new Pattern("%d{HH:mm:ss} %n %g %n %p %n %L %n %M %n %F %n %m", "|");
		// This formats the message like this: "23:03:45 | INFO | Info message | Line number | Method name | File name"
		
		// We need an output writer, in this case, the console:
		Writer writer = new ConsoleWriter();
		
		// Finally, we need to add the Output to our Logger:
		Output output = new Output();
		output.setWriter(writer);
		output.setFormatter(formatter);
		
		// We can add as many outputs as we wish, each with different levels and formats.
		// We recommend to use the configuration file, however. 
		logger.addOutput(output);
		
		// We must init the logger:
		logger.init();
		
		// Now we can log:
		logger.trace("Trace message");
		logger.debug("Debug message");
		logger.info("Info message");
		logger.warn("Warning message");
		logger.error("Error message");
		logger.fatal("Fatal error message");
		
		// These messages won't be logged:
		logger.turnOff(); // Turn off the logger.
		logger.trace("Unlogged Trace message");
		logger.debug("Unlogged Debug message");
		logger.info("Unlogged Info message");
		logger.warn("Unlogged Warning message");
		logger.error("Unlogged Error message");
		logger.fatal("Unlogged Fatal error message");
		
		// Now these messages are logged:
		logger.turnOn(); // Turn on the logger.
		logger.trace("Trace message 2");
		logger.debug("Debug message 2");
		logger.info("Info message 2");
		logger.warn("Warning message 2");
		logger.error("Error message 2");
		logger.fatal("Fatal error message 2");
		
		// We can pass an exception too:
		logger.error("An exception occured:", new IOException("IO exception"));
		
		logger.end(); // Always end the logger!
	}
}
