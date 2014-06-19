package grupo12.Logger.format;

import java.util.regex.Matcher;

import grupo12.Logger.message.LogMessage;

/**
 * Abstract class responsible for formats. Instances contained by Formatter.
 * @author Grupo 12
 *
 */
public abstract class Format {
	
	protected String pattern;
	
	/**
	 * Constructor.
	 * @param flag according to which kind of format is needed.
	 */
	public Format(String flag) {
		pattern = "(?<!%)";
		pattern = pattern.concat(flag);
	}
	
	/**
	 * Method to override
	 * @param message to log
	 */
	public abstract void format(LogMessage message);
	
	/**
	 * Format updater.
	 * @param message to log
	 * @param data which replaces old format
	 */
	protected void updateFormat(LogMessage message, String data) {
		String oldFormat = message.toString();
		String newFormat = oldFormat.replaceAll(pattern, Matcher.quoteReplacement(data));
		message.changeFormat(newFormat);
	}
}
