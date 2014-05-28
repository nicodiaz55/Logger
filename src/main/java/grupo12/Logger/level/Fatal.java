package grupo12.Logger.level;

/**
 * Inherits from Level. Concrete class which deals with Fatal level.
 * @author grupo12
 *
 */
public class Fatal extends Level {
	
	private static final int FATAL = 0;
	
	/**
	 * Constructor
	 */
	public Fatal() {
		level = FATAL;
		levelStr = "FATAL";
	}
	
	/**
	 * Overrides "equals" method from java class Object.
	 * Adapted to compare Fatal levels.
	 */
	@Override
	public boolean equals(Object anObject) {
		return anObject instanceof Fatal;
	}
}
