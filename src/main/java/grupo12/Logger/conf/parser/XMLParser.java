package grupo12.Logger.conf.parser;

import grupo12.Logger.conf.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

public class XMLParser implements Parser {

	private String file;
	private Document doc;
	private boolean ready;

	public XMLParser(String xmlFile) {
		file = xmlFile;
		ready = false;
	}

	@Override
	public boolean canParse() {
		return ready;
	}
	
	@Override
	public void loadConfigurations(List<Configuration> configurations) {
		if (!canParse()) {
			return;
		}
		
		doc.getDocumentElement().normalize();
		
		// Get every level:
		// TODO
				
		// Get every logger:
		NodeList loggers = doc.getElementsByTagName("logger");
		int totalUsers = loggers.getLength();

		for (int s = 0; s < totalUsers; s++) {
			Node confNode = loggers.item(s);
            if (confNode.getNodeType() == Node.ELEMENT_NODE) {
            	
            	Element confElement = (Element) confNode;
            	Configuration aConfiguration = new Configuration();
            	
            	NodeList loggerNameList = confElement.getElementsByTagName("name");
                Element loggerNameElement = (Element) loggerNameList.item(0);
                NodeList textLoggerNameList = loggerNameElement.getChildNodes();
                aConfiguration.setName(((Node) textLoggerNameList.item(0)).getNodeValue().trim());
                
                NodeList levelList = confElement.getElementsByTagName("level");
        		Element levelElement = (Element) levelList.item(0);
        		NodeList textLevelList = levelElement.getChildNodes();
        		aConfiguration.setLevel(((Node) textLevelList.item(0)).getNodeValue().trim());
        		
        		NodeList filterList = confElement.getElementsByTagName("filter");
        		Element filterElement = (Element) filterList.item(0);
        		NodeList textFilterList = filterElement.getChildNodes();
        		aConfiguration.setFilter(((Node) textFilterList.item(0)).getNodeValue().trim());
                
            	NodeList outputsList = confElement.getElementsByTagName("outputs");
            	Element outputsElement = (Element) outputsList.item(0);
            	NodeList textOutputsList = outputsElement.getChildNodes();
            	int totalOutputs = textOutputsList.getLength();
            	for (int l = 0; l < totalOutputs; l++) {
            		Node outputNode = textOutputsList.item(l);
                    if (outputNode.getNodeType() == Node.ELEMENT_NODE) {	
            				Element outputElement = (Element) outputNode;
                    		NodeList typeList = outputElement.getElementsByTagName("type");
                    		Element typeElement = (Element) typeList.item(0);
                    		NodeList textTypeList = typeElement.getChildNodes();
                    		aConfiguration.addOutput(((Node) textTypeList.item(0)).getNodeValue().trim());
                    		
                    		NodeList separatorList = outputElement.getElementsByTagName("separator");
                    		Element separatorElement = (Element) separatorList.item(0);
                    		NodeList textSeparatorList = separatorElement.getChildNodes();
                    		aConfiguration.addSeparator(((Node) textSeparatorList.item(0)).getNodeValue().trim());

                    		NodeList formatterList = outputElement.getElementsByTagName("formatter");
                    		Element formatterElement = (Element) formatterList.item(0);
                    		NodeList textFormatterList = formatterElement.getChildNodes();
                    		aConfiguration.addFormatter(((Node) textFormatterList.item(0)).getNodeValue().trim());

                   		
                    }
            	}
                configurations.add(aConfiguration);
            }
		}
	}

	@Override
	public boolean init() {
		String getFile;
		try {
			getFile = this.getClass().getResource("/" + file).getFile();
		} catch (Exception e) {
			ready = false;
			return false;
		}
		
		InputStream input = null;
		try {
			input = new FileInputStream(getFile);
		} catch (IOException ex) {
			ready = false;
			return false; // empty
		}
		
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();

		DocumentBuilder docBuilder;
		try {
			docBuilder = docBuilderFactory.newDocumentBuilder();
			doc = docBuilder.parse(input);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			ready = false;
			return false;
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					ready = false;
					return false; // empty
				}
			}
		}
		
		ready = true;
		return true;
	}

	@Override
	public void setFile(String file) {
		this.file = file;
	}
	
	
}
