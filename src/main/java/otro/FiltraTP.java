package otro;

import grupo12.Logger.level.Level;
import grupo12.Logger.message.LogMessage;
import grupo12.Logger.output.filter.Filter;
import grupo12.Logger.output.filter.RegexFilter;

public class FiltraTP implements Filter {

	@Override
	public boolean filter(LogMessage message) {
		Filter regex = new RegexFilter(".*tp.*");
		return regex.filter(message) && message.getLevel().equals(Level.DEBUG);
	}

}
