package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

public class JsonFormatter implements Formatter {

	@Override
	public String format(LogMessage message) {
		// TODO: No se si esto es lo pedido por el enunciado...
		return "{‘datetime’: ‘" + message.getTimestamp().toString() + "’, ‘level’: ‘" + message.getLevel().toString() + "’, ‘logger’: ‘" + message.getLoggerName() + "’, ‘message’: ‘" + message.getMessage() + "’}";
	}

}
