package grupo12.Logger.message;

public class Level {

	public static final int OFF = 5;
	public static final int DEBUG = 4;
	public static final int INFO = 3;
	public static final int WARNING = 2;
	public static final int ERROR = 1;
	public static final int FATAL = 0;
	
	private String level;
	private int leveln;
	
	public Level(String level) {
		// TODO Esto es feo...
		switch(level) {
			case "OFF":
				this.level = "OFF";
				this.leveln = OFF;
				break;
			case "DEBUG":
				this.level = "DEBUG";
				this.leveln = DEBUG;
				break;
			case "WARNING":
				this.level = "WARNING";
				this.leveln = WARNING;
				break;
			case "ERROR":
				this.level = "ERROR";
				this.leveln = ERROR;
				break;
			case "FATAL":
				this.level = "FATAL";
				this.leveln = FATAL;
				break;
			case "INFO":
			default:
				this.level = "INFO";
				this.leveln = INFO;
				break;
		}
	}

	public String toString() {
		return level;
	}
	
	public boolean majorThan(Level otherLevel) {
		return leveln >= otherLevel.leveln;
	}

}
