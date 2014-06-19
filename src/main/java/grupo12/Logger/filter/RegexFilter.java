package grupo12.Logger.filter;

//import grupo12.Logger.level.Level;
import grupo12.Logger.message.LogMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexFilter implements Filter{

	private String regexFilter;

	
	
	public RegexFilter(String regex){
		String offset=".*";
		regexFilter=offset+regex+offset;
	}
	
	@Override
	public boolean filter(LogMessage message){
		
		Pattern p = Pattern.compile(regexFilter);
	    Matcher m = p.matcher(message.toString());
		return m.find();
		
	}

}
