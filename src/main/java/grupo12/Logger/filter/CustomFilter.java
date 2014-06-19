package grupo12.Logger.filter;

//import grupo12.Logger.level.Level;
import grupo12.Logger.message.LogMessage;

public class CustomFilter implements Filter{

	private String className;
	
	public CustomFilter(String className){
		this.className = className;
	}
	public String getClassName(){
		return className;
	}
	
		
	@Override
	public boolean filter(LogMessage message) {
		try {
			Class<?> filterClass = Class.forName(className);
			Filter filter = (Filter) filterClass.newInstance();
			return filter.filter(message);
		} catch (Exception e) {
			return false;
		}
	}


}
