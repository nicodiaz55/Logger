package grupo12.Logger.conf;

import java.util.ArrayList;
import java.util.List;

public abstract class ConfigFileParser {
	

	protected List<Configuration> confList = new ArrayList<Configuration>();
	protected ConfigFileParser next;
	
	public abstract List<Configuration> getConfigurationsList();
	protected void callNext() {
		
		if (next!=null) confList=next.getConfigurationsList();
		confList = new ArrayList<Configuration>();
		
	}
	public void setNext(ConfigFileParser cfgFP){

		next = cfgFP;
	}

}
