package grupo12.Logger;

import grupo12.Logger.api.Logger;
import grupo12.Logger.api.LoggerBuilder;


public class Example {

	public static void main(String[] args) {
		LoggerBuilder builder = new LoggerBuilder(); // Default logger
		//LoggerBuilder builder = new LoggerBuilder("user.cfg"); // User configuration
		Logger logger = builder.getLogger();
		logger.debug("Debug message");
		logger.info("Info message");
		logger.warn("Warning message");
		logger.error("Error message");
		logger.fatal("Fatal error message");
		logger.off(); // Turn off the logger
		logger.debug("Unlogged Debug message");
		logger.info("Unlogged Info message");
		logger.warn("Unlogged Warning message");
		logger.error("Unlogged Error message");
		logger.fatal("Unlogged Fatal error message");
		logger.on(); // Turn on the logger
		logger.debug("Debug message 2");
		logger.info("Info message 2");
		logger.warn("Warning message 2");
		logger.error("Error message 2");
		logger.fatal("Fatal error message 2");
		logger.endLog(); // End the logger
	}

}
