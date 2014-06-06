package grupo12.Logger.format;

import grupo12.Logger.format.Format;

import java.util.ArrayList;
import java.util.List;

import grupo12.Logger.message.LogMessage;

/**
 * Formats a {@link LogMessage} according to a pattern.
 * Used by an output, contains different Formats.
 * 
 * @author Grupo 12
 */
public class Pattern implements Formatter {

	private List<Format> formatList;
	private String format;
	
	/**
	 * Constructor. Needs a format and one or more characters to use as a separator.
	 * Creates an array of formats and adds all the kinds of formats available
	 * @param format needed to create a format array
	 * @param separator
	 */
	public Pattern(String format, String separator) {
		this.format = format;
		formatList = new ArrayList<Format>();
		
		formatList.add(new MessageTextFormat());
		formatList.add(new FileNameFormat());
		formatList.add(new LevelFormat());
		formatList.add(new MethodNameFormat());
		formatList.add(new SeparatorFormat(separator));
		formatList.add(new ThreadFormat());
		formatList.add(new DateFormat());
		formatList.add(new LiteralFormat());
		formatList.add(new LineNumberFormat());
		formatList.add(new LoggerNameFormat());
	}
	
	public String format(LogMessage message) {
		message.changeFormat(format);
		for (Format formatter : formatList) {
			formatter.format(message);
		}
		return message.toString();
	}

}
