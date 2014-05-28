package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

/**
 * Details the format needed for Literals. Inherits from Format class.
 * @author Grupo 12
 *
 */
public class LiteralFormat extends Format {
	
	/**
	 * Constructor
	 */
	public LiteralFormat() {
		super("");
		pattern = "%%";
	}
	
	/**
	 * Overrides the format method from Format class according to LiteralFormat needs.
	 * @param message to log
	 * 
	 */
	@Override
	public void format(LogMessage message) {
		updateFormat(message, "%");
	}

}
