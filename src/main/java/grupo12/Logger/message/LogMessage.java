package grupo12.Logger.message;

import grupo12.Logger.level.Level;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

/**
 * The message which is logged. It has a level and a caller info. It also carries a string message and a formatted string message.
 * @author grupo12
 *
 */
public class LogMessage {

	private Level level;
	private CallerInfo info;
	private String loggerName;
	private String message;
	private String formatedMessage;
	private Throwable exception;

	// TODO: este constructor recibe muchos parametros...
	
	/**
	 * Constructor
	 * @param message level
	 * @param string message to log
	 * @param callingSTE is a StackTraceElement in order to know where the message came from. Goes to CallerInfo
	 * @param exception to log
	 * @param loggerName the name of the Logger
	 */
	public LogMessage(Level level, String message, StackTraceElement callingSTE, Throwable exception, String loggerName) {
		this.loggerName = loggerName;
		this.level = level;
		this.info = new CallerInfo(callingSTE);
		this.message = message;
		this.formatedMessage = message;
		this.exception = exception;
		
		// Concatenate de excepcion stack trace:
		if (exception != null) {
			StringWriter error = new StringWriter();
			exception.printStackTrace(new PrintWriter(error));
		
			this.message += "\n   " + error.toString();
		}
	}

	public Throwable getExecption() {
		return exception;
	}
	
	/**
	 * Getter for the logger name
	 * @return the name of the logger
	 */
	public String getLoggerName() {
		return loggerName;
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
