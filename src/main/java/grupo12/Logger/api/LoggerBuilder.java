package grupo12.Logger.api;

import java.util.ArrayList;

import grupo12.Logger.conf.Configuration;
import grupo12.Logger.format.Formatter;
import grupo12.Logger.level.Level;
import grupo12.Logger.level.LevelFactory;
import grupo12.Logger.output.Output;
import grupo12.Logger.output.Writer;
import grupo12.Logger.output.WriterFactory;

/**
 * The LoggerBuilder responsibility consists on building the logger.
 * It can be using a configurationFile or by default.
 * 
 * @author Grupo 12
 */
public class LoggerBuilder {

	private Logger logger;
	private Configuration conf;
	
	/**
	 * Builds and configures a Logger by the default configuration.
	 */
	public LoggerBuilder() {
		this("default.cfg");
	}
	
	/**
	 * Builds and configures a Logger from a configuration file.
	 *
	 * @param configurationFile the configuration file.
	 */
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
		
		int i = 0; 
		for (Writer writer : writers) {
			Level level = levels.get(i);
			Formatter formatter = new Formatter(confPatterns.get(i), confSeparators.get(i));
			Output manager = new Output(level, writer, formatter);
			logger.addOutput(manager);
			i++;
		}
		
	}
	
	/**
	 * Returns the Logger
	 * 
	 * @return the logger configurated and ready to use.
	 */
	public Logger getLogger() {
		return logger;
	}

}
