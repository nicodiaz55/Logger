package otro;

import grupo12.Logger.output.writer.NotInitializedException;
import grupo12.Logger.output.writer.Writer;

import java.util.ArrayList;

public class MiEscritor implements Writer {

	public static ArrayList<String> lista = new ArrayList<String>();
	
	@Override
	public void write(String message) {
		System.out.println("ESCRIBI2: " + message.toString());
		lista.add(message);
	}

	@Override
	public void init() throws NotInitializedException {
		
	}

	@Override
	public void end() {	}

	@Override
	public boolean canWrite() {
		return true;
	}

}
