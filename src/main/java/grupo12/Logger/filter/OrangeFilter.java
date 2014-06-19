package grupo12.Logger.filter;

import grupo12.Logger.message.LogMessage;

public class OrangeFilter implements Filter{

	@Override
	public boolean filter(LogMessage message) {
		if (message.toString().contains("FATAL")){
			return false;
		} else {
			return true;
		}

	}
	
}
