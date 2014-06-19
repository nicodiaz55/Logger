package grupo12.Logger.output.writer;

/**
 * Exception thrown when a {@link Writer} can't be initialized.
 * This could happen for different reasons, like a file could not be found,
 * or doesn't have permission to write to it, or any other reason.
 * 
 * @author Grupo 12
 */
public class NotInitializedException extends Exception {

	private static final long serialVersionUID = -2750564665030354897L;

	/**
	 * Creates a new NotInitializedException with the given message.
	 * 
	 * @param message indicating the reason this exception was thrown.
	 */
	public NotInitializedException(String message) {
		super(message);
	}
	
}
