package grupo12.Logger.api;

import grupo12.Logger.level.Debug;
import grupo12.Logger.level.Fatal;
import grupo12.Logger.level.Info;
import grupo12.Logger.level.Warning;
import grupo12.Logger.level.Error;
import grupo12.Logger.message.LogMessage;
import grupo12.Logger.output.OutputManager;

import java.util.ArrayList;
import java.util.List;

public class Logger {
	private List<OutputManager> managers;
	
	public Logger() {
		managers = new ArrayList<OutputManager>();
	}
	
	// Para que el usuario pueda modificarlo on demand
	public void addOutput(OutputManager manager) {
		// TODO: revisar que no agregue uno que ya estaba agregado
		managers.add(manager);
	}

	// TODO: agregar uno para sacar output manager (?)
	
	private void log(LogMessage message) {
		for (OutputManager manager : managers) {
			manager.log(message);
		}
	}
	
	public void debug(String message) {
		LogMessage logMessage = new LogMessage(new Debug(), message);
		log(logMessage);
	}
	
	public void info(String message) {
		LogMessage logMessage = new LogMessage(new Info(), message);
		log(logMessage);
	}
	
	public void warn(String message) {
		LogMessage logMessage = new LogMessage(new Warning(), message);
		log(logMessage);
	}
	
	public void error(String message) {
		LogMessage logMessage = new LogMessage(new Error(), message);
		log(logMessage);
	}
	
	public void fatal(String message) {
		LogMessage logMessage = new LogMessage(new Fatal(), message);
		log(logMessage);
	}
	
	public void endLog() {
		for (OutputManager manager : managers) {
			manager.endLog();
		}		
	}

	public void off() {
		for (OutputManager manager : managers) {
			manager.turnOff();
		}		
	}
	
	public void on() {
		for (OutputManager manager : managers) {
			manager.turnOn();
		}		
	}
}
