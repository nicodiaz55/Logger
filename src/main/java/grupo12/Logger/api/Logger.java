package grupo12.Logger.api;

import grupo12.Logger.level.Level;
import grupo12.Logger.output.Output;
import grupo12.Logger.filter.Filterer;


/**
 * Logger API.
 * 
 * @author Grupo 12
 * @see    LoggerBuilder
 */
public class Logger {

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
		logger.log(message, Level.TRACE, null);
	}

	/**
	 * Logs a message with Debug priority.
	 * 
	 * @param message to log.
	 */
	public void debug(String message) {
		logger.log(message, Level.DEBUG, null);
	}

	/**
	 * Logs a message with Info priority.
	 * 
	 * @param message to log.
	 */
	public void info(String message) {
		logger.log(message, Level.INFO, null);
	}
	
	/**
	 * Logs a message with Warning priority.
	 * 
	 * @param message to log.
	 */
	public void warn(String message) {
		logger.log(message, Level.WARNING, null);
	}
	
	/**
	 * Logs a message with Error priority.
	 * 
	 * @param message to log.
	 */
	public void error(String message) {
		logger.log(message, Level.ERROR, null);
	}
	
	/**
	 * Logs a message with Fatal priority.
	 * 
	 * @param message to log.
	 */
	public void fatal(String message) {
		logger.log(message, Level.FATAL, null);
	}
	
	
	/**
	 * Logs a message with Trace priority.
	 * 
	 * @param message to log.
	 * @param exception to log.
	 */
	public void trace(String message, Throwable exception) {
		logger.log(message, Level.TRACE, exception);
	}

	/**
	 * Logs a message with Debug priority.
	 * 
	 * @param message to log.
	 * @param exception to log.
	 */
	public void debug(String message, Throwable exception) {
		logger.log(message, Level.DEBUG, exception);
	}

	/**
	 * Logs a message with Info priority.
	 * 
	 * @param message to log.
	 * @param exception to log.
	 */
	public void info(String message, Throwable exception) {
		logger.log(message, Level.INFO, exception);
	}
	
	/**
	 * Logs a message with Warning priority.
	 * 
	 * @param message to log.
	 * @param exception to log.
	 */
	public void warn(String message, Throwable exception) {
		logger.log(message, Level.WARNING, exception);
	}
	
	/**
	 * Logs a message with Error priority.
	 * 
	 * @param message to log.
	 * @param exception to log.
	 */
	public void error(String message, Throwable exception) {
		logger.log(message, Level.ERROR, exception);
	}
	
	/**
	 * Logs a message with Fatal priority.
	 * 
	 * @param message to log.
	 * @param exception to log.
	 */
	public void fatal(String message, Throwable exception) {
		logger.log(message, Level.FATAL, exception);
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
	 * Returns the Level of the Logger.
	 * 
	 * @return the level.
	 */
	public Level getLevel() {
		return logger.getLevel();
	}
	
	/**
	 * Sets the Level of the Logger.
	 * 
	 * @param level to set.
	 */
	public void setLevel(Level level) {
		logger.setLevel(level);
	}
	
	/**
	 * Sets the Filter of the Logger.
	 * 
	 * @param filter to set.
	 */
	public void setFilterer(Filterer filterer) {
		logger.setFilterer(filterer);
	}
}
