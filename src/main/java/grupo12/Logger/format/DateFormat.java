package grupo12.Logger.format;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;

import grupo12.Logger.message.LogMessage;

/**
 * Details the format needed for Dates. Inherits from Format class.
 * @author Grupo 12
 *
 */
public class DateFormat extends Format {

	private static final String dateFormatPattern = "(?<!%)%d\\{([^}]*)\\}";
	private static final Locale locale = new Locale("en", "US");
	
	/**
	 * Constructor.
	 */
	public DateFormat() {
		super("%d\\{([^}]*)\\}");
	}
	
	/**
	 * Parses the message passed into the format used for dates.
	 * @param message to log
	 * @return the formatted string
	 */
	private String parseDateFormatString(LogMessage message) {
		
		String oldRepr = message.toString();
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(dateFormatPattern);
		Matcher m = pattern.matcher(oldRepr);
		if (!m.find()) {
			return "";
		}
		String dateFormatString = m.group(1);
		
		return dateFormatString;
	}
	
	/**
	 * Overrides the format method from Format class according to DateFormat needs.
	 * @param message to log
	 * 
	 */
	@Override
	public void format(LogMessage message) {
		
		Date date = message.getTimestamp();
		
		String dateFormatString = parseDateFormatString(message);

		if (!dateFormatString.isEmpty()) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString, locale);
				updateFormat(message, dateFormat.format(date));
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid Date format");
			}
		}
	}

}
