package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

public class ThreadFormat implements Format {

	static final String pattern = "(?<!%)%t";
	
	@Override
	public void format(LogMessage message) {
		String oldRepr = message.toString();
		String threadName = message.getThreadName();
		String newRepr = oldRepr.replaceAll(pattern,threadName);
		message.changeFormat(newRepr);
	}

}
