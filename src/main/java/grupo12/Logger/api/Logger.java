package grupo12.Logger.api;

import grupo12.Logger.level.Debug;
import grupo12.Logger.level.Fatal;
import grupo12.Logger.level.Info;
import grupo12.Logger.level.Warning;
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
	private List<Output> outputs;
	static final private int stCallerDepth = 3;
	
	/**
	 * Creates an empty Logger. It's recomended to use {@link LoggerBuilder} to create a Logger.
	 * Otherwise, just add some {@link Output}'s with a {@link grupo12.Logger.format.Formatter Formatter} and a {@link grupo12.Logger.output.Writer Writer} to
	 * start logging.
	 */
	public Logger() {
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
	 * Logs a message with Debug priority.
	 * 
	 * @param message to log.
	 */
	public void debug(String message) {
		LogMessage logMessage = new LogMessage(new Debug(), message, getCallingStackTraceElement());
		log(logMessage);
	}

	/**
	 * Logs a message with Info priority.
	 * 
	 * @param message to log.
	 */
	public void info(String message) {
		LogMessage logMessage = new LogMessage(new Info(), message, getCallingStackTraceElement());
		log(logMessage);
	}
	
	/**
	 * Logs a message with Warning priority.
	 * 
	 * @param message to log.
	 */
	public void warn(String message) {
		LogMessage logMessage = new LogMessage(new Warning(), message, getCallingStackTraceElement());
		log(logMessage);
	}
	
	/**
	 * Logs a message with Error priority.
	 * 
	 * @param message to log.
	 */
	public void error(String message) {
		LogMessage logMessage = new LogMessage(new Error(), message, getCallingStackTraceElement());
		log(logMessage);
	}
	
	/**
	 * Logs a message with Fatal priority.
	 * 
	 * @param message to log.
	 */
	public void fatal(String message) {
		LogMessage logMessage = new LogMessage(new Fatal(), message, getCallingStackTraceElement());
		log(logMessage);
	}
	
	/**
	 * Finalices the Logger. Use it when you don't want to log anymore.
	 */
	public void endLog() {
		for (Output output : outputs) {
			output.endLog();
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
}
