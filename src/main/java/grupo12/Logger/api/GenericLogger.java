package grupo12.Logger.api;

import grupo12.Logger.level.Level;
import grupo12.Logger.message.LogMessage;
import grupo12.Logger.output.Output;

import java.util.ArrayList;
import java.util.List;

public class GenericLogger {
	private String name;
	private Level level;
	private List<Output> outputs;
	private static final int stCallerDepth = 4;

	/**
	 * Creates an empty Logger with a given name. It's recommended to use {@link LoggerBuilder} to create a Logger.
	 * Otherwise, just add some {@link Output}'s with a {@link grupo12.Logger.format.Pattern Formatter} and a {@link grupo12.Logger.output.Writer Writer} to
	 * start logging.
	 * 
	 * @param name of the Logger.
	 */
	public GenericLogger(String name) {
		this.name = name;
		outputs = new ArrayList<Output>();
		level = null;
	}

	/**
	 * Creates our own Stack Trace, its used to track the method which is calling the log method.
	 * 
	 * @return the calling {@link StackTraceElement}.
	 */
	private StackTraceElement getCallingStackTraceElement() {
		StackTraceElement[] st = Thread.currentThread().getStackTrace();
		StackTraceElement callingSTE = st[stCallerDepth];
		return callingSTE;
	}
	
	/**
	 * Adds an output to the Logger.
	 * 
	 * @param output to add.
	 */
	public void addOutput(Output output) {
		outputs.add(output);
	}
	
	/**
	 * Sets the level of the Logger.
	 * 
	 * @param level to set.
	 */
	public void setLevel(Level level) {
		this.level = level;
	}
	
	/**
	 * Logs the message for all outputs.
	 * 
	 * @param message to log.
	 * @param level of the message.
	 * @param exception to log.
	 */
	public void log(String message, Level level, Throwable exception) {
		LogMessage logMessage = createMessage(message, level, exception);
		for (Output output : outputs) {
			output.log(logMessage);
		}
	}
	
	/**
	 * Creates a {@link LogMessage} for internal use.
	 * 
	 * @param message to log.
	 * @param level of the message.
	 * @param exception to log.
	 * 
	 * @return the LogMessage.
	 */
	private LogMessage createMessage(String message, Level level, Throwable exception) {
		LogMessage logMessage = new LogMessage(level, message, getCallingStackTraceElement(), exception, name);
		return logMessage;
	}
	
	/**
	 * Initializes the Logger. Use it when you want to start logging.
	 */
	public void init() {
		for (Output output : outputs) {
			output.init();
		}
	}
	
	/**
	 * Finalizes the Logger. Use it when you don't want to log anymore.
	 */
	public void end() {
		for (Output output : outputs) {
			output.end();
		}		
	}

	/**
	 * Turns off the logger. No messages will be logged.
	 */
	public void turnOff() {
		for (Output output : outputs) {
			output.turnOff();
		}		
	}
	
	/**
	 * Turns on the logger. Messages will be logged.
	 */
	public void turnOn() {
		for (Output output : outputs) {
			output.turnOn();
		}
	}
	
	/**
	 * Returns the name of the Logger.
	 * 
	 * @return the logger name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the level of the Logger.
	 * 
	 * @return the level.
	 */
	public Level getLevel() {
		return level;
	}
}
