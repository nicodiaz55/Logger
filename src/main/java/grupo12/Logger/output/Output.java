package grupo12.Logger.output;

import grupo12.Logger.format.Formatter;
import grupo12.Logger.message.LogMessage;
import grupo12.Logger.filter.*;

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
	private Filterer filterer;
	
	/**
	 * Creates an Output.
	 * It requires a {@link grupo12.Logger.output.Writer Writer} and a {@link grupo12.Logger.output.Formatter Formatter}.
	 * 
	 * @param writer implementation.igual, eso funca...  Could be a {@link ConsoleWriter} or a {@link grupo12.Logger.output.FileWriter FileWriter}.
	 * @param formatter to format the messages.
	 */
	public Output() {
		writer = null;
		formatter = null;
		filterer = null;
	}
	
	/**
	 * Sets the {@link grupo12.Logger.format.Formatter Formatter} of the Output.
	 * 
	 * @param formatter to set.
	 */
	public void setFormatter(Formatter formatter) {
		this.formatter = formatter;
	}
	
	/**
	 * Sets the output {@link grupo12.Logger.output.Writer Writer}.
	 * 
	 * @param outputWriter ({@link grupo12.Logger.output.Writer Writer}) to set.
	 */
	public void setWriter(Writer outputWriter) {
		if (writer != null) {
			writer.end();
		}
		logging = false;
		writer = outputWriter;
	}
	
	/**
	 * Sets the {@link grupo12.Logger.filter.Filter Filter} of the Output.
	 * 
	 * @param filter to set.
	 */
	public void setFilterer(Filterer filterer) {
		this.filterer = filterer;
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
			if (filterer.getCustomFilter().equals("")){
				formatedMessage=filterer.filter(formatedMessage);
			}else{
				formatedMessage=filterer.customFilter(formatedMessage);
			}
			writer.write(formatedMessage);
		}
	}

	/**
	 * Returns if the Output is logging.
	 */
	public boolean isOn() {
		return logging;
	}

	/**
	 * Closes the output.
	 */
	public void end() {
		if (writer != null) {
			writer.end();
			writer = null;
			logging = false;
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
