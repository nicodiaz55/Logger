package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

public class MethodNameFormat extends Format {
	
	public MethodNameFormat() {
		super("%M");
	}
	
	@Override
	public void format(LogMessage message) {
		String methodName = message.getCallingMethodName();
		updateFormat(message, methodName);
	}

}
