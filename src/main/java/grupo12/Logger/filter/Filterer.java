package grupo12.Logger.filter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filterer {

	private String regexFilter;
	private static final String defaultFilter = ".*";
	
	public Filterer(){
		regexFilter=defaultFilter;
	}
	
	public Filterer(String regex){
		String offset=".*";
		regexFilter=offset+regex+offset;
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
	
	public String getRegexFilter(){
		return regexFilter;
	}
	public void setRegexFilter(String newRegexFilter){
		regexFilter=newRegexFilter;
	}
	
	
//	public static void main (String [] args){
//	
//		Filterer myFilterer = new Filterer("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
//		String message = "caca 120.0.10.4";		
//		System.out.println(message);
//		String newMessage = myFilterer.filter(message);
//		System.out.println(newMessage);
//		
//	}
}

