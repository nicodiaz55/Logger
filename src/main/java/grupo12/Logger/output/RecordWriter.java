package grupo12.Logger.output;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class RecordWriter implements Writer {

	private String filename;
	private PrintWriter writer;
	private boolean ok;
	
	public RecordWriter(String filename) {
		writer = null;
		// TODO: Ver si tengo que meter el init aca... o dejar que lo haga OutputManager.
		this.filename = filename;
		ok = false;
	}
	
	private boolean canWriter() {
		return ok;
	}
	
	public void write(String message) {
		if(canWriter()) {
			writer.println(message);
		}
	}

	public void init() {
		try {
			writer = new PrintWriter(filename);
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			writer = null;
			ok = false;
		}
		ok = true;
	}

	public void end() {
		if (writer != null)
			writer.close();
		filename = "";
		writer = null;
	}

}
