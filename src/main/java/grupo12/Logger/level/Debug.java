package grupo12.Logger.level;

/**
 * Inherits from Level. Concrete class which deals with Debug level.
 * @author grupo12
 *
 */
public class Debug extends Level {
	
	private static final int DEBUG = 4;
	
	/**
	 * Constructor.
	 */
	public Debug() {
		level = DEBUG;
		levelStr = "DEBUG";
	}
	/**
	 * Overrides "equals" method from java class Object.
	 * Adapted to compare Debug levels.
	 */
	@Override
	public boolean equals(Object anObject) {
		return anObject instanceof Debug;
	}
}
