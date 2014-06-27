package grupo12.Logger.conf.parser;

import grupo12.Logger.conf.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Parser for XML files.
 * 
 * @author Grupo 12
 */
public class XMLParser implements Parser {

	private String file;
	private Document doc;
	private boolean ready;

	/**
	 * Creates a parser for XML files, so we can load the configuration for each {@link grupo12.Logger.api.Logger Logger}.
	 * 
	 * @param xmlFile to parse
	 */
	public XMLParser(String xmlFile) {
		file = xmlFile;
		ready = false;
	}

	@Override
	public boolean canParse() {
		return ready;
	}
	
	@Override
	public List<Configuration> loadConfigurations() {
		List<Configuration> configurationList = new ArrayList<Configuration>();
		
		if (!canParse()) {
			return configurationList; // empty
		}
		
		doc.getDocumentElement().normalize();
		
		// Get every level:
		NodeList levels = doc.getElementsByTagName("levels");
		Element levelsElement = (Element) levels.item(0);
		NodeList textLevelsList = levelsElement.getChildNodes();
		String parsedLevels = ((Node) textLevelsList.item(0)).getNodeValue().trim();
		
		
		// Get every logger:
		NodeList loggers = doc.getElementsByTagName("logger");
		int totalUsers = loggers.getLength();

		for (int s = 0; s < totalUsers; s++) {
			Node confNode = loggers.item(s);
            if (confNode.getNodeType() == Node.ELEMENT_NODE) {
            	Configuration aConfiguration = createConfiguration(parsedLevels, confNode);
                configurationList.add(aConfiguration);
            }
		}
		return configurationList;
	}

	/**
	 * Creates a Configuration instance for each {@link grupo12.Logger.api.Logger Logger} name in the xml file.
	 * 
	 * @param parsedLevels supported by the logger
	 * @param confNode containing the information of the logger
	 */
	private Configuration createConfiguration(String parsedLevels, Node confNode) {
		
		Element confElement = (Element) confNode;
    	Configuration aConfiguration = new Configuration();
    	
    	// TODO: revisar que poner por default si falla (no esta en el archivo)
    	
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
    	if (outputsList.getLength() != 0) {
    		Element outputsElement = (Element) outputsList.item(0);
    		NodeList textOutputsList = outputsElement.getChildNodes();
    	
	    	int totalOutputs = textOutputsList.getLength();
	    	StringBuilder appendedOutputs = new StringBuilder();
	    	StringBuilder appendedSeparators = new StringBuilder();
	    	StringBuilder appendedFormatters = new StringBuilder();
	    	
	    	for (int l = 0; l < totalOutputs; l++) {
	    		Node outputNode = textOutputsList.item(l);
	            if (outputNode.getNodeType() == Node.ELEMENT_NODE) {	
	    				Element outputElement = (Element) outputNode;
	            		NodeList typeList = outputElement.getElementsByTagName("type");
	            		Element typeElement = (Element) typeList.item(0);
	            		NodeList textTypeList = typeElement.getChildNodes();
	            		appendedOutputs.append(((Node) textTypeList.item(0)).getNodeValue().trim());
	            		appendedOutputs.append(",");
	            		
	            		NodeList separatorList = outputElement.getElementsByTagName("separator");
	            		Element separatorElement = (Element) separatorList.item(0);
	            		NodeList textSeparatorList = separatorElement.getChildNodes();
	            		appendedSeparators.append(((Node) textSeparatorList.item(0)).getNodeValue().trim());
	            		appendedSeparators.append(",");
	
	            		NodeList formatterList = outputElement.getElementsByTagName("formatter");
	            		Element formatterElement = (Element) formatterList.item(0);
	            		NodeList textFormatterList = formatterElement.getChildNodes();
	            		appendedFormatters.append(((Node) textFormatterList.item(0)).getNodeValue().trim());
	            		appendedFormatters.append(",");
	            }
	    	}
	    	aConfiguration.setOutputs(appendedOutputs.toString());
	    	aConfiguration.setSeparators(appendedSeparators.toString());
	    	aConfiguration.setFormatters(appendedFormatters.toString());
    	}
    	
    	NodeList customOutputsList = confElement.getElementsByTagName("customOutputs");
    	if (customOutputsList.getLength() != 0){
    		List<String> coList= new ArrayList<String>();
        	Element customOutputElement = (Element) customOutputsList.item(0);
        	NodeList textCustomOutputsList = customOutputElement.getChildNodes();
        	
        	int totalCustomOutputs = textCustomOutputsList.getLength();
        	
        	for (int i = 0; i < totalCustomOutputs; i++) {
        		StringBuilder appendedCustomOutputs= new StringBuilder();
        		Node customOutputNode = textCustomOutputsList.item(i);
        		
        		 if (customOutputNode.getNodeType() == Node.ELEMENT_NODE) {
        			 
        			Element aCustomOutputElement = (Element) customOutputNode;
        			
        			NodeList implementorList = aCustomOutputElement.getElementsByTagName("implementor");
             		Element implementorElement = (Element) implementorList.item(0);
             		NodeList textImplementorList = implementorElement.getChildNodes();
        			String implementor= textImplementorList.item(0).getNodeValue().trim();
        			
        			appendedCustomOutputs.append(implementor);
        			appendedCustomOutputs.append(":");
        			
        			NodeList parametersList=  aCustomOutputElement.getElementsByTagName("parameters");
        			if (!(parametersList.getLength() == 0)) {
        				Element parametersElement = (Element) parametersList.item(0);
        				NodeList parameterList = parametersElement.getChildNodes();
        			
        				for (int j=0; j<parameterList.getLength(); j++) {
        					Node parameterNode = parameterList.item(j);        					
        					if (parameterNode.getNodeType() == Node.ELEMENT_NODE) {
        						String apnd = parameterNode.getFirstChild().getNodeValue().trim();	       					
        						appendedCustomOutputs.append(apnd);
        						appendedCustomOutputs.append(",");
        					}
        				}
        			}
        			coList.add(appendedCustomOutputs.toString());
        		}
        	}
        	aConfiguration.setCustomOutputs(coList);
    	}
    	aConfiguration.setAvailableLevels(parsedLevels);
    	
    	return aConfiguration;
	}
	
	@Override
	public boolean init() {
		String getFile;
		try {
			getFile = this.getClass().getResource("/" + file).toURI().getPath();
		} catch (Exception e) {
			ready = false;
			return false; // empty
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
			try {
				input.close();
			} catch (Exception e) {
				ready = false;
				return false; // empty
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
