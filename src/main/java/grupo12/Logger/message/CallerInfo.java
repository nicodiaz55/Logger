package grupo12.Logger.message;

import java.util.Date;

public class CallerInfo {

	private Date timestamp;
	private StackTraceElement callerStackTraceElement;
	
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
