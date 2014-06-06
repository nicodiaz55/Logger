package grupo12.Logger.output;

/**
 * Class that writes a message to the console.
 * 
 * @author Grupo 12
 */
public class ConsoleWriter implements Writer {

	public void write(String message) {
		System.out.println(message);
	}

	public void init() throws NotInitializedException { }

	public void end() { }

	@Override
	public boolean equals(Object anObject) {
		return anObject instanceof ConsoleWriter;
	}
}
