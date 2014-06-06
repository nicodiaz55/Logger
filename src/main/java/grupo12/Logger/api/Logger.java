package grupo12.Logger.api;

import grupo12.Logger.level.*;
import grupo12.Logger.level.Error;
import grupo12.Logger.output.Output;

/**
 * Logger API.
 * 
 * @author Grupo 12
 * @see    LoggerBuilder
 */
public class Logger { // TODO: falta un implements para ser completamenete un adapter... y modificar otras clases.

	private GenericLogger logger;
	
	public Logger(String name) {
		logger = new GenericLogger(name);
	}
	
	
	/**
	 * Logs a message with Trace priority.
	 * 
	 * @param message to log.
	 */
	public void trace(String message) {
		logger.log(message, new Trace(), null);
	}

	/**
	 * Logs a message with Debug priority.
	 * 
	 * @param message to log.
	 */
	public void debug(String message) {
		logger.log(message, new Debug(), null);
	}

	/**
	 * Logs a message with Info priority.
	 * 
	 * @param message to log.
	 */
	public void info(String message) {
		logger.log(message, new Info(), null);
	}
	
	/**
	 * Logs a message with Warning priority.
	 * 
	 * @param message to log.
	 */
	public void warn(String message) {
		logger.log(message, new Warning(), null);
	}
	
	/**
	 * Logs a message with Error priority.
	 * 
	 * @param message to log.
	 */
	public void error(String message) {
		logger.log(message, new Error(), null);
	}
	
	/**
	 * Logs a message with Fatal priority.
	 * 
	 * @param message to log.
	 */
	public void fatal(String message) {
		logger.log(message, new Fatal(), null);
	}
	
	
	/**
	 * Logs a message with Trace priority.
	 * 
	 * @param message to log.
	 * @param exception to log.
	 */
	public void trace(String message, Throwable exception) {
		logger.log(message, new Trace(), exception);
	}

	/**
	 * Logs a message with Debug priority.
	 * 
	 * @param message to log.
	 * @param exception to log.
	 */
	public void debug(String message, Throwable exception) {
		logger.log(message, new Debug(), exception);
	}

	/**
	 * Logs a message with Info priority.
	 * 
	 * @param message to log.
	 * @param exception to log.
	 */
	public void info(String message, Throwable exception) {
		logger.log(message, new Info(), exception);
	}
	
	/**
	 * Logs a message with Warning priority.
	 * 
	 * @param message to log.
	 * @param exception to log.
	 */
	public void warn(String message, Throwable exception) {
		logger.log(message, new Warning(), exception);
	}
	
	/**
	 * Logs a message with Error priority.
	 * 
	 * @param message to log.
	 * @param exception to log.
	 */
	public void error(String message, Throwable exception) {
		logger.log(message, new Error(), exception);
	}
	
	/**
	 * Logs a message with Fatal priority.
	 * 
	 * @param message to log.
	 * @param exception to log.
	 */
	public void fatal(String message, Throwable exception) {
		logger.log(message, new Fatal(), exception);
	}
	
	/**
	 * Adds an output to the Logger.
	 * 
	 * @param output to add.
	 */
	public void addOutput(Output output) {
		logger.addOutput(output);
	}
	
	/**
	 * Initializes the Logger. Use it when you want to start logging.
	 */
	public void init() {
		logger.init();
	}
	
	/**
	 * Finalizes the Logger. Use it when you don't want to log anymore.
	 */
	public void end() {
		logger.end();
	}

	/**
	 * Turns off the logger. No messages will be logged.
	 */
	public void turnOff() {
		logger.turnOff();
	}
	
	/**
	 * Turns on the logger. Messages will be logged.
	 */
	public void turnOn() {
		logger.turnOn();
	}
	
	/**
	 * Returns the name of the Logger.
	 * 
	 * @return the logger name.
	 */
	public String getName() {
		return logger.getName();
	}
	
	/**
	 * Returns the level of the Logger.
	 * 
	 * @return the level.
	 */
	public Level getLevel() {
		return logger.getLevel();
	}
	
	/**
	 * Sets the level of the Logger.
	 * 
	 * @param level to set.
	 */
	public void setLevel(Level level) {
		logger.setLevel(level);
	}
	
}
