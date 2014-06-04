package grupo12.Logger.conf;

import java.util.ArrayList;

public class ConfigurationParser {

	private static final String xmlFile = "logger-config.xml";
	private static final String propertiesFile = "logger-config.properties";
	
	private ArrayList<Configuration> configurations;
	
	public ConfigurationParser() {
		configurations = new ArrayList<Configuration>();
	}
	
	private void loadConfiguration() {
		/* TODO: cargar primero el properties, si existe, parsearlo y crear
		 * una clase Configuration por cada configuración de logger encontrada,
		 * y agregarla a la lista configurations.
		 * 
		 * Si no existe el properties, buscar el xml y hacer lo mismo.
		 * 
		 * Si no existe ninguno, no agregar NADA a configurations.
		 * 
		 * 
		 * Para crear la clase Configuration, utilizar el constructor SIN parametros.
		 * Utilizar los métodos "set" para cargarle los datos. 
		 */
	}
	
	public ArrayList<Configuration> getConfigurations() {
		return configurations;
	}

}
