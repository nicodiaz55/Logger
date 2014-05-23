package grupo12.Logger.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class Configuration {
	
	private static final String defaultLevel = "INFO";
	private static final String defaultPattern = "%d{HH:mm:ss} - %p - %t - %m";
	private static final String defaultOutput = "console";
	private static final String defaultSeparator = "-";
	
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
		validateOutputField();
	}

	private void validateOutputField() {
	/*	String outputs = conf.getProperty("output", defaultOutput);
		// Reemplazo los console que haya de mas por strings vacios:

		// TODO: ver que esta regex funciona:
		outputs.replaceAll(",console,", ","); // Saco todos los console
		outputs.replaceAll(",console$", "");
		//backup.concat(",console"); // Agrego el console que estaba bien al final
		conf.setProperty("output", outputs);*/
	}
	
	public String getLevel() {
		return conf.getProperty("level", defaultLevel);
	}
	
	public String getSeparator() {
		return conf.getProperty("separator", defaultSeparator);
	}
	
	public ArrayList<String> getOutputs() {
		return new ArrayList<String>(Arrays.asList(conf.getProperty("output", defaultOutput).split(",")));
	}

	public String getPattern() {
		return conf.getProperty("pattern", defaultPattern);
	}
}