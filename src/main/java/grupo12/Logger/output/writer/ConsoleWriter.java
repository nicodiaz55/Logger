package grupo12.Logger.output.writer;

/**
 * Class that writes a message to the console.
 * 
 * @author Grupo 12
 */
public class ConsoleWriter implements Writer {

	/**
	 * Writes a message to console. 
	 */
	@Override
	public void write(String message) {
		System.out.println(message);
	}

	@Override
	public void init() throws NotInitializedException { }

	@Override
	public void end() { }

	@Override
	public boolean equals(Object anObject) {
		return anObject instanceof ConsoleWriter;
	}

	@Override
	public boolean canWrite() {
		return true;
	}
}
