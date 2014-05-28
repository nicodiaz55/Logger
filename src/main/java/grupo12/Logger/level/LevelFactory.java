package grupo12.Logger.level;

/**
 * It's sole responsibility is to build an abstract Level class
 * @author Grupo12
 *
 */
public class LevelFactory {

	/**
	 * Gets the level the caller asks for.
	 * @param level requested by caller (DEBUG, WARNING, ERROR, FATAL, INFO)
	 * @return new level instance (Debug, Warning, Error, Fatal, Info)
	 */
	public Level getLevel(String level) {
		switch (level) {
		case "DEBUG":
			return new Debug();
		case "WARNING":
			return new Warning();
		case "ERROR":
			return new Error();
		case "FATAL":
			return new Fatal();
		case "INFO":
		default:
			return new Info();
	}
	}
}
