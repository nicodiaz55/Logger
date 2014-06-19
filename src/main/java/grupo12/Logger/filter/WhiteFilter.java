package grupo12.Logger.filter;

import grupo12.Logger.message.LogMessage;

public class WhiteFilter implements Filter {

	@Override
	public boolean filter(LogMessage message) {
		if (message.getMessage().equals("WHITE")){
			return true;
		} else {
			return false;
		}

	}
	
}
