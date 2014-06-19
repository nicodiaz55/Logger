package grupo12.Logger.filter;



public class FilterFactory {
	
	public Filter getFilterer(String filter) {
		
		
		
		if (filter.endsWith(".class")){
			//TODO:chequear esto!! (Si no hacemos un script de bash y ya fue)
			String aux = filter.substring(filter.lastIndexOf(".class"));
			return new CustomFilter(aux);
		}else{
			return new RegexFilter(filter);
		}
	
	}
}
