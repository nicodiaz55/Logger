package grupo12.Logger.output;

public interface Writer {
	public void write(String message);
	public void init();
	public void end();
}
