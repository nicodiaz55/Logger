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
	private boolean ok;
	
	/**
	 * Creates a FileWriter that writes to a file.
	 * 
	 * @param filename to write.
	 */
	public FileWriter(String filename) {
		this.filename = filename;
		writer = null;
		ok = false;
	}
	
	/**
	 * Returns if it can write to the file.
	 */
	private boolean canWrite() {
		return ok;
	}
	
	public void write(String message) {
		if (canWrite()) {
			writer.println(message);
		}
	}

	public void init() throws FileNotFoundException {
		try {
			writer = new PrintWriter(filename);
		} catch (FileNotFoundException e) {
			writer = null;
			ok = false;
			throw e;
		}
		ok = true;
	}

	public void end() {
		if (writer != null) {
			writer.close();
		}
		writer = null;
		filename = "";
		ok = false;
	}
	
	@Override
	public boolean equals(Object anObject) {
		return anObject instanceof FileWriter;
	}

}
