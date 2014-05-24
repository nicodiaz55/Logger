package grupo12.Logger.format;

import grupo12.Logger.format.Format;
import java.util.ArrayList;

import grupo12.Logger.message.LogMessage;

public class Formatter {

	private ArrayList<Format> formatList;
	private String format;
	
	public Formatter(String format, String separator) {
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
	}
	
	public String format(LogMessage message){
		message.changeFormat(format);
		for (Format formatter : formatList)
			formatter.format(message);
		return message.toString();
	}

}
