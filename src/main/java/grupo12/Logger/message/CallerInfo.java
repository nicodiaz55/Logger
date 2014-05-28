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
	

	public int getLineNumber() {
		return callerStackTraceElement.getLineNumber();
	}

	public String getThreadName() {
		return Thread.currentThread().getName();
	}

	public String getCallingMethodName() {
		return callerStackTraceElement.getMethodName();
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getCallingFilename() {
		return callerStackTraceElement.getFileName();
	}

}
