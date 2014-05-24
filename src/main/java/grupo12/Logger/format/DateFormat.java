package grupo12.Logger.format;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import grupo12.Logger.message.LogMessage;

public class DateFormat extends Format {

	static final String dateFormatPattern = ".*(?<!%)%d\\{([^}]*)\\}.*";
	static final Locale locale = new Locale("en","US");
	
	public DateFormat() {
		super("%d\\{([^}]*)\\}");
	}
	
	private String parseDateFormatString(LogMessage message){
		
		String oldRepr = message.toString();
		String dateFormatString = oldRepr.replaceAll(dateFormatPattern,"$1");
		
		if (dateFormatString.equals(oldRepr)) return "";
		
		return dateFormatString;
	}
	
	@Override
	public void format(LogMessage message){
		
		Date date = message.getTimestamp();
		
		String dateFormatString = parseDateFormatString(message);

		if (!dateFormatString.isEmpty()){
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString,locale);
				updateFormat(message, dateFormat.format(date));
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid Date format");
			}	
		}
	}

}
