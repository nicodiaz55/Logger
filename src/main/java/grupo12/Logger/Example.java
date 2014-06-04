package grupo12.Logger;

import java.io.IOException;

import grupo12.Logger.api.Logger;
import grupo12.Logger.format.Formatter;
import grupo12.Logger.api.LoggerFactory;
import grupo12.Logger.format.Pattern;
import grupo12.Logger.level.Info;
import grupo12.Logger.level.Level;
import grupo12.Logger.output.ConsoleWriter;
import grupo12.Logger.output.Output;
import grupo12.Logger.output.Writer;


public class Example {

	public static void main(String[] args) {
		createLoggerFromConfigurationFile();
		createLoggerManualMode();
	}

	private static void createLoggerManualMode() {
		// We create our logger:
		Logger logger = new Logger("MyLogger");
		
		// We need a Level for our logger:
		Level level = new Info(); // Only logs info, warning, error and fatal messages.
		
		// We need a Formatter for our message:
		Formatter formatter = new Pattern("%d{HH:mm:ss} %n %g %n %p %n %L %n %M %n %F %n %m", "|");
		// This formats the message like this: "23:03:45 | INFO | Info message | Line number | Method name | File name"
		
		// We need an output writer, in this case, the console:
		Writer writer = new ConsoleWriter();
		
		// Finally, we need to add the Output to our Logger:
		Output output = new Output(level, writer, formatter);
		logger.addOutput(output);
		// We can add as many outputs as we wish, each with different levels and formats.
		// We recommend to use the configuration file, however. 
		
		// Now we can log:
		logger.debug("Debug message");
		logger.info("Info message");
		logger.warn("Warning message");
		logger.error("Error message");
		logger.fatal("Fatal error message");
		
		// These messages won't be logged:
		logger.off(); // Turn off the logger.
		logger.debug("Unlogged Debug message");
		logger.info("Unlogged Info message");
		logger.warn("Unlogged Warning message");
		logger.error("Unlogged Error message");
		logger.fatal("Unlogged Fatal error message");
		
		// Now these messages are logged:
		logger.on(); // Turn on the logger.
		logger.debug("Debug message 2");
		logger.info("Info message 2");
		logger.warn("Warning message 2");
		logger.error("Error message 2");
		logger.fatal("Fatal error message 2");
		
		// We can pass an exception too:
		logger.error("An exception occured:", new IOException("IO exception"));
		
		logger.endLog(); // Always end the logger!
	}
	
	private static void createLoggerFromConfigurationFile() {
		LoggerFactory factory = new LoggerFactory();
		
		Logger logger = factory.getLogger(); // Preloaded default logger;
		
		// If we write our logger-config.properties or logger-config.xml, we can load
		// custom loggers. If the name of the logger doesn't exists, or no configuration
		// file is provided, we get default loggers with this method:
		//Logger logger = factory.getLogger("MyLogger");
		
		logger.debug("Debug message");
		logger.info("Info message");
		logger.warn("Warning message");
		logger.error("Error message");
		logger.fatal("Fatal error message");
		
		// These messages won't be logged:
		logger.off(); // Turn off the logger.
		logger.debug("Unlogged Debug message");
		logger.info("Unlogged Info message");
		logger.warn("Unlogged Warning message");
		logger.error("Unlogged Error message");
		logger.fatal("Unlogged Fatal error message");
		
		// Now these messages are logged:
		logger.on(); // Turn on the logger.
		logger.debug("Debug message 2");
		logger.info("Info message 2");
		logger.warn("Warning message 2");
		logger.error("Error message 2");
		logger.fatal("Fatal error message 2");
		
		logger.endLog(); // Always end the logger!
	}

}
