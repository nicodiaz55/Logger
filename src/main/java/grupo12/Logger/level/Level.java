package grupo12.Logger.level;

public abstract class Level {
		
	protected String levelStr;
	protected int level;
	
	@Override
	public String toString() {
		return levelStr;
	}
	
	public boolean majorThan(Level otherLevel) {
		if (otherLevel != null)
			return level >= otherLevel.level;
		return false;
	}

	@Override
	public abstract boolean equals(Object anObject);
}
