package grupo12.Logger.level;

import java.util.Hashtable;
import java.util.List;

/**
 * Class that creates specific {@link grupo12.Logger.level.Level Level}s according to a String.
 * 
 * @author Grupo 12
 */
public class LevelFactory {

	private int priority;
	private Hashtable<String, Level> levelTable;
	
	/**
	 * Creates a factory of levels. The user pass a list of names for each level
	 * and its order determines its priority (decreasing priority).
	 * 
	 * @param levels list, ordered by decreasing priority
	 */
	public LevelFactory(List<String> levels) {
		priority = 0;
		levelTable = new Hashtable<String, Level>();
		createLevels(levels);
	}
	
	/**
	 * Creates the Levels, assigning decreasing priority to them.
	 * 
	 * @param levels list, ordered by priority
	 */
	private void createLevels(List<String> levels) {
		for (String level : levels) {
			levelTable.put(level, new Level(level, priority));
			priority++;
		}
	}
	
	/**
	 * Returns the {@link grupo12.Logger.level.Level Level} the caller asks for.
	 * 
	 * @param level name
	 * @return the level corresponding to that name
	 */
	public Level getLevel(String level) {
		return levelTable.get(level);
	}
}
