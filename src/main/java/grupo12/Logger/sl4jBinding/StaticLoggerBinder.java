package grupo12.Logger.sl4jBinding;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

public class StaticLoggerBinder implements LoggerFactoryBinder {

	/**
	 * The unique instance of this class.
	 * 
	 */
	private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();

	/**
	 * Return the singleton of this class.
	 * 
	 * @return the StaticLoggerBinder singleton
	 */
	public static final StaticLoggerBinder getSingleton() {
		return SINGLETON;
	}

	/**
	 * Declare the version of the SLF4J API this implementation is compiled
	 * against. The value of this field is usually modified with each release.
	 */
	// to avoid constant folding by the compiler, this field must *not* be final
	public static String REQUESTED_API_VERSION = "1.7.7"; // !final

	private static final String loggerFactoryClassStr = AdapterFactory.class.getName();

	/**
	 * The ILoggerFactory instance returned by the {@link #getLoggerFactory}
	 * method should always be the same object
	 */
	private final ILoggerFactory loggerAdapterFactory;

	private StaticLoggerBinder() {
		loggerAdapterFactory = new AdapterFactory();

	}

	public ILoggerFactory getLoggerFactory() {
		return loggerAdapterFactory;
	}

	public String getLoggerFactoryClassStr() {
		return loggerFactoryClassStr;
	}
}
