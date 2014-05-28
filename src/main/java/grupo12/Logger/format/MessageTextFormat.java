package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

/**
 * Details the format needed for MessageTexts. Inherits from Format class.
 * @author Grupo 12
 *
 */
public class MessageTextFormat extends Format {

	/**
	 * Constructor
	 */
	public MessageTextFormat() {
		super("%m");
	}

	/**
	 * Overrides the format method from Format class according to MessageTexts needs.
	 * @param message to log
	 * 
	 */
	@Override
	public void format(LogMessage message) {
		String rawMessage = message.getMessage();
		updateFormat(message, rawMessage);
	}

}
