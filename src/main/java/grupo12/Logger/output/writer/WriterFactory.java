package grupo12.Logger.output.writer;

import java.util.List;

/**
 * Class that creates specific {@link grupo12.Logger.output.writer.Writer Writer}s according to a String.
 * 
 * @author Grupo 12
 */
public class WriterFactory {
	
	public static final String CONSOLE = "console";
	
	/**
	 * Returns an instantiated {@link grupo12.Logger.output.writer.Writer Writer} according to its name.
	 * If the name is "console", it returns a {@link ConsoleWriter}.
	 * Everything else is considered a file, so it returns a {@link FileWriter}.
	 * 
	 * @param writer name
	 * @return a Writer implementation
	 */
	public Writer getWriter(String writer) {
		if (writer.equals(CONSOLE)) {
			return new ConsoleWriter();
		} else {
			return new FileWriter(writer);
		}
	}
	
	public Writer getWriter(String implementor, List<String> parameters) {
		return new CustomWriter(implementor, parameters);
	}
	
	@Override
	public int hashCode() {
		return 307;
	}
}
