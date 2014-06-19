package grupo12.Logger.output.writer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Class that writes messages to a file.
 * 
 * @author Grupo 12
 */
public class FileWriter implements Writer {

	private String filename;
	private PrintWriter writer;
	
	/**
	 * Creates a FileWriter that writes to a file.
	 * 
	 * @param filename to write.
	 */
	public FileWriter(String filename) {
		this.filename = filename;
		writer = null;
	}
	
	@Override
	public boolean canWrite() {
		return (writer != null);
	}
	
	/**
	 * Writes the message to the file.
	 */
	@Override
	public void write(String message) {
		if (canWrite()) {
			writer.println(message);
		}
	}

	@Override
	public void init() throws NotInitializedException {
		try {
			writer = new PrintWriter(filename);
		} catch (FileNotFoundException e) {
			writer = null;
			throw new NotInitializedException("Can't open the file " + filename);
		} catch (NullPointerException e) {
			writer = null;
			throw new NotInitializedException("The file name passed is null");
		}
	}

	@Override
	public void end() {
		if (writer != null) {
			writer.close();
		}
		writer = null;
		filename = "";
	}
	
	@Override
	public boolean equals(Object anObject) {
		if (!(anObject instanceof FileWriter)) {
			return false;
		} else {
			FileWriter other = (FileWriter) anObject;
			return filename.equals(other.filename);
		}
	}
	
	@Override
	public int hashCode() {
		int h=277;
		int fileNameLen = filename.length();
		for (int i = 0; i < fileNameLen; i++) {
		    h = 31*h + filename.charAt(i);
		  }
		return h * 37;
	}

}
