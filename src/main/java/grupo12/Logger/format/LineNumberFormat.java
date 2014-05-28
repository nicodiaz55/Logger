package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

/**
 * Details the format needed for Line Numbers. Inherits from Format class.
 * @author Grupo 12
 *
 */
public class LineNumberFormat extends Format {

	/**
	 * Constructor
	 */
	public LineNumberFormat() {
		super("%L");
	}
	
	/**
	 * Overrides the format method from Format class according to LineNumberFormat needs.
	 * @param message to log
	 * 
	 */
	@Override
	public void format(LogMessage message) {
		String lineNumber = Integer.toString(message.getLineNumber());
		updateFormat(message, lineNumber);
	}
}