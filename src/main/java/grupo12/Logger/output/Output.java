package grupo12.Logger.output;

import grupo12.Logger.format.Formatter;
import grupo12.Logger.message.LogMessage;
import grupo12.Logger.output.filter.Filter;
import grupo12.Logger.output.writer.NotInitializedException;
import grupo12.Logger.output.writer.Writer;

/**
 * This class represent an output. Writes, filter and formats a message
 * to an output.
 * 
 * @author Grupo 12
 */
public class Output {

	private Writer writer;
	private Formatter formatter;
	private Filter filter;
	private boolean logging;
	
	/**
	 * Creates an empty Output.
	 */
	public Output() {
		writer = null;
		formatter = null;
		filter = null;
		logging = false;
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
	 * Sets the output {@link grupo12.Logger.output.writer.Writer Writer}.
	 * 
	 * @param outputWriter ({@link grupo12.Logger.output.writer.Writer Writer}) to set.
	 */
	public void setWriter(Writer outputWriter) {
		if (writer != null) {
			writer.end();
		}
		logging = false;
		writer = outputWriter;
	}
	
	/**
	 * Sets the {@link grupo12.Logger.output.filter.Filter Filter} of the Output.
	 * 
	 * @param filter to set.
	 */
	public void setFilter(Filter filter) {
		this.filter = filter;
	}
	
	/**
	 * Logs the {@link LogMessage} to the defined output.
	 * It can format the message and filter it.
	 * 
	 * @param message to log
	 */
	public void log(LogMessage message) {
		if (isOn()) {
			String formatedMessage = message.toString();
			if (formatter != null) {
				 formatedMessage = formatter.format(message);
			}
			
			boolean canWrite = true;
			if (filter != null) {
				canWrite = filter.filter(message);
			}
			if (canWrite) {
				writer.write(formatedMessage);
			}
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
		}
		writer = null;
		logging = false;
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

	/**
	 * Initializes the Output.
	 */
	public void init() {
		if (writer != null) {
			try {
				writer.init();
				logging = true;
			} catch (NotInitializedException e) {
				System.out.println("Warning: Writer " + writer.getClass().getName() + " not initialized. Reason: " + e.getMessage());
				logging = false;
			}
		}
	}
}
