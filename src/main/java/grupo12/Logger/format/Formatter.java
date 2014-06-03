package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

/** 
 * Formats a {@link LogMessage}.
 * 
 * @author Grupo 12
 */
public interface Formatter {
	
	/**
	 * Formats a LogMessage
	 * 
	 * @param message to format.
	 * @return the message formated.
	 */
	public String format(LogMessage message);
}
