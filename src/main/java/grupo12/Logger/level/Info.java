package grupo12.Logger.level;

/**
 * Inherits from Level. Concrete class which deals with Info level.
 * @author grupo12
 *
 */
public class Info extends Level {
	private static final int INFO = 3;
	
	/**
	 * Constructor
	 */
	public Info() {
		level = INFO;
		levelStr = "INFO";
	}

	/**
	 * Overrides "equals" method from java class Object.
	 * Adapted to compare Info levels.
	 */
	@Override
	public boolean equals(Object anObject) {
		return anObject instanceof Info;
	}
}
