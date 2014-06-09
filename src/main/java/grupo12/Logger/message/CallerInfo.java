package grupo12.Logger.message;

import java.util.Date;
/**
 * This class deals with the information concerning the Caller to a log message.
 * Contains info regarding the time when it was called, the line number in the code, which method, which thread, etc.
 * @author Grupo12
 *
 */
public class CallerInfo {

	private Date timestamp;
	private StackTraceElement callerStackTraceElement;
	
	/**
	 * Constructor.
	 * @param StackTraceElement which represents the callingLine to the logging method
	 */
	public CallerInfo(StackTraceElement callingLine) {
		timestamp = new Date();
		callerStackTraceElement = callingLine;
	}
	
	/**
	 * Getter for the line number
	 * @return the line number where log method was called
	 */
	public int getLineNumber() {
		if (callerStackTraceElement == null) {
			return 0;
		}
		return callerStackTraceElement.getLineNumber();
	}
	/**
	 * Getter for the thread name
	 * @return the thread name where log method was called
	 */
	public String getThreadName() {
		return Thread.currentThread().getName();
	}

	/**
	 * Getter for the method name
	 * @return the method name where log method was called
	 */
	public String getCallingMethodName() {
		if (callerStackTraceElement == null) {
			return "";
		}
		return callerStackTraceElement.getMethodName();
	}
	/**
	 * Getter for the time stamp
	 * @return the date and time where log method was called
	 */
	public Date getTimestamp() {
		return timestamp;
	}
	/**
	 * Getter for the file name
	 * @return the name of the file where log method was called
	 */
	public String getCallingFilename() {
		if (callerStackTraceElement == null) {
			return "";
		}
		return callerStackTraceElement.getFileName();
	}

}
