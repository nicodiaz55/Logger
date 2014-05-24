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

public class Logger {
	private List<Output> outputs;
	static final private int stCallerDepth = 3;
	
	public Logger() {
		outputs = new ArrayList<Output>();
	}
	
	private StackTraceElement getCallingStackTraceElement() {
		StackTraceElement[] st = Thread.currentThread().getStackTrace();
		StackTraceElement callingSTE = st[stCallerDepth];
		return callingSTE;
	}
	
	// Para que el usuario pueda modificarlo
	public void addOutput(Output output) {
		outputs.add(output);
	}
	
	private void log(LogMessage message) {
		for (Output output : outputs) {
			output.log(message);
		}
	}
	
	public void debug(String message) {
		LogMessage logMessage = new LogMessage(new Debug(), message, getCallingStackTraceElement());
		log(logMessage);
	}

	public void info(String message) {
		LogMessage logMessage = new LogMessage(new Info(), message, getCallingStackTraceElement());
		log(logMessage);
	}
	
	public void warn(String message) {
		LogMessage logMessage = new LogMessage(new Warning(), message, getCallingStackTraceElement());
		log(logMessage);
	}
	
	public void error(String message) {
		LogMessage logMessage = new LogMessage(new Error(), message, getCallingStackTraceElement());
		log(logMessage);
	}
	
	public void fatal(String message) {
		LogMessage logMessage = new LogMessage(new Fatal(), message, getCallingStackTraceElement());
		log(logMessage);
	}
	
	public void endLog() {
		for (Output output : outputs) {
			output.endLog();
		}		
	}

	public void off() {
		for (Output output : outputs) {
			output.turnOff();
		}		
	}
	
	public void on() {
		for (Output output : outputs) {
			output.turnOn();
		}		
	}
}
