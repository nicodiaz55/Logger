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
		case "INFO":
		default:
			return new Info();
	}
	}
}
