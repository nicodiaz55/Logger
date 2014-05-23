package grupo12.Logger.level;

public class Error extends Level {
	private static final int ERROR = 1;
	
	public Error() {
		level = ERROR;
		levelStr = "ERROR";
	}
	
	@Override
	public boolean equals(Object anObject) {
		return anObject instanceof Error;
	}
}
