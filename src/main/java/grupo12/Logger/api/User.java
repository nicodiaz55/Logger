package grupo12.Logger.api;

public class User {

	private String userName;
	private String mode;
	private String pattern;
	private String output;
	
	public User(){
		
	}
	public void setUserName(String newUserName){
		userName=newUserName;
		return;
	}
	public void setMode(String newMode){
		mode=newMode;
		return;
	}
	public void setPattern(String newPattern){
		pattern=newPattern;
		return;
	}
	public void setOutput(String newOutput){
		output=newOutput;
		return;
	}
	public String getUserName(){
		return userName;
	}
	public String getMode(){
		return mode;
	}
	public String getPattern(){
		return pattern;
	}
	public String getOutput(){
		return output;
	}
}
