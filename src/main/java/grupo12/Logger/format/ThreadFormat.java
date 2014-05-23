package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

public class ThreadFormat extends Format {

	public ThreadFormat() {
		super("%t");
	}
	
	@Override
	public void format(LogMessage message) {
		String threadName = message.getThreadName();
		updateFormat(message, threadName);
	}

}
