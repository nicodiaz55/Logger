package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

public class LiteralFormat extends Format {
	
	public LiteralFormat() {
		super("");
		pattern = "%%";
	}
	
	@Override
	public void format(LogMessage message) {
		updateFormat(message, "%");
	}

}
