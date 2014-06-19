package grupo12.Logger.output.filter;

import grupo12.Logger.message.LogMessage;

/**
 * A Filter interface
 * All filters must know how to filter a given {@link LogMessage}.
 * 
 * @author Grupo 12
 */
public interface Filter {
	/**
	 * Used to filter from specific {@link LogMessage} attributes.
	 * 
	 * @param message to filter
	 * @return if the message should pass (true) or not (false)
	 */
	public boolean filter(LogMessage message);
}
