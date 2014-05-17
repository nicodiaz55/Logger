package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

public class SeparatorFormat implements Format {

	static final String pattern = "(?<!%)%n";
	private String separator;
	
	public SeparatorFormat(String separator) {
		this.separator = separator;
	}

	@Override
	public void format(LogMessage message) {
		String oldRepr = message.toString();
		String newRepr = oldRepr.replaceAll(pattern,separator);
		message.changeFormat(newRepr);
	}

}
