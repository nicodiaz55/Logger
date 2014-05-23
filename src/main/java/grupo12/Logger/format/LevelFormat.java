package grupo12.Logger.format;

import grupo12.Logger.message.LogMessage;

public class LevelFormat extends Format {

	public LevelFormat() {
		super("%p");
	}
	
	@Override
	public void format(LogMessage message) {
		String messageLevel = message.getLevel().toString();
		updateFormat(message, messageLevel);
	}

}
