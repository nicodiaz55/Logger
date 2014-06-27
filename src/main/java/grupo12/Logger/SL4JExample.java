package grupo12.Logger;

import grupo12.Logger.sl4jBinding.StaticLoggerBinder;

import org.slf4j.ILoggerFactory;

public class SL4JExample {

	public static void main(String[] args) {
		
		StaticLoggerBinder slb = StaticLoggerBinder.getSingleton();
		
		org.slf4j.Logger logger = null;
		
		ILoggerFactory factory = slb.getLoggerFactory();
		
		//((AdapterFactory) factory).setConfiguration("myConf.xml");
		//logger = factory.getLogger("LoggerPASO");
		
		logger = factory.getLogger("Logger");
		
		logger.info("foo");
		logger.error("bar", new Exception("I don't know what happened here"));
		logger.info("foo2");
		logger.debug("no se loggea PASO", new Exception());
		logger.info("foo3 PASO");
	}

}
