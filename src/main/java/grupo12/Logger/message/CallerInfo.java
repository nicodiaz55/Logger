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
		thread = Thread.currentThread().getName();
		// TODO: Verificar que estamos accediendo correctamente a los datos del Stack:
		int len = Thread.currentThread().getStackTrace().length-1;
		line = Integer.toString(Thread.currentThread().getStackTrace()[len].getLineNumber());
		method = Thread.currentThread().getStackTrace()[len].getMethodName();
		file = Thread.currentThread().getStackTrace()[len].getFileName();
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
