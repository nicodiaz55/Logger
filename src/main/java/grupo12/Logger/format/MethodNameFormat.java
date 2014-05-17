package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

public class MethodNameFormat implements Format {

	static final String pattern = "(?<!%)%M";
	
	@Override
	public void format(LogMessage message) {
		String oldRepr = message.toString();
		String methodName = message.getCallingMethodName();
		String newRepr = oldRepr.replaceAll(pattern,methodName);
		message.changeFormat(newRepr);
	}

}
