package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

public class LineNumberFormat extends Format {

	public LineNumberFormat() {
		super("%L");
	}
	
	@Override
	public void format(LogMessage message) {
		String lineNumber = Integer.toString(message.getLineNumber());
		updateFormat(message, lineNumber);
	}
}