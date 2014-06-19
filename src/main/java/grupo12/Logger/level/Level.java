package grupo12.Logger.level;


public class Level {
	
	public final static Level TRACE = new Level("TRACE", 0);
	public final static Level DEBUG = new Level("DEBUG", 1);
	public final static Level INFO = new Level("INFO", 2);
	public final static Level WARNING = new Level("WARNING", 3);
	public final static Level ERROR = new Level("ERROR", 4);
	public final static Level FATAL = new Level("FATAL", 5);
	
	private String levelStr;
	private int level;
	
	public Level(String levelName, int priority) {
		levelStr = levelName;
		level = priority;
	}
	
	/**
	 * Overrides "toString()" method from java class Object so it returns a levelStr.
	 */
	@Override
	public String toString() {
		return levelStr;
	}
	/**
	 * Checks if otherLevel is major than this level.
	 * 
	 * @param otherLevel
	 * @return true or false
	 */
	public boolean majorThan(Level otherLevel) {
		if (otherLevel != null) {
			return level <= otherLevel.level;
		}
		return false;
	}

	/**
	 * Overrides "equals" method from java class Object
	 */
	@Override
	public boolean equals(Object anObject) {
		if (!(anObject instanceof Level)) {
			return false;
		}
		
		Level other = (Level) anObject;
		return (level == other.level && levelStr.equals(other.levelStr));
	}
	@Override
	public int hashCode() {
		int h=111;
		int levelStrLen = levelStr.length();
		for (int i = 0; i < levelStrLen; i++) {
		    h = 31*h + levelStr.charAt(i);
		  }
		return level * 37 + h;
	}
}
