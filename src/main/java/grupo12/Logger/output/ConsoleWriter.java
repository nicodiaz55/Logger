package grupo12.Logger.output;

public class ConsoleWriter implements Writer {

	public void write(String message) {
		System.out.println(message);
	}

	public void init() {}

	public void end() {}

	@Override
	public boolean equals(Object anObject) {
		return anObject instanceof ConsoleWriter;
	}
}
