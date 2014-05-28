package grupo12.Logger.level;

/**
 * Inherits from Level. Concrete class which deals with Warning level.
 * @author grupo12
 *
 */
public class Warning extends Level {
	private static final int WARNING = 2;
	/**
	 * Constructor
	 */
	public Warning() {
		level = WARNING;
		levelStr = "WARNING";
	}
	
	/**
	 * Overrides "equals" method from java class Object.
	 * Adapted to compare Warning levels.
	 */
	@Override
	public boolean equals(Object anObject) {
		return anObject instanceof Warning;
	}
}
