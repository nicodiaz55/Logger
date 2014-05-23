package grupo12.Logger.format;

import java.text.SimpleDateFormat;
import java.util.Date;

import grupo12.Logger.message.LogMessage;

public class DateFormat extends Format {

	static final String dateFormatPattern = ".*(?<!%)%d\\{([^}]*)\\}.*";
	static final String pattern = "(?<!%)%d\\{([^}]*)\\}";
	
	public DateFormat() {
		super("%d\\{([^}]*)\\}");
	}
	
	@Override
	public void format(LogMessage message) {
		
		// TODO: Refactorizar esto...
		
		Date date = message.getTimestamp();
		
		String oldRepr = message.toString();
		String dateFormatString = oldRepr.replaceAll(dateFormatPattern,"$1");

		if (!dateFormatString.equals(oldRepr)){
			SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString);
			String newRepr = oldRepr.replaceAll(pattern, dateFormat.format(date));
			message.changeFormat(newRepr);
		}
	}

}
