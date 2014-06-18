package grupo12.Logger.filter;

import grupo12.Logger.filter.IFilterer;

public class OrangeFilter implements IFilterer{

	@Override
	public String filter(String message) {
		if (message.contains("FATAL")){
			message="Rotten Orange";
		} else {
			message="Sweet Orange";
		}
		return message;
	}
	
	
}
