package grupo12.Logger.level;

public class LevelFactory {

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
		// TODO: ver si el default estaria bien devolver Info (caso que escriben cualquier cosa en level)
		case "INFO":
		default:
			return new Info();
	}
	}
}
