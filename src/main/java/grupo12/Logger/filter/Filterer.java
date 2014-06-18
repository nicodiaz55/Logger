package grupo12.Logger.filter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filterer {

	private String regexFilter;
	private String customFilter;
	private static final String defaultFilter = ".*";
	
	public Filterer(){
		regexFilter=defaultFilter;
		customFilter="";
	}
	
	public Filterer(String regex){
		String offset=".*";
		regexFilter=offset+regex+offset;
		customFilter="";
	}
	
	public String filter(String message){
		Pattern p = Pattern.compile(regexFilter);
		
		StringBuffer myStringBuffer = new StringBuffer();
		Matcher m = p.matcher(message);
		while (m.find()) {
		  
		    m.appendReplacement(myStringBuffer,m.group());
		  }
		
		
		return myStringBuffer.toString();
	}
	
	public String customFilter(String message){
		try {
			Class<?> filterClass = Class.forName(customFilter);
			IFilterer filter = (IFilterer) filterClass.newInstance();
			return filter.filter(message);
		} catch (Exception e) {
			return message;
		}
	}
	
	public void setCustomFilter(String className){
		this.customFilter = className;
	}
	public String getCustomFilter(){
		return customFilter;
	}
	
	public String getRegexFilter(){
		return regexFilter;
	}
	public void setRegexFilter(String newRegexFilter){
		regexFilter=newRegexFilter;
	}
	
	

}

