package grupo12.Logger.filter;



public class FilterFactory {
	
	public Filter getFilter(String filter) {
		
		return new Filter(filter);
		
	
	}
}
