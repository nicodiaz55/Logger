package grupo12.Logger.level;

public class Trace extends Level {
	private static final int TRACE = 5;
	
	/**
	 * Constructor
	 */
	public Trace() {
		level = TRACE;
		levelStr = "TRACE";
	}
	
	/**
	 * Overrides "equals" method from java class Object.
	 * Adapted to compare Trace levels.
	 */
	@Override
	public boolean equals(Object anObject) {
		return anObject instanceof Trace;
	}

}
