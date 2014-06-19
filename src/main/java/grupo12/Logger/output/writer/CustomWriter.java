package grupo12.Logger.output.writer;

import java.util.List;

import grupo12.Logger.utils.MyClassLoader;
import grupo12.Logger.utils.MyFileUtils;

/**
 * Class that wraps a custom {@link Writer} made by the user.
 * The user can define in this custom writer where it want to write the messages.
 * The class created by the user must implement the {@link Writer} interface.
 * 
 * @author Grupo 12
 */
public class CustomWriter implements Writer {

	private Writer customWriter;
	private String className;

	/**
	 * Creates an instance of the wrapper for the custom writer.
	 * Inside resides an instance of the class passed.
	 * The class passed by parameter must implement the {@link Writer} interface.
	 * 
	 * @param className to wrap
	 */
	public CustomWriter(String className, List<String> parameters) {
		this.className = MyFileUtils.getBaseName(className); // remove ".class"
		if (parameters != null && !parameters.isEmpty()) {
			customWriter = (Writer) MyClassLoader.loadClassWithStringParameters(this.className, "grupo12.Logger.output.writer.Writer", parameters);
		} else {
			customWriter = (Writer) MyClassLoader.loadClass(this.className, "grupo12.Logger.output.writer.Writer");
		}
	}
	
	@Override
	public void write(String message) {
		if (canWrite()) {
			customWriter.write(message);
		}
	}

	@Override
	public void init() throws NotInitializedException {
		if (customWriter == null) {
			throw new NotInitializedException("The class '" + className + "' could not be initialized.");
		} else {
			customWriter.init();
		}
	}

	@Override
	public void end() {
		if (customWriter != null) {
			customWriter.end();
			customWriter = null;
		}
	}

	@Override
	public boolean canWrite() {
		if (customWriter == null) {
			return false;
		} else {
			return customWriter.canWrite();
		}
	}

}
