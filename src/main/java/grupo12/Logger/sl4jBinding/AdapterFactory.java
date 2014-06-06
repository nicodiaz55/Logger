package grupo12.Logger.sl4jBinding;

import grupo12.Logger.api.LoggerFactory;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

public class AdapterFactory implements ILoggerFactory {

	@Override
	public Logger getLogger(String name) {
		LoggerFactory factory = new LoggerFactory();
		grupo12.Logger.api.Logger logger = factory.getLogger(name);
		logger.init();
		return new Slf4jAdapter(logger);
	}

}
