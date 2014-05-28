package grupo12.Logger.level;

/**
 * Inherits from Level. Concrete class which deals with Error level.
 * @author grupo12
 *
 */
public class Error extends Level {
	private static final int ERROR = 1;
	
	/**
	 * Constructor
	 */
	public Error() {
		level = ERROR;
		levelStr = "ERROR";
	}
	/**
	 * Overrides "equals" method from java class Object.
	 * Adapted to compare Error levels.
	 */
	@Override
	public boolean equals(Object anObject) {
		return anObject instanceof Error;
	}
}
