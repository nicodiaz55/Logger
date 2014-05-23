package grupo12.Logger.level;

public class Fatal extends Level {
	
	private static final int FATAL = 0;
	
	public Fatal() {
		level = FATAL;
		levelStr = "FATAL";
	}
	
	@Override
	public boolean equals(Object anObject) {
		return anObject instanceof Fatal;
	}
}
