package grupo12.Logger.level;

import java.util.Hashtable;
import java.util.List;

/**
 * It's sole responsibility is to build an abstract Level class
 * @author Grupo12
 *
 */
public class LevelFactory {

	private int priority;
	private Hashtable<String, Level> levelTable;
	
	public LevelFactory(List<String> levels) {
		priority = 0;
		levelTable = new Hashtable<String, Level>();
		createLevels(levels);
	}
	
	private void createLevels(List<String> levels) {
		for (String level : levels) {
			levelTable.put(level, new Level(level, priority));
			priority++;
		}
	}
	
	/**
	 * Gets the level the caller asks for.
	 * @param level requested by caller (DEBUG, WARNING, ERROR, FATAL, INFO)
	 * @return new level instance (Debug, Warning, Error, Fatal, Info)
	 */
	public Level getLevel(String level) {
		return levelTable.get(level);
	}
}
