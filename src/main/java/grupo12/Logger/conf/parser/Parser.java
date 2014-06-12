package grupo12.Logger.conf.parser;

import grupo12.Logger.conf.Configuration;

import java.util.List;

public interface Parser {

	public boolean init();

	public boolean canParse();
	
	public List<Configuration> loadConfigurations();

	public void setFile(String file);
}
