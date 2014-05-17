package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

public class FileNameFormat implements Format {

	static final String pattern = "(?<!%)%F";
	
	@Override
	public void format(LogMessage message) {
		String oldRepr = message.toString();
		String methodName = message.getCallingFilename();
		String newRepr = oldRepr.replaceAll(pattern,methodName);

		message.changeFormat(newRepr);
	}

}
