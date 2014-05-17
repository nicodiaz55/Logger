package grupo12.Logger.output;

public class WriterFactory {
	public Writer getWriter(String output) {
		if (output.equals("console"))
			return new ConsoleWriter();
		// Everything else is considered a file:
		return new RecordWriter(output);
	}
}
