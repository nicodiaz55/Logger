package grupo12.Logger.output.filter;

import grupo12.Logger.message.LogMessage;

/**
 * Just an example filter that explains how to implement the Filter interface.
 * 
 * @author Grupo 12
 */
public class ExampleFilter implements Filter {

	/**
	 * This filter only let pass LogMessages witch message is "This message passes the filter".
	 */
	@Override
	public boolean filter(LogMessage message) {
		// We can filter for any attribute of LogMessage, for example:
		return message.getMessage().equals("This message passes the filter");
	}

}
