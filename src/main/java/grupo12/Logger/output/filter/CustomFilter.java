package grupo12.Logger.output.filter;

import grupo12.Logger.message.LogMessage;
import grupo12.Logger.utils.MyClassLoader;
import grupo12.Logger.utils.MyFileUtils;

/**
 * Class that wraps a custom {@link grupo12.Logger.output.filter.Filter Filter} made by the user.
 * The user can define in this custom filter how it want to filter the messages.
 * The class created by the user must implement the {@link grupo12.Logger.output.filter.Filter Filter} interface.
 * 
 * @author Grupo 12
 */
public class CustomFilter implements Filter {

	private Filter customFilter;
	private String className;
	
	/**
	 * Creates an instance of the wrapper for the custom filter.
	 * Inside resides an instance of the class passed.
	 * The class passed by parameter must implement the {@link grupo12.Logger.output.filter.Filter Filter} interface.
	 * 
	 * @param className to wrap
	 */
	public CustomFilter(String classFile) {
		className = MyFileUtils.getBaseName(classFile); // remove ".class"
		customFilter = (Filter) MyClassLoader.loadClass(className, "grupo12.Logger.output.filter.Filter");	
	}
	
	@Override
	public boolean filter(LogMessage message) {
		if (customFilter != null) {
			return customFilter.filter(message);
		} else {
			return true;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof CustomFilter)) {
			return false;
		} else {
			CustomFilter other = (CustomFilter) object;
			return className.equals(other.className);
		}
	}
}
