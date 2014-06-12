package grupo12.Logger.output;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Writes messages to a file.
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
	
	/**
	 * Returns if it can write to the file.
	 */
	public boolean canWrite() {
		return (writer != null);
	}
	
	public void write(String message) {
		if (canWrite()) {
			writer.println(message);
		}
	}

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

}
