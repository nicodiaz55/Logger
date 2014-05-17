package grupo12.Logger.api;

import java.util.ArrayList;

import grupo12.Logger.conf.Configuration;
import grupo12.Logger.format.Formatter;
import grupo12.Logger.output.OutputManager;
import grupo12.Logger.output.Writer;
import grupo12.Logger.output.WriterFactory;

public class LoggerBuilder {

	private Logger logger;
	private Configuration conf;
	
	public LoggerBuilder() {
		this("default.cfg");
	}
	
	public LoggerBuilder(String configurationFile) {
		WriterFactory writerFactory = new WriterFactory();
		logger = new Logger();
		conf = new Configuration(configurationFile);
		
		ArrayList<String> outputs = conf.getOutputs();
		String level = conf.getLevel();
		String pattern = conf.getPattern();
		String separator = conf.getSeparator();
		
		ArrayList<Writer> writers = new ArrayList<Writer>();
		
		for (String output : outputs) {
			writers.add(writerFactory.getWriter(output));
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
