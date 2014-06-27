package otro;

import grupo12.Logger.level.Level;
import grupo12.Logger.message.LogMessage;
import grupo12.Logger.output.filter.Filter;

public class FiltraNivelWarning implements Filter {

	@Override
	public boolean filter(LogMessage message) {
		return Level.WARNING.majorThan(message.getLevel());
	}

}
