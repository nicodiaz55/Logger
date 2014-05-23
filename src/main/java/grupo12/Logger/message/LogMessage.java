package grupo12.Logger.message;

import grupo12.Logger.level.Level;

import java.util.Date;

public class LogMessage {

	private Level level;
	private CallerInfo info;
	private String message;
	private String formatedMessage;

	public LogMessage(Level level, String message) {
		this.level = level;
		this.info = new CallerInfo();
		this.message = message;
		this.formatedMessage = message;
	}

	public String getLineNumber() {
		return info.getLineNumber();
	}
	
	public String getThreadName() {
		return info.getThreadName();
	}
	
	public String getCallingMethodName() {
		return info.getCallingMethodName();
	}
	
	public Date getTimestamp() {
		return info.getTimestamp();
	}
	
	public String getCallingFilename() {
		return info.getCallingFilename();
	}
	
	public Level getLevel() {
		return level;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void changeFormat(String newFormat) {
		formatedMessage = newFormat;
	}
	
	public String toString() {
		return formatedMessage;
	}

}
