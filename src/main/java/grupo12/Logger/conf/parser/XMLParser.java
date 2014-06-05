package grupo12.Logger.conf.parser;

import grupo12.Logger.conf.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

public class XMLParser implements Parser {

	private String file;
	private File cfg;
	private Document doc;
	
	public XMLParser(String xmlFile) {
		file = xmlFile;
	}
	
	@Override
	public void loadConfigurations(List<Configuration> configurations) {    
		doc.getDocumentElement().normalize ();
		NodeList Names = doc.getElementsByTagName("name");
		int totalUsers = Names.getLength();
    
		for(int s=0; s<totalUsers; s++){
			Node confNode = Names.item(s);
            if(confNode.getNodeType() == Node.ELEMENT_NODE){
            	
            	Element confElement = (Element)confNode;
            	Configuration aConfiguration=new Configuration();
            	
            	NodeList loggerNameList = confElement.getElementsByTagName("name");
                Element loggerNameElement = (Element)loggerNameList.item(0);
                NodeList textLoggerNameList = loggerNameElement.getChildNodes();
                aConfiguration.setName(((Node)textLoggerNameList.item(0)).getNodeValue().trim());
                
                NodeList levelList = confElement.getElementsByTagName("levels");
                Element levelElement = (Element)levelList.item(0);
                NodeList textLevelList = levelElement.getChildNodes();
                aConfiguration.setLevels(((Node)textLevelList.item(0)).getNodeValue().trim());
                
                NodeList formatterList = confElement.getElementsByTagName("formatters");
                Element formatterElement = (Element)formatterList.item(0);
                NodeList textFormatterList = formatterElement.getChildNodes();
                aConfiguration.setFormatters(((Node)textFormatterList.item(0)).getNodeValue().trim());
                
                NodeList outputList = confElement.getElementsByTagName("outputs");
                Element outputElement = (Element)outputList.item(0);
                NodeList textOutputList = outputElement.getChildNodes();
                aConfiguration.setOutputs(((Node)textOutputList.item(0)).getNodeValue().trim());
                
                configurations.add(aConfiguration);
            }
    	
		}
	}

	
	@Override
	public boolean init() {
		cfg = new File(file);
		
		if (cfg == null || !cfg.exists()) {
			return false;
		}
		
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder docBuilder;
		try {
			docBuilder = docBuilderFactory.newDocumentBuilder();
			doc = docBuilder.parse(cfg);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			return false;
		}
		
		return true;
	}
}
	
