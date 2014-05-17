package grupo12.Logger.message;

import java.util.Date;

public class LogMessage {

	private Level level;
	private CallerInfo info;
	private String message;
	private String formatedMessage;

	public LogMessage(String level, String message, CallerInfo info) {
		this.level = new Level(level);
		this.info = info;
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
		return this.level;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void changeFormat(String newFormat) {
		this.formatedMessage = newFormat;
	}
	
	public String toString() {
		return formatedMessage;
	}

}
