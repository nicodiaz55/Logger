package grupo12.Logger.conf.parser;

import grupo12.Logger.conf.Configuration;

import java.util.List;

public interface Parser {

	public boolean init();

	public void loadConfigurations(List<Configuration> configurations);

	public void setFile(String file);
}
