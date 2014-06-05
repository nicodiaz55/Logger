package grupo12.Logger.output;

import java.io.FileNotFoundException;

import grupo12.Logger.format.Formatter;
import grupo12.Logger.level.Level;
import grupo12.Logger.message.LogMessage;

/**
 * This class represent an output. Writes and formats a message
 * to an output according to its level.
 * 
 * @author Grupo 12
 */
public class Output {

	private Level level;
	private Writer writer;
	private Formatter formatter;
	private boolean logging;
	
	/**
	 * Creates an Output.
	 * It requires a level, a writer and a formatter.
	 * 
	 * @param level of the output. Required to filter the messages to log.
	 * @param writer implementation. Could be a {@link ConsoleWriter} or a {@link grupo12.Logger.output.FileWriter FileWriter}.
	 * @param formatter to format the messages.
	 */
	public Output(Level level, Writer writer, Formatter formatter) {
		setLevel(level);
		setOutput(writer);
		setFormatter(formatter);
	}
	
	/**
	 * Sets the {@link Level} of the Output.
	 * 
	 * @param level to set.
	 */
	private void setLevel(Level level) {
		this.level = level;
	}
	
	/**
	 * Sets the {@link grupo12.Logger.format.Formatter Formatter} of the Output.
	 * 
	 * @param formatter to set.
	 */
	private void setFormatter(Formatter formatter) {
		this.formatter = formatter;
	}
	
	/**
	 * Sets the output {@link grupo12.Logger.output.Writer Writer}.
	 * 
	 * @param output ({@link grupo12.Logger.output.Writer Writer}) to set.
	 */
	public void setOutput(Writer output) {
		logging = false;	
		writer = output;
	}
	
	/**
	 * Logs the {@link LogMessage} (if publishable) to the defined output and format.
	 * 
	 * @param message to log
	 */
	public void log(LogMessage message) {
		if (isOn() && isPublishable(message)) {
			String formatedMessage = message.toString();
			if (formatter != null)
				 formatedMessage = formatter.format(message);
			writer.write(formatedMessage);
		}
	}

	/**
	 * Returns if the Output is logging.
	 */
	private boolean isOn() {
		return logging;
	}

	/** 
	 * Verifies if the {@link LogMessage} is publishable in this output.
	 * 
	 * @param the message to log.
	 */
	private boolean isPublishable(LogMessage message) {
		// If no level is seted, all messages are publishable
		if (level == null)
			return true;
		
		// TODO: aca iría el filtro, si lo dejamos pasar o no.
		
		return level.majorThan(message.getLevel());
	}

	/**
	 * Closes the output.
	 */
	public void end() {
		if (writer != null)
			writer.end();
	}

	/**
	 * Turns off the output, it will no longer log.
	 */
	public void turnOff() {
		logging = false;
	}

	/**
	 * Turns on the output, it will log.
	 */
	public void turnOn() {
		if (writer != null)
			logging = true;
	}

	public void init() {
		if (writer != null) {
			try {
				writer.init();
				logging = true;
			} catch (FileNotFoundException e) {
				// TODO: tirar excepcion?
				logging = false;
			}
		}
	}
}
