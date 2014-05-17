package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

public class LiteralFormat implements Format {

	static final String pattern = "%%";
	
	@Override
	public void format(LogMessage message) {
		String oldRepr = message.toString();
		String newRepr = oldRepr.replaceAll(pattern, "%"); 
		message.changeFormat(newRepr);
	}

}
