package grupo12.Logger.api;

import grupo12.Logger.level.*;
import grupo12.Logger.level.Error;
import grupo12.Logger.message.LogMessage;
import grupo12.Logger.output.Output;

import java.util.ArrayList;
import java.util.List;

/**
 * Logger API.
 * 
 * @author Grupo 12
 * @see    LoggerBuilder
 */
public class Logger {
	private String name;
	private List<Output> outputs;
	static final private int stCallerDepth = 4;

	/**
	 * Creates an empty Logger with no name. It's recommended to use {@link LoggerBuilder} to create a Logger.
	 * Otherwise, just add some {@link Output}'s with a {@link grupo12.Logger.format.Pattern Formatter} and a {@link grupo12.Logger.output.Writer Writer} to
	 * start logging.
	 */
	public Logger() {
		this("");
	}

	/**
	 * Creates an empty Logger with a given name. It's recommended to use {@link LoggerBuilder} to create a Logger.
	 * Otherwise, just add some {@link Output}'s with a {@link grupo12.Logger.format.Pattern Formatter} and a {@link grupo12.Logger.output.Writer Writer} to
	 * start logging.
	 * 
	 * @param name of the Logger.
	 */
	public Logger(String name) {
		this.name = name;
		outputs = new ArrayList<Output>();
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
	 * Logs the message for all outputs.
	 * 
	 * @param message to log.
	 */
	private void log(LogMessage message) {
		for (Output output : outputs) {
			output.log(message);
		}
	}
	
	/**
	 * Creates a {@link LogMessage} for internal use.
	 * 
	 * @param message to log.
	 * @param level of the message.
	 * 
	 * @return the LogMessage.
	 */
	private LogMessage createMessage(String message, Level level, Throwable exception) {
		LogMessage logMessage = new LogMessage(level, message, getCallingStackTraceElement(), exception, name);
		return logMessage;
	}
	
	/**
	 * Logs a message with Trace priority.
	 * 
	 * @param message to log.
	 */
	public void trace(String message) {
		LogMessage logMessage = createMessage(message, new Trace(), null);
		log(logMessage);
	}

	/**
	 * Logs a message with Debug priority.
	 * 
	 * @param message to log.
	 */
	public void debug(String message) {
		LogMessage logMessage = createMessage(message, new Debug(), null);
		log(logMessage);
	}

	/**
	 * Logs a message with Info priority.
	 * 
	 * @param message to log.
	 */
	public void info(String message) {
		LogMessage logMessage = createMessage(message, new Info(), null);
		log(logMessage);
	}
	
	/**
	 * Logs a message with Warning priority.
	 * 
	 * @param message to log.
	 */
	public void warn(String message) {
		LogMessage logMessage = createMessage(message, new Warning(), null);
		log(logMessage);
	}
	
	/**
	 * Logs a message with Error priority.
	 * 
	 * @param message to log.
	 */
	public void error(String message) {
		LogMessage logMessage = createMessage(message, new Error(), null);
		log(logMessage);
	}
	
	/**
	 * Logs a message with Fatal priority.
	 * 
	 * @param message to log.
	 */
	public void fatal(String message) {
		LogMessage logMessage = createMessage(message, new Fatal(), null);
		log(logMessage);
	}
	
	
	/**
	 * Logs a message with Trace priority.
	 * 
	 * @param message to log.
	 * @param exception to log.
	 */
	public void trace(String message, Throwable exception) {
		LogMessage logMessage = createMessage(message, new Trace(), exception);
		log(logMessage);
	}

	/**
	 * Logs a message with Debug priority.
	 * 
	 * @param message to log.
	 * @param exception to log.
	 */
	public void debug(String message, Throwable exception) {
		LogMessage logMessage = createMessage(message, new Debug(), exception);
		log(logMessage);
	}

	/**
	 * Logs a message with Info priority.
	 * 
	 * @param message to log.
	 * @param exception to log.
	 */
	public void info(String message, Throwable exception) {
		LogMessage logMessage = createMessage(message, new Info(), exception);
		log(logMessage);
	}
	
	/**
	 * Logs a message with Warning priority.
	 * 
	 * @param message to log.
	 * @param exception to log.
	 */
	public void warn(String message, Throwable exception) {
		LogMessage logMessage = createMessage(message, new Warning(), exception);
		log(logMessage);
	}
	
	/**
	 * Logs a message with Error priority.
	 * 
	 * @param message to log.
	 * @param exception to log.
	 */
	public void error(String message, Throwable exception) {
		LogMessage logMessage = createMessage(message, new Error(), exception);
		log(logMessage);
	}
	
	/**
	 * Logs a message with Fatal priority.
	 * 
	 * @param message to log.
	 * @param exception to log.
	 */
	public void fatal(String message, Throwable exception) {
		LogMessage logMessage = createMessage(message, new Fatal(), exception);
		log(logMessage);
	}
	
	public void init() {
		for (Output output : outputs) {
			output.init();
		}
	}
	
	/**
	 * Finalices the Logger. Use it when you don't want to log anymore.
	 */
	public void end() {
		for (Output output : outputs) {
			output.end();
		}		
	}

	/**
	 * Turns off the logger. No messages will be logged.
	 */
	public void off() {
		for (Output output : outputs) {
			output.turnOff();
		}		
	}
	
	/**
	 * Turns on the logger. Messages will be logged.
	 */
	public void on() {
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
}
