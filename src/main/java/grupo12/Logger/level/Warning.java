package grupo12.Logger.level;

public class Warning extends Level {
	private static final int WARNING = 2;
	
	public Warning() {
		level = WARNING;
		levelStr = "WARNING";
	}
	
	@Override
	public boolean equals(Object anObject) {
		return anObject instanceof Warning;
	}
}
