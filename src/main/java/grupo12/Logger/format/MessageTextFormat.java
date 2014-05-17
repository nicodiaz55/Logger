package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

public class MessageTextFormat implements Format {

	static final String pattern = "(?<!%)%m";
	
	@Override
	public void format(LogMessage message) {
		String oldRepr = message.toString() ;
		String newRepr = oldRepr.replaceAll(pattern, message.getMessage());
		message.changeFormat(newRepr);
	}

}
