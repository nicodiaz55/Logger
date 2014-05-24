package grupo12.Logger.output;

import java.io.FileNotFoundException;

public interface Writer {
	public void write(String message);
	public void init() throws FileNotFoundException;
	public void end();
}
