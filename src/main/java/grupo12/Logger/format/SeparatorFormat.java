package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

/**
 * Details the format needed for Separators. Inherits from Format class.
 * @author Grupo 12
 *
 */
public class SeparatorFormat extends Format {
	
	private String separator;
	
	/**
	 * Constructor
	 * @param the character/s which will be used as separator
	 */
	public SeparatorFormat(String separator) {
		super("%n");
		this.separator = separator;
	}

	/**
	 * Overrides the format method from Format class according to SeparatorFormat needs.
	 * @param message to log
	 * 
	 */
	@Override
	public void format(LogMessage message) {
		updateFormat(message, separator);
	}

}
