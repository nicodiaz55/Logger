package grupo12.Logger.level;

/**
 * Class that represents a level. Used by the {@link LogMessage} and {@link grupo12.Logger.api.Logger Logger} classes.
 * 
 * @author Grupo 12
 */
public class Level {
	
	// Default levels. Accesible to the user.
	public final static Level TRACE = new Level("TRACE", 0);
	public final static Level DEBUG = new Level("DEBUG", 1);
	public final static Level INFO = new Level("INFO", 2);
	public final static Level WARNING = new Level("WARNING", 3);
	public final static Level ERROR = new Level("ERROR", 4);
	public final static Level FATAL = new Level("FATAL", 5);
	
	private String levelStr;
	private int level;
	
	/**
	 * Creates a level with a name and a priority.
	 * 
	 * @param levelName
	 * @param priority of the level
	 */
	public Level(String levelName, int priority) {
		levelStr = levelName;
		level = priority;
	}
	
	/**
	 * Returns the name of the Level
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
