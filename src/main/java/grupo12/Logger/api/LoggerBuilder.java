package grupo12.Logger.api;

import java.util.ArrayList;
import java.util.List;

import grupo12.Logger.conf.Configuration;
import grupo12.Logger.format.Formatter;
import grupo12.Logger.format.FormatterFactory;
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

	/**
	 * Constructor.
	 */
	public LoggerBuilder() { }

	/**
	 * Builds and configures a {@link grupo12.Logger.api.Logger Logger}.
	 */
	public Logger build(Configuration conf) {
		// Create needed Factories:
		WriterFactory writerFactory = new WriterFactory();
		LevelFactory levelFactory = new LevelFactory();
		FormatterFactory formatterFactory = new FormatterFactory();

		// Get all configuration attributes:
		String confName = conf.getName();
		String confLevel = conf.getLevel();
		List<String> confOutputs = conf.getOutputs();
		List<String> confFormatters = conf.getFormatters();
		List<String> confSeparators = conf.getSeparators();

		// Create a logger:
		Logger logger = new Logger(confName);
		
		// Set it's level:
		Level level = levelFactory.getLevel(confLevel);
		logger.setLevel(level);
		
		// Create writers:
		List<Writer> writers = new ArrayList<Writer>();
		for (String output : confOutputs) {
			writers.add(writerFactory.getWriter(output));
		}

		// Create the outputs and add them to the logger:
		int i = 0;
		for (Writer writer : writers) {
			Formatter formatter = formatterFactory.getFormatter(confFormatters.get(i), confSeparators.get(i));
			Output manager = new Output(level, writer, formatter);
			logger.addOutput(manager);
			i++;
		}
		
		return logger;
	}

}
