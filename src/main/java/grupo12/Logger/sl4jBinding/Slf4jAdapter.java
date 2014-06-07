package grupo12.Logger.sl4jBinding;

import grupo12.Logger.level.Level;

import org.slf4j.Marker;

public class Slf4jAdapter implements org.slf4j.Logger {

	grupo12.Logger.api.Logger logger;
	
	public Slf4jAdapter(grupo12.Logger.api.Logger logger) {
		this.logger = logger;
	}
	
	@Override
	public void debug(String message) {
		logger.debug(message);
	}

	@Override
	public void debug(String message, Object arg1) {
		logger.debug(message);
	}

	@Override
	public void debug(String message, Object... arg1) {
		logger.debug(message);
	}

	@Override
	public void debug(String message, Throwable exception) {
		logger.debug(message, exception);
	}

	@Override
	public void debug(Marker arg0, String message) {
		logger.debug(message);
	}

	@Override
	public void debug(String message, Object arg1, Object arg2) {
		logger.debug(message);		
	}

	@Override
	public void debug(Marker arg0, String message, Object arg2) {
		logger.debug(message);
	}

	@Override
	public void debug(Marker arg0, String message, Object... arg2) {
		logger.debug(message);
	}

	@Override
	public void debug(Marker arg0, String message, Throwable exception) {
		logger.debug(message,exception);
	}

	@Override
	public void debug(Marker arg0, String message, Object arg2, Object arg3) {
		logger.debug(message);
	}

	@Override
	public void error(String message) {
		logger.error(message);
	}

	@Override
	public void error(String message, Object arg1) {
		logger.error(message);
	}

	@Override
	public void error(String message, Object... arg1) {
		logger.error(message);
	}

	@Override
	public void error(String message, Throwable exception) {
		logger.error(message, exception);
	}

	@Override
	public void error(Marker arg0, String message) {
		logger.error(message);
	}

	@Override
	public void error(String message, Object arg1, Object arg2) {
		logger.error(message);
	}

	@Override
	public void error(Marker arg0, String message, Object arg2) {
		logger.error(message);
	}

	@Override
	public void error(Marker arg0, String message, Object... arg2) {
		logger.error(message);
	}

	@Override
	public void error(Marker arg0, String message, Throwable exception) {
		logger.error(message, exception);
	}

	@Override
	public void error(Marker arg0, String message, Object arg2, Object arg3) {
		logger.error(message);
	}

	@Override
	public String getName() {
		return logger.getName();
	}

	@Override
	public void info(String message) {
		logger.info(message);
	}

	@Override
	public void info(String message, Object arg1) {
		logger.info(message);
	}

	@Override
	public void info(String message, Object... arg1) {
		logger.info(message);
	}

	@Override
	public void info(String message, Throwable exception) {
		logger.info(message, exception);
	}

	@Override
	public void info(Marker arg0, String message) {
		logger.info(message);
	}

	@Override
	public void info(String message, Object arg1, Object arg2) {
		logger.info(message);
	}

	@Override
	public void info(Marker arg0, String message, Object arg2) {
		logger.info(message);
	}

	@Override
	public void info(Marker arg0, String message, Object... arg2) {
		logger.info(message);
	}

	@Override
	public void info(Marker arg0, String message, Throwable exception) {
		logger.info(message, exception);
	}

	@Override
	public void info(Marker arg0, String message, Object arg2, Object arg3) {
		logger.info(message);
	}

	@Override
	public boolean isDebugEnabled() {
		return logger.getLevel().majorThan(Level.DEBUG);
	}

	@Override
	public boolean isDebugEnabled(Marker arg0) {
		return logger.getLevel().majorThan(Level.DEBUG);
	}

	@Override
	public boolean isErrorEnabled() {
		return logger.getLevel().majorThan(Level.ERROR);
	}

	@Override
	public boolean isErrorEnabled(Marker arg0) {
		return logger.getLevel().majorThan(Level.ERROR);
	}

	@Override
	public boolean isInfoEnabled() {
		return logger.getLevel().majorThan(Level.INFO);
	}

	@Override
	public boolean isInfoEnabled(Marker arg0) {
		return logger.getLevel().majorThan(Level.INFO);
	}

	@Override
	public boolean isTraceEnabled() {
		return logger.getLevel().majorThan(Level.TRACE);
	}

	@Override
	public boolean isTraceEnabled(Marker arg0) {
		return logger.getLevel().majorThan(Level.TRACE);
	}

	@Override
	public boolean isWarnEnabled() {
		return logger.getLevel().majorThan(Level.WARNING);
	}

	@Override
	public boolean isWarnEnabled(Marker arg0) {
		return logger.getLevel().majorThan(Level.WARNING);
	}

	@Override
	public void trace(String message) {
		logger.trace(message);
	}

	@Override
	public void trace(String message, Object arg1) {
		logger.trace(message);
	}

	@Override
	public void trace(String message, Object... arg1) {
		logger.trace(message);
	}

	@Override
	public void trace(String message, Throwable exception) {
		logger.trace(message, exception);
	}

	@Override
	public void trace(Marker arg0, String message) {
		logger.trace(message);
	}

	@Override
	public void trace(String message, Object arg1, Object arg2) {
		logger.trace(message);
	}

	@Override
	public void trace(Marker arg0, String message, Object arg2) {
		logger.trace(message);
	}

	@Override
	public void trace(Marker arg0, String message, Object... arg2) {
		logger.trace(message);
	}

	@Override
	public void trace(Marker arg0, String message, Throwable exception) {
		logger.trace(message, exception);
	}

	@Override
	public void trace(Marker arg0, String message, Object arg2, Object arg3) {
		logger.trace(message);
	}

	@Override
	public void warn(String message) {
		logger.warn(message);
	}

	@Override
	public void warn(String message, Object arg1) {
		logger.warn(message);
	}

	@Override
	public void warn(String message, Object... arg1) {
		logger.warn(message);
	}

	@Override
	public void warn(String message, Throwable exception) {
		logger.warn(message, exception);
	}

	@Override
	public void warn(Marker arg0, String message) {
		logger.warn(message);
	}

	@Override
	public void warn(String message, Object arg1, Object arg2) {
		logger.warn(message);
	}

	@Override
	public void warn(Marker arg0, String message, Object arg2) {
		logger.warn(message);
	}

	@Override
	public void warn(Marker arg0, String message, Object... arg2) {
		logger.warn(message);
	}

	@Override
	public void warn(Marker arg0, String message, Throwable exception) {
		logger.warn(message, exception);
	}

	@Override
	public void warn(Marker arg0, String message, Object arg2, Object arg3) {
		logger.warn(message);
	}

}
