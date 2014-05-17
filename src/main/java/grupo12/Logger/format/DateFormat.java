package grupo12.Logger.format;

import java.text.SimpleDateFormat;
import java.util.Date;

import grupo12.Logger.message.LogMessage;

public class DateFormat implements Format {

	static final String dateFormatPattern = ".*(?<!%)%d\\{([^}]*)\\}.*";
	static final String pattern = "(?<!%)%d\\{([^}]*)\\}";
	
	@Override
	public void format(LogMessage message) {
		String oldRepr = message.toString() ;
		Date date = message.getTimestamp();
		String dateFormatString = oldRepr.replaceAll(dateFormatPattern,"$1");

		if (!dateFormatString.equals(oldRepr)){
			SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString);
			String newRepr = oldRepr.replaceAll(pattern, dateFormat.format(date));
			message.changeFormat(newRepr);
		}
	}

}
