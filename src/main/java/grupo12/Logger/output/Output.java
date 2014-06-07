package grupo12.Logger.output;

import grupo12.Logger.format.Formatter;
import grupo12.Logger.message.LogMessage;

/**
 * This class represent an output. Writes and formats a message
 * to an output according to its level.
 * 
 * @author Grupo 12
 */
public class Output {

	private Writer writer;
	private Formatter formatter;
	private boolean logging;
	
	/**
	 * Creates an Output.
	 * It requires a {@link grupo12.Logger.output.Writer Writer} and a {@link grupo12.Logger.output.Formatter Formatter}.
	 * 
	 * @param writer implementation. Could be a {@link ConsoleWriter} or a {@link grupo12.Logger.output.FileWriter FileWriter}.
	 * @param formatter to format the messages.
	 */
	public Output(Writer writer, Formatter formatter) {
		setOutput(writer);
		setFormatter(formatter);
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
		if (isOn()) {
			String formatedMessage = message.toString();
			if (formatter != null) {
				 formatedMessage = formatter.format(message);
			}
			// TODO: Meter filtro aca
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
	 * Closes the output.
	 */
	public void end() {
		if (writer != null) {
			writer.end();
		}
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
		if (writer != null) {
			logging = true;
		}
	}

	public void init() {
		if (writer != null) {
			try {
				writer.init();
				logging = true;
			} catch (NotInitializedException e) {
				System.out.println("Warning: Output not initialized. Reason: " + e.getMessage());
				logging = false;
			}
		}
	}
}
