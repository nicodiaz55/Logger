package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

public class LoggerNameFormat extends Format {

	public LoggerNameFormat() {
		super("%g");
	}

	@Override
	public void format(LogMessage message) {
		String name = message.getLoggerName();
		updateFormat(message, name);
	}

}
