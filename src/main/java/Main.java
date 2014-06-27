

import grupo12.Logger.sl4jBinding.StaticLoggerBinder;
import org.slf4j.Logger;

public class Main {
	
	public static void main(String[] args) {
		
		StaticLoggerBinder slb = StaticLoggerBinder.getSingleton();
		
		Logger logger1 = slb.getLoggerFactory().getLogger("logger1");
		Logger logger2 = slb.getLoggerFactory().getLogger("logger2");
		Logger logger3 = slb.getLoggerFactory().getLogger("logger3");
		
		logger1.info("Hello World");
		logger1.info("Hola Mundo");
		logger1.info("Hallo Welt");
		
		logger2.info("tp no deberia loguearse");
		logger2.debug("tp deberia loguearse");
		
		logger3.trace("no deberia loguearse..");
		logger3.warn("esto deberia loggearse con excepcion", new NullPointerException()); // warning
		logger3.error("esto deberia loggearse tambien.."); // fail
		
	}
}
