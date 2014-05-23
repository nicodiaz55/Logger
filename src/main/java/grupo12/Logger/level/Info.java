package grupo12.Logger.level;

public class Info extends Level {
	private static final int INFO = 3;
	
	public Info() {
		level = INFO;
		levelStr = "INFO";
	}

	@Override
	public boolean equals(Object anObject) {
		return anObject instanceof Info;
	}
}
