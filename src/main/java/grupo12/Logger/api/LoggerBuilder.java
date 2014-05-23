package grupo12.Logger.api;

import java.util.ArrayList;

import grupo12.Logger.conf.Configuration;
import grupo12.Logger.format.Formatter;
import grupo12.Logger.level.Level;
import grupo12.Logger.level.LevelFactory;
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
		LevelFactory levelFactory = new LevelFactory();
		
		logger = new Logger();
		conf = new Configuration(configurationFile);
		
		ArrayList<String> confOutputs = conf.getOutputs();
		ArrayList<String> confLevels = conf.getLevels();
		ArrayList<String> confPatterns = conf.getPatterns();
		ArrayList<String> confSeparators = conf.getSeparators();
		
		ArrayList<Writer> writers = new ArrayList<Writer>();
		ArrayList<Level> levels = new ArrayList<Level>();
		
		for (String output : confOutputs) {
			writers.add(writerFactory.getWriter(output));
		}
		
		for (String level : confLevels) {
			levels.add(levelFactory.getLevel(level));
		}
		
		
		/* TODO: Falta validar que las listas tengan todas el mismo tamaño...
		* el usuario podría trollearnos con eso.
		*/ 
		int i = 0; 
		for (Writer writer : writers) {
			OutputManager manager = new OutputManager();
			manager.setOutput(writer);
			manager.setFormatter(new Formatter(confPatterns.get(i), confSeparators.get(i)));
			manager.setLevel(levels.get(i));
			logger.addOutput(manager);
			i++;
		}
		
	}
	
	public Logger getLogger() {
		return logger;
	}

}
