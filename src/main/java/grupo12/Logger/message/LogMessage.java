package grupo12.Logger.message;

import grupo12.Logger.level.Level;

import java.util.Date;

/**
 * The message which is logged. It has a level and a caller info. It also carries a string message and a formatted string message.
 * @author grupo12
 *
 */
public class LogMessage {

	private Level level;
	private CallerInfo info;
	private String message;
	private String formatedMessage;

	/**
	 * Constructor
	 * @param message level
	 * @param string message to log
	 * @param StackTraceElement acting as callingSTE, in order to know where the message came from. Goes to CallerInfo.
	 */
	public LogMessage(Level level, String message,StackTraceElement callingSTE) {
		this.level = level;
		this.info = new CallerInfo(callingSTE);
		this.message = message;
		this.formatedMessage = message;
	}

	public int getLineNumber() {
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
