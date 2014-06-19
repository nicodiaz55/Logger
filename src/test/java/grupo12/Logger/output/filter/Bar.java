package grupo12.Logger.output.filter;

import grupo12.Logger.message.LogMessage;
import grupo12.Logger.output.filter.Filter;

public class Bar implements Filter {

	@Override
	public boolean filter(LogMessage message) {
		return true;
	}

}
