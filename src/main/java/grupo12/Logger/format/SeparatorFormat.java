package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

public class SeparatorFormat extends Format {
	
	private String separator;
	
	public SeparatorFormat(String separator) {
		super("%n");
		this.separator = separator;
	}

	@Override
	public void format(LogMessage message) {
		updateFormat(message, separator);
	}

}
