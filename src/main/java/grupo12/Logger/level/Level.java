package grupo12.Logger.level;

/**
 * Abstract class which inherits to concrete levels (Debug, Info, Warning, Error or Fatal)
 * @author grupo12
 *
 */
public abstract class Level {
		
	protected String levelStr;
	protected int level;
	
	/**
	 * Overrides "toString()" method from java class Object so it returns a levelStr.
	 */
	@Override
	public String toString() {
		return levelStr;
	}
	/**
	 * Checks if otherLevel is major than this level.
	 * @param otherLevel
	 * @return true or false
	 */
	public boolean majorThan(Level otherLevel) {
		if (otherLevel != null) {
			return level >= otherLevel.level;
		}
		return false;
	}

	/**
	 * Overrides "equals" method from java class Object
	 */
	@Override
	public abstract boolean equals(Object anObject);
}
