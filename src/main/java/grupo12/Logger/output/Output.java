package grupo12.Logger.output;

import java.io.FileNotFoundException;

import grupo12.Logger.format.Formatter;
import grupo12.Logger.level.Level;
import grupo12.Logger.message.LogMessage;

public class Output {

	private Level level;
	private Writer writer;
	private Formatter formatter;
	private boolean logging;
	
	public Output(Level level, Writer writer, Formatter formatter) {
		setLevel(level);
		setOutput(writer);
		setFormatter(formatter);
	}
	
	private void setLevel(Level level) {
		this.level = level;
	}
	
	private void setFormatter(Formatter formatter) {
		this.formatter = formatter;
	}
	
	public void setOutput(Writer output) {
		if (writer == null) {
			logging = false;
			return;
		}
		
		writer = output;
		try {
			writer.init();
			logging = true;
		} catch (FileNotFoundException e) {
			logging = false;
			writer = null;
			e.printStackTrace();
		}
	}
	
	public void log(LogMessage message) {
		if (isOn() && isPublishable(message)) {
			String formatedMessage = message.toString();
			if (formatter != null)
				 formatedMessage = formatter.format(message);
			writer.write(formatedMessage);
		}
	}

	private boolean isOn() {
		return logging;
	}

	private boolean isPublishable(LogMessage message) {
		// If no level is seted, all messages are publishable
		if (level == null)
			return true;
		
		return level.majorThan(message.getLevel());
	}

	public void endLog() {
		writer.end();
	}

	public void turnOff() {
		logging = false;
	}

	public void turnOn() {
		logging = true;
	}
}
