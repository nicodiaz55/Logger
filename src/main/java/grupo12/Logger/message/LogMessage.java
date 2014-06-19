package grupo12.Logger.message;

import grupo12.Logger.level.Level;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

/**
 * The message that is logged. It has a level and a caller info. It also carries a string message and a formatted string message.
 * 
 * @author Grupo 12
 */
public class LogMessage {

	private Level level;
	private CallerInfo info;
	private String loggerName;
	private String message;
	private String formatedMessage;
	private Throwable exception;
	
	/**
	 * Constructor
	 * 
	 * @param message level
	 * @param string message to log
	 * @param callingSTE is a StackTraceElement in order to know where the message came from. Goes to CallerInfo
	 * @param exception to log
	 * @param loggerName the name of the Logger
	 */
	public LogMessage(Level level, String message, StackTraceElement callingSTE, Throwable exception, String loggerName) {
		if (loggerName == null) {
			this.loggerName = "";
		} else {
			this.loggerName = loggerName;
		}
		this.level = level;
		this.info = new CallerInfo(callingSTE);
		if (message == null) {
			this.message = "";
			this.formatedMessage = "";
		} else {
			this.message = message;
			this.formatedMessage = message;
		}
		this.formatedMessage = message;
		this.exception = exception;
		
		// Concatenate de excepcion stack trace:
		if (exception != null) {
			StringWriter error = new StringWriter();
			exception.printStackTrace(new PrintWriter(error));
		
			this.message += "\n   " + error.toString();
		}
	}

	/**
	 * Returns the exception this message has.
	 * 
	 * @return an exception
	 */
	public Throwable getException() {
		return exception;
	}
	
	/**
	 * Gets the {@link grupo12.Logger.api.Logger Logger}'s name.
	 * 
	 * @return the name of the logger
	 */
	public String getLoggerName() {
		return loggerName;
	}
	
	/**
	 * Gets the number of the line.
	 * 
	 * @return the line number where the log method was called
	 */
	public int getLineNumber() {
		return info.getLineNumber();
	}
	
	/**
	 * Gets the name of the thread.
	 * 
	 * @return the thread name where the log method was called
	 */
	public String getThreadName() {
		return info.getThreadName();
	}
	
	/**
	 * Gets the name of the method
	 * 
	 * @return the method name where the log method was called
	 */
	public String getCallingMethodName() {
		return info.getCallingMethodName();
	}
	
	/**
	 * Gets the date
	 * 
	 * @return the date and time when the log method was called
	 */
	public Date getTimestamp() {
		return info.getTimestamp();
	}
	
	/**
	 * Gets the file name
	 * 
	 * @return the name of the file where the log method was called
	 */
	public String getCallingFilename() {
		return info.getCallingFilename();
	}
	
	/**
	 * Gets the level of the message
	 * 
	 * @return level of this LogMessage
	 */
	public Level getLevel() {
		return level;
	}
	
	/**
	 * Gets the message
	 * 
	 * @return the message that was logged
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Changes the format of the message (how it's going to be shown)
	 * 
	 * @param newFormat of the message
	 */
	public void changeFormat(String newFormat) {
		formatedMessage = newFormat;
	}
	
	/**
	 * Returns the string representation of the LogMessage.
	 * This is how it's going to be writen in the output.
	 * 
	 * @return the message formated for the output
	 */
	public String toString() {
		return formatedMessage;
	}
}
