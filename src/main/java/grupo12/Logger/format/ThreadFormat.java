package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

/**
 * Details the format needed for Thread. Inherits from Format class.
 * @author Grupo 12
 *
 */
public class ThreadFormat extends Format {

	/**
	 * Constructor
	 */
	public ThreadFormat() {
		super("%t");
	}
	
	/**
	 * Overrides the format method from Format class according to ThreadFormat needs.
	 * @param message to log
	 * 
	 */
	@Override
	public void format(LogMessage message) {
		String threadName = message.getThreadName();
		updateFormat(message, threadName);
	}

}
