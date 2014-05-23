package grupo12.Logger.level;

public abstract class Level {
		
	protected String levelStr;
	protected int level;
	
	public String toString() {
		return levelStr;
	}
	
	public boolean majorThan(Level otherLevel) {
		return level >= otherLevel.level;
	}

}
