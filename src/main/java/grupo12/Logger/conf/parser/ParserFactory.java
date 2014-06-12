package grupo12.Logger.conf.parser;

/**
 * Class that creates specific {@link grupo12.Logger.parser.Parser Parser}s implementations according to a String.
 * 
 * @author Grupo 12
 */
public class ParserFactory {
	
	/**
	 * Returns a instantiated {@link grupo12.Logger.parser.Parser Parser} according to the file type.
	 * 
	 * @param file to parse
	 * @return a Parser implementation.
	 */
	public Parser getParser(String file) {
		String fileType = file.substring(file.lastIndexOf("."));
		switch (fileType) {
		case ".xml":
			return new XMLParser(file);
		case ".properties":
			return new PropertiesParser(file);
		default:
			return null;
		}
	}

}
