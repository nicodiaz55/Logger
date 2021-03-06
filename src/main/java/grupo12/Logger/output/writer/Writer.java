package grupo12.Logger.output.writer;

/**
 * A Writer interface.
 * All writers need to know how to write, how it's initialized and how it's ended.
 * 
 * @author Grupo 12
 */
public interface Writer {
	
	/**
	 * Writes a message to the output.
	 * 
	 * @param message to write.
	 */
	public void write(String message);
	
	/**
	 * Inits the writer.
	 */
	public void init() throws NotInitializedException;
	
	/**
	 * Ends the writer.
	 */
	public void end();
	
	/**
	 * Returns if it can write.
	 */
	public boolean canWrite();
}
