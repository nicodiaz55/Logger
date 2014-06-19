package grupo12.Logger.filter;

import grupo12.Logger.message.*;

public interface Filter {

	public boolean filter(LogMessage message);
}
