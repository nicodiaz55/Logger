package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

public class LevelFormat implements Format {

	static final String pattern = "(?<!%)%p";
	
	@Override
	public void format(LogMessage message) {
		String oldRepr = message.toString();
		String messageLevel = message.getLevel().toString();
		String newRepr = oldRepr.replaceAll(pattern,messageLevel);
		message.changeFormat(newRepr);
	}

}
