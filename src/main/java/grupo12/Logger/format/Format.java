package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

public abstract class Format {
	
	protected String pattern;
	
	public Format(String flag) {
		pattern = "(?<!%)";
		pattern = pattern.concat(flag);
	}
	
	public abstract void format(LogMessage message);
	
	protected void updateFormat(LogMessage message,String data) {
		String oldFormat = message.toString();
		String newFormat = oldFormat.replaceAll(pattern,data);
		message.changeFormat(newFormat);
	}
}
