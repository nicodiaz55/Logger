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
	private Throwable exception;

	/**
	 * Constructor
	 * @param message level
	 * @param string message to log
	 * @param callingSTE, a StackTraceElement in order to know where the message came from. Goes to CallerInfo.
	 * @param exception to log
	 */
	public LogMessage(Level level, String message, StackTraceElement callingSTE, Throwable exception) {
		this.level = level;
		this.info = new CallerInfo(callingSTE);
		this.message = message;
		this.formatedMessage = message;
		this.exception = exception;
	}

	public Throwable getExecption() {
		return exception;
	}
	
	/**
	 * Getter for the line number
	 * @return the line number where log method was called
	 */
	public int getLineNumber() {
		return info.getLineNumber();
	}
	
	/**
	 * Getter for the thread name
	 * @return the thread name where log method was called
	 */
	public String getThreadName() {
		return info.getThreadName();
	}
	
	/**
	 * Getter for the method name
	 * @return the method name where log method was called
	 */
	public String getCallingMethodName() {
		return info.getCallingMethodName();
	}
	/**
	 * Getter for the time stamp
	 * @return the date and time where log method was called
	 */
	public Date getTimestamp() {
		return info.getTimestamp();
	}
	/**
	 * Getter for the file name
	 * @return the name of the file where log method was called
	 */
	public String getCallingFilename() {
		return info.getCallingFilename();
	}
	/**
	 * Getter for the level
	 * @return level to which the logmessage belongs to
	 */
	public Level getLevel() {
		return level;
	}
	/**
	 * Getter for the message
	 * @return string containing the message
	 */
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
