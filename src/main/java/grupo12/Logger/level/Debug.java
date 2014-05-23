package grupo12.Logger.level;

public class Debug extends Level {
	
	private static final int DEBUG = 4;
	
	public Debug() {
		level = DEBUG;
		levelStr = "DEBUG";
	}
	
	@Override
	public boolean equals(Object anObject) {
		return anObject instanceof Debug;
	}
}
