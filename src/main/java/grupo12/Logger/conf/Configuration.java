package grupo12.Logger.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class Configuration {
	
	public static final String defaultLevel = "INFO";
	public static final String defaultPattern = "%d{HH:mm:ss} - %p - %t - %m";
	public static final String defaultOutput = "console";
	public static final String defaultSeparator = "-";
	
	private Properties conf;
	
	public Configuration(String file) {
		loadFromFile(file);
	}

	private void loadFromFile(String file) {
		String getFile = this.getClass().getResource("/" + file).getFile();
		InputStream input = null;
		conf = new Properties();
		try {
			input = new FileInputStream(getFile);
			conf.load(input);
		} catch (IOException ex) {
			//ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					//e.printStackTrace();
				}
			}
		}
		validateFile();
	}

	private void validateFile() {
		/* TODO: Falta validar que las listas tengan todas el mismo tamaño...
		* el usuario podría trollearnos con eso.
		* 
		* TODO: Falta ver que no nos pongan más de 1 "console". O podríamos dejarlo...
		* al poner muchos "console", loggearía en consola todo junto, tantas veces como aparezca :P
		* 
		* TODO: si se complica mucho, podríamos no validar nada y ya fue. Pero lo explicamos en el informe!
		*/ 
	}
	
	public ArrayList<String> getLevels() {
		return new ArrayList<String>(Arrays.asList(conf.getProperty("level", defaultLevel).split(",")));
	}
	
	public ArrayList<String> getSeparators() {
		return new ArrayList<String>(Arrays.asList(conf.getProperty("separator", defaultSeparator).split(",")));
	}
	
	public ArrayList<String> getOutputs() {
		return new ArrayList<String>(Arrays.asList(conf.getProperty("output", defaultOutput).split(",")));
	}

	public ArrayList<String> getPatterns() {
		return new ArrayList<String>(Arrays.asList(conf.getProperty("pattern", defaultPattern).split(",")));
	}
}
