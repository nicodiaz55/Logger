package grupo12.Logger;

import java.io.IOException;

import grupo12.Logger.api.Logger;
import grupo12.Logger.api.LoggerFactory;
import grupo12.Logger.format.Formatter;
import grupo12.Logger.format.Pattern;
import grupo12.Logger.level.Level;
import grupo12.Logger.output.filter.CustomFilter;
import grupo12.Logger.output.writer.ConsoleWriter;
import grupo12.Logger.output.Output;
import grupo12.Logger.output.writer.Writer;

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
		Formatter formatter = new Pattern("%d{EEE MMM dd HH:mm:ss zzz yyyy} %n %g %n %p %n %t %n %F %n %M %n %L %n %m", "|");
		// This formats the message like this: "Wed Jun 18 14:04:05 ART 2014 | <Logger name> | <Level> | <Thread name> | <File name> | <Method name> | <Line number> | <message> | <Exception message>"
		
		// We need an output writer, in this case, the console:
		Writer writer = new ConsoleWriter();
		
		// We need to add the Output to our Logger:
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
		logger.trace("An exception occured:", new IOException("trace IO exception"));
		logger.debug("An exception occured:", new IOException("debug IO exception"));
		logger.info("An exception occured:", new IOException("info IO exception"));
		logger.warn("An exception occured:", new IOException("warn IO exception"));
		logger.error("An exception occured:", new IOException("error IO exception"));
		logger.fatal("An exception occured:", new IOException("fatal IO exception"));
		
		logger.trace("An exception occured:", new IOException());
		logger.debug("An exception occured:", new IOException());
		logger.info("An exception occured:", new IOException());
		logger.warn("An exception occured:", new IOException());
		logger.error("An exception occured:", new IOException());
		logger.fatal("An exception occured:", new IOException());
		
		/* 
		 * Optionally, we can set a Filter to log only certain messages:
		 * This step must be done after adding all the outputs.
		 */
		//logger.setFilter(new RegexFilter(".*"));
		// In this case, the regex is ".*", so all messages will be logged.
		
		/*
		 * We can create our custom filters:
		 *   Just create a class that implements grupo12.Logger.filter.Filter
		 *   and put it in some package. Compile, and you can use it with this:
		 *   (in this case, it uses de ExampleFilter in this package)
		 *   [package.name.class]
		 */
		logger.setFilter(new CustomFilter("grupo12.Logger.output.filter.ExampleFilter.class"));
		
		// This is the only message that will pass if we activate the CustomFilter:
		// (also, the level still counts!)
		logger.warn("This message doesn't pass the filter");
		logger.warn("This message passes the filter");
		logger.info("This message doesn't pass the filter");
		
		logger.end(); // Always end the logger!
	}
}
