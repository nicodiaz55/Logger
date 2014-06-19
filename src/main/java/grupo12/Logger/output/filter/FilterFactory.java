package grupo12.Logger.output.filter;

/**
 * Class that creates specific {@link grupo12.Logger.output.filter.Filter Filter}s according to a String.
 * 
 * @author Grupo 12
 */
public class FilterFactory {
	
	/**
	 * Returns an instantiated {@link grupo12.Logger.output.filter.Filter Filter} according to its name.
	 * If the name ends with ".class", it returns a {@link CustomFilter} wrapping that class.
	 * Everything else is considered a regex, so it returns a {@link RegexFilter}.
	 * 
	 * @param filter name
	 * @return a Filter instance
	 */
	public Filter getFilter(String filter) {
		if (filter.endsWith(".class")) {
			return new CustomFilter(filter);
		} else {
			return new RegexFilter(filter);
		}
	}
}
