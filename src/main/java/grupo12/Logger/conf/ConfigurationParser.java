package grupo12.Logger.conf;

import java.util.ArrayList;

import org.xml.sax.SAXParseException;
import org.xml.sax.SAXException;


public class ConfigurationParser {

	private static final String xmlFile = "conf.xml";
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
		
		//Nestear el XML adentro de un if que chequee lo del properties??
		//el XML
		try{
		XMLReader xmlReader=new XMLReader("conf.xml");
		}catch (SAXParseException err) {
	        System.out.println ("** Parsing error" + ", line " 
	                + err.getLineNumber () + ", uri " + err.getSystemId ());
	           System.out.println(" " + err.getMessage ());
	           //ACA ENTRA EN "NO SE AGREGA NADA"... SE LLAMA ALGUN METODO?
	           }catch (SAXException e) {
	           Exception x = e.getException ();
	           ((x == null) ? e : x).printStackTrace ();
	         //ACA ENTRA EN "NO SE AGREGA NADA"... SE LLAMA ALGUN METODO?
	           }catch (Throwable t) {
	           t.printStackTrace ();
	         //ACA ENTRA EN "NO SE AGREGA NADA"... SE LLAMA ALGUN METODO?
	           }
	}
		
	
	
	public ArrayList<Configuration> getConfigurations() {
		return configurations;
	}

	public static void main (String argv []){
		ConfigurationParser aux=new ConfigurationParser();
		aux.loadConfiguration();
		
		
	}
}
