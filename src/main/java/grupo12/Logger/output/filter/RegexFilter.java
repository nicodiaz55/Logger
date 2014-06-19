package grupo12.Logger.output.filter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import grupo12.Logger.message.LogMessage;

/**
 * Class that uses regular expresions to filter.
 * 
 * @author Grupo 12
 */
public class RegexFilter implements Filter {

	Pattern pattern; // java.util.regex.Pattern
	String regex;
	
	/**
	 * Creates a new RegexFilter with the given regex.
	 * 
	 * @param regex
	 */
	public RegexFilter(String regex) {
		pattern = Pattern.compile(regex);
		this.regex = regex;
	}
	
	/**
	 * Returns the regex used by this filter.
	 * 
	 * @return the regex that is used
	 */
	public String getRegex() {
		return regex;
	}
	
	/**
	 * Filters the message with a regex. If the message match the regex, it's logged.
	 * It uses the full formatted message (how it's going to look in the output).
	 */
	@Override
	public boolean filter(LogMessage message) {
		// Get the full formatted (or not) message:
		String formattedMessage = message.toString();
		Matcher matcher = pattern.matcher(formattedMessage);
		// Find if it match the regex or not:
		return matcher.find();
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof RegexFilter)) {
			return false;
		} else {
			RegexFilter other = (RegexFilter) object;
			return regex.equals(other.regex);
		}
	}
}
