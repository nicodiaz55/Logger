package grupo12.Logger.api;

import java.util.ArrayList;

import grupo12.Logger.conf.Configuration;
import grupo12.Logger.format.Formatter;
import grupo12.Logger.output.ConsoleWriter;
import grupo12.Logger.output.OutputManager;
import grupo12.Logger.output.RecordWriter;
import grupo12.Logger.output.Writer;

public class LoggerBuilder {

	private Logger logger;
	private Configuration conf;
	
	public LoggerBuilder() {
		this("default.cfg");
	}
	
	public LoggerBuilder(String configurationFile) {
				
		logger = new Logger();
		conf = new Configuration(configurationFile);
		
		ArrayList<String> outputs = conf.getOutputs();
		String level = conf.getLevel();
		String pattern = conf.getPattern();
		String separator = conf.getSeparator();
		
		ArrayList<Writer> writers = new ArrayList<Writer>();
		
		for (String output : outputs) {
			// TODO: hacer extensible esto:
			if (output.equals("console"))
				writers.add(new ConsoleWriter());
			else
				writers.add(new RecordWriter(output));
		}
		
		for (Writer writer : writers) {
			OutputManager manager = new OutputManager();
			manager.setOutput(writer);
			manager.setFormatter(new Formatter(pattern, separator));
			manager.setLevel(level);
			logger.addOutput(manager);
		}
		
	}
	
	public Logger getLogger() {
		return logger;
	}

}
