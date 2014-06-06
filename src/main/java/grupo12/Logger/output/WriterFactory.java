package grupo12.Logger.output;

/**
 * Class that creates specific {@link grupo12.Logger.output.Writer Writer}s according to a String.
 * 
 * @author Grupo 12
 */
public class WriterFactory {
	
	public static final String CONSOLE = "console";
	
	/**
	 * Returns a instantiated {@link grupo12.Logger.output.Writer Writer} accodring to its name.
	 * 
	 * @param output name.
	 * @return a Writer implementation.
	 */
	public Writer getWriter(String output) {
		if (output.equals(CONSOLE)) {
			return new ConsoleWriter();
		} else {
			return new FileWriter(output);
		}
	}
}
