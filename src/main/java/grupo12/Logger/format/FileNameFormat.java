package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

/**
 * Details the format needed for file names. Inherits from Format class.
 * @author Grupo 12
 *
 */
public class FileNameFormat extends Format {

	/**
	 * Constructor.
	 */
	public FileNameFormat() {
		super("%F");
	}
	
	/**
	 * Overrides the format method from Format class according to FileNameFormat needs.
	 * @param message to log
	 * 
	 */
	@Override
	public void format(LogMessage message) {
		String methodName = message.getCallingFilename();
		updateFormat(message, methodName);
	}

}
