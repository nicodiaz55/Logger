package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

public class FileNameFormat extends Format {

	public FileNameFormat() {
		super("%F");
	}
	
	@Override
	public void format(LogMessage message) {
		String methodName = message.getCallingFilename();
		updateFormat(message, methodName);
	}

}
