package grupo12.Logger.output;

public class WriterFactory {
	
	private static final String CONSOLE = "console";
	
	public Writer getWriter(String output) {
		if (output.equals(CONSOLE))
			return new ConsoleWriter();
		// Everything else is considered a file:
		return new RecordWriter(output);
	}
}
