package grupo12.Logger.filter;



public class FiltererFactory {
	
	public Filterer getFilterer(String filter) {
		
		return new Filterer(filter);
		
	
	}
}
