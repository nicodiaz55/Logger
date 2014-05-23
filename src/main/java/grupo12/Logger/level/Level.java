package grupo12.Logger.level;

public abstract class Level {
		
	protected String levelStr;
	protected int level;
	
	@Override
	public String toString() {
		return levelStr;
	}
	
	public boolean majorThan(Level otherLevel) {
		return level >= otherLevel.level;
	}

	@Override
	public abstract boolean equals(Object anObject);
}
