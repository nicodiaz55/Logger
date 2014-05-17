package grupo12.Logger.api;

import grupo12.Logger.message.CallerInfo;
import grupo12.Logger.message.LogMessage;
import grupo12.Logger.output.OutputManager;

import java.util.ArrayList;

public class Logger {
	private ArrayList<OutputManager> managers;
	
	public Logger() {
		managers = new ArrayList<OutputManager>();
	}
	
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
		LogMessage logMessage = new LogMessage("DEBUG", message, new CallerInfo());
		log(logMessage);
	}
	
	public void info(String message) {
		LogMessage logMessage = new LogMessage("INFO", message, new CallerInfo());
		log(logMessage);
	}
	
	public void warn(String message) {
		LogMessage logMessage = new LogMessage("WARNING", message, new CallerInfo());
		log(logMessage);
	}
	
	public void error(String message) {
		LogMessage logMessage = new LogMessage("ERROR", message, new CallerInfo());
		log(logMessage);
	}
	
	public void fatal(String message) {
		LogMessage logMessage = new LogMessage("FATAL", message, new CallerInfo());
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
