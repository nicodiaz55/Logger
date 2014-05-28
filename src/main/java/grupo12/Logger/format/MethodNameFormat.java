package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

/**
 * Details the format needed for MethodNames. Inherits from Format class.
 * @author Grupo 12
 *
 */
public class MethodNameFormat extends Format {
	
	/**
	 * Constructor
	 */
	public MethodNameFormat() {
		super("%M");
	}

	/**
	 * Overrides the format method from Format class according to MethodNames needs.
	 * @param message to log
	 * 
	 */
	@Override
	public void format(LogMessage message) {
		String methodName = message.getCallingMethodName();
		updateFormat(message, methodName);
	}

}
