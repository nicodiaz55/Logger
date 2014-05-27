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
 * Main class. Has many outputs which are addable by the user.
 * Can be created from a configuration file or by default mode.
 * @author Grupo 12
 *
 */
public class Logger {
	private List<Output> outputs;
	static final private int stCallerDepth = 3;
	
	/**
	 * Constructor. Creates an empty list of outputs.
	 */
	public Logger() {
		outputs = new ArrayList<Output>();
	}
	
	/**
	 * Creates our own Stack Trace, its used to track the method which is calling the log method.
	 * @return the calling StackTraceElement
	 */
	private StackTraceElement getCallingStackTraceElement() {
		StackTraceElement[] st = Thread.currentThread().getStackTrace();
		StackTraceElement callingSTE = st[stCallerDepth];
		return callingSTE;
	}
	
	/**
	 * Adds an output to the output list.
	 * Public, usable by the user.
	 * @param output
	 */
	public void addOutput(Output output) {
		outputs.add(output);
	}
	
	/**
	 * Private method. Logs the same message for all outputs.
	 * @param message
	 */
	private void log(LogMessage message) {
		for (Output output : outputs) {
			output.log(message);
		}
	}
	
	/**
	 * Public method.
	 * Used by the user to log a debug message
	 * @param message
	 */
	public void debug(String message) {
		LogMessage logMessage = new LogMessage(new Debug(), message, getCallingStackTraceElement());
		log(logMessage);
	}

	/**
	 * Public method.
	 * Used by the user to log an info message
	 * @param message
	 */
	public void info(String message) {
		LogMessage logMessage = new LogMessage(new Info(), message, getCallingStackTraceElement());
		log(logMessage);
	}
	
	/**
	 * Public method.
	 * Used by the user to log a warn message
	 * @param message
	 */
	public void warn(String message) {
		LogMessage logMessage = new LogMessage(new Warning(), message, getCallingStackTraceElement());
		log(logMessage);
	}
	
	/**
	 * Public method.
	 * Used by the user to log an error message
	 * @param message
	 */
	public void error(String message) {
		LogMessage logMessage = new LogMessage(new Error(), message, getCallingStackTraceElement());
		log(logMessage);
	}
	
	/**
	 * Public method.
	 * Used by the user to log a fatal message
	 * @param message
	 */
	public void fatal(String message) {
		LogMessage logMessage = new LogMessage(new Fatal(), message, getCallingStackTraceElement());
		log(logMessage);
	}
	
	/**
	 * Public method.
	 * Used by the user to end the log.
	 * Ends every log from every output in the list
	 */
	public void endLog() {
		for (Output output : outputs) {
			output.endLog();
		}		
	}

	/**
	 * Turns off the logger.
	 */
	public void off() {
		for (Output output : outputs) {
			output.turnOff();
		}		
	}
	
	/**
	 * Turns on the logger.
	 */
	public void on() {
		for (Output output : outputs) {
			output.turnOn();
		}		
	}
}
