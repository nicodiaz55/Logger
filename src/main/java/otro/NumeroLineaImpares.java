package otro;

import grupo12.Logger.message.LogMessage;
import grupo12.Logger.output.filter.Filter;

public class NumeroLineaImpares implements Filter {

	@Override
	public boolean filter(LogMessage message) {
		return ((message.getLineNumber() % 2) != 0);
	}
}
