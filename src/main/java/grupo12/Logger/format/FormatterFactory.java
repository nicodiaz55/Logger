package grupo12.Logger.format;

/**
 * Class that creates specific {@link grupo12.Logger.format.Formatter Formatter}s according to a String.
 * 
 * @author Grupo 12
 */
public class FormatterFactory {
	
	private static final String JSON = "JSON";

	/**
	 * Returns a instantiated {@link grupo12.Logger.format.Formatter Formatter} accodring to its name.
	 * 
	 * @param formatter type (JSON or a pattern).
	 * @param separator required for pattern.
	 * @return a Formatter implementation.
	 */
	public Formatter getFormatter(String formatter, String separator) {
		if (formatter.equals(JSON))
			return new JsonFormatter();
		// Everything else is considered a pattern:
		return new Pattern(formatter, separator);
	}

}
