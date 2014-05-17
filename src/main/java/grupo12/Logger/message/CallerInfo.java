package grupo12.Logger.message;

import java.util.Date;

public class CallerInfo {

	private Date timestamp;
	private String line;
	private String thread;
	private String method;
	private String file;
	
	public CallerInfo() {
		timestamp = new Date();
		line = "-1"; // TODO
		thread = Thread.currentThread().getName();
		method = "null"; // TODO
		file = "null"; // TODO
	}
	
	public String getLineNumber() {
		return line;
	}

	public String getThreadName() {
		return thread;
	}

	public String getCallingMethodName() {
		return method;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getCallingFilename() {
		return file;
	}

}
