package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

public class JsonFormatter implements Formatter {
		
	@Override
	public String format(LogMessage message) {	
		String format = "{‘datetime’: ‘" + message.getTimestamp().toString() + "’, ‘level’: ‘" + message.getLevel().toString() + "’, ‘logger’: ‘" + message.getLoggerName() + "’, ‘message’: ‘" + message.getMessage() + "’}";
		message.changeFormat(format);
		return message.toString();
	}

	@Override
	public boolean equals(Object anObject) {
		return anObject instanceof JsonFormatter;
	}
	@Override
	public int hashCode() {
		return 293;
	}
}
