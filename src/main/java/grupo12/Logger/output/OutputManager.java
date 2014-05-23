package grupo12.Logger.output;

import grupo12.Logger.format.Formatter;
import grupo12.Logger.level.Level;
import grupo12.Logger.message.LogMessage;

public class OutputManager {

	private Level level;
	private Writer outputWriter;
	private Formatter formatter;
	private boolean imLogging;
	
	public OutputManager() {
		// TODO: revisar estos inits
		level = null;
		outputWriter = null;
		//setOutput(new ConsoleWriter()); // TODO: Default output if not set
		formatter = null; // No format if not set
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}
	
	public void setFormatter(Formatter formatter) {
		this.formatter = formatter;
	}
	
	public void setOutput(Writer output) {
		this.outputWriter = output;
		this.outputWriter.init();
		imLogging = true;
	}
	
	public void log(LogMessage message) {
		if (isPublishable(message) && isOn()) {
			String formatedMessage = message.toString();
			if (formatter != null)
				 formatedMessage = formatter.format(message);
			outputWriter.write(formatedMessage);
		}
	}

	private boolean isOn() {
		return imLogging;
	}

	private boolean isPublishable(LogMessage message) {
		// If no level is seted, all messages are publishable
		if (level == null)
			return true;
		
		return level.majorThan(message.getLevel());
	}

	public void endLog() {
		outputWriter.end();
	}

	public void turnOff() {
		imLogging = false;
	}

	public void turnOn() {
		imLogging = true;
	}
}
