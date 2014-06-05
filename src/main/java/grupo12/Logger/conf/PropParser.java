package grupo12.Logger.conf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class PropParser extends ConfigFileParser {
	
	private static final String propertiesFile = "logger-config.properties";

	@Override
	public List<Configuration> getConfigurationsList() {
		// TODO parsear de properties file

		
		File cfg = new File(propertiesFile);
		
		if (!cfg.exists()){
			
			callNext();
		}
		
		InputStream input=null;
		
		try {
			Properties propFile = new Properties();
			input = new FileInputStream(propertiesFile);
			propFile.load(input);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
				//e.printStackTrace();
				}
			}
		}
		
		
		
		return next.getConfigurationsList();
	}


}
