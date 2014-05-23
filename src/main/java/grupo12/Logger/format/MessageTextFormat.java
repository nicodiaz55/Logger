package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

public class MessageTextFormat extends Format {

	public MessageTextFormat() {
		super("%m");
	}

	@Override
	public void format(LogMessage message) {
		String rawMessage = message.getMessage();
		updateFormat(message, rawMessage);
	}

}
