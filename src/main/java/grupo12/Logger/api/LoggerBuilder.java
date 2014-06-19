package grupo12.Logger.api;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import grupo12.Logger.conf.Configuration;
import grupo12.Logger.format.Formatter;
import grupo12.Logger.format.FormatterFactory;
import grupo12.Logger.level.Level;
import grupo12.Logger.level.LevelFactory;
import grupo12.Logger.output.Output;
import grupo12.Logger.output.filter.Filter;
import grupo12.Logger.output.filter.FilterFactory;
import grupo12.Logger.output.writer.Writer;
import grupo12.Logger.output.writer.WriterFactory;

/**
 * Builds a {@link grupo12.Logger.api.Logger Logger} with the especified {@link grupo12.Logger.conf.Configuration Configuration}.
 * 
 * @author Grupo 12
 */
public class LoggerBuilder {

	/**
	 * Builds and configures a {@link grupo12.Logger.api.Logger Logger}.
	 * 
	 * @param configuration of the Logger.
	 */
	public Logger build(Configuration configuration) {
		// Create needed Factories:
		WriterFactory writerFactory = new WriterFactory();
		LevelFactory levelFactory = new LevelFactory(configuration.getAvailableLevels());
		FormatterFactory formatterFactory = new FormatterFactory();
		FilterFactory filterFactory = new FilterFactory();

		// Get all configuration attributes:
		String confName = configuration.getName();
		String confLevel = configuration.getLevel();
		String confFilter = configuration.getFilter();
		List<String> confOutputs = configuration.getOutputs();
		Hashtable<String,List<String>> customOutputs = configuration.getCustomOutputs();
		List<String> confFormatters = configuration.getFormatters();
		List<String> confSeparators = configuration.getSeparators();

		// Create a logger:
		Logger logger = new Logger(confName);
		
		// Set its level:
		Level level = levelFactory.getLevel(confLevel);
		logger.setLevel(level);
			
		// Create writers:
		List<Writer> writers = new ArrayList<Writer>();
		for (String output : confOutputs) {
			writers.add(writerFactory.getWriter(output));
		}
		
		Iterator<Map.Entry<String, List<String>>> it = customOutputs.entrySet().iterator();
		while (it.hasNext()){
			Map.Entry<String, List<String>> par = it.next();
			writers.add(writerFactory.getWriter(par.getKey(),par.getValue()));
			
		}

		// Create the outputs and add them to the logger:
		int i = 0;
		for (Writer writer : writers) {
			Formatter formatter = formatterFactory.getFormatter(confFormatters.get(i), confSeparators.get(i));
			Output manager = new Output();
			manager.setFormatter(formatter);
			manager.setWriter(writer);
			logger.addOutput(manager);
			i++;
		}
		
		// Set its filter:
		Filter filter = filterFactory.getFilter(confFilter);
		logger.setFilter(filter);
		
		return logger;
	}

}
