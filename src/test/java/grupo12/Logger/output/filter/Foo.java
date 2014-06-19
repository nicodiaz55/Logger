package grupo12.Logger.output.filter;

import grupo12.Logger.message.LogMessage;
import grupo12.Logger.output.filter.Filter;

public class Foo implements Filter {

	@Override
	public boolean equals(Object o) {
		return o instanceof Foo;
	}
	
	@Override
	public boolean filter(LogMessage message) {
		return false;
	}

}
