package grupo12.Logger.conf.parser;

import grupo12.Logger.conf.Configuration;

import java.io.File;
import java.io.IOException;
//import java.util.ArrayList;
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
		NodeList Loggers = doc.getElementsByTagName("logger");
		int totalUsers = Loggers.getLength();
    
		for(int s=0; s<totalUsers; s++){
			Node confNode = Loggers.item(s);
            if(confNode.getNodeType() == Node.ELEMENT_NODE){
            	
            	Element confElement = (Element)confNode;
            	Configuration aConfiguration=new Configuration();
            	
            	NodeList loggerNameList = confElement.getElementsByTagName("name");
                Element loggerNameElement = (Element)loggerNameList.item(0);
                NodeList textLoggerNameList = loggerNameElement.getChildNodes();
                aConfiguration.setName(((Node)textLoggerNameList.item(0)).getNodeValue().trim());
                
            	NodeList OutputsList = confElement.getElementsByTagName("outputs");
            	Element OutputsElement = (Element)OutputsList.item(0);
            	NodeList textOutputsList = OutputsElement.getChildNodes();
            	int totalOutputs = textOutputsList.getLength();
            	for (int l=0; l<totalOutputs; l++) {
            		Node outputNode = textOutputsList.item(l);
                    if(outputNode.getNodeType() == Node.ELEMENT_NODE){
            				
            				Element outputElement = (Element)outputNode;
            				
                    		NodeList typeList = outputElement.getElementsByTagName("type");
                    		Element typeElement = (Element)typeList.item(0);
                    		NodeList textTypeList = typeElement.getChildNodes();
                    		aConfiguration.addOutput(((Node)textTypeList.item(0)).getNodeValue().trim());
                
                    		NodeList separatorList = outputElement.getElementsByTagName("separator");
                    		Element separatorElement = (Element)separatorList.item(0);
                    		NodeList textSeparatorList = separatorElement.getChildNodes();
                    		aConfiguration.addSeparator(((Node)textSeparatorList.item(0)).getNodeValue().trim());
                
                    		NodeList formatterList = outputElement.getElementsByTagName("formatter");
                    		Element formatterElement = (Element)formatterList.item(0);
                    		NodeList textFormatterList = formatterElement.getChildNodes();
                    		aConfiguration.addFormatter(((Node)textFormatterList.item(0)).getNodeValue().trim());
                 
                
                    		NodeList levelList = outputElement.getElementsByTagName("level");
                    		Element levelElement = (Element)levelList.item(0);
                    		NodeList textLevelList = levelElement.getChildNodes();
                    		aConfiguration.addLevel(((Node)textLevelList.item(0)).getNodeValue().trim());
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
			return false;
		}
		
		cfg = new File(getFile);
		
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
	
//	public static void main(String [ ] args)
//	{
//		XMLParser xml = new XMLParser("logger-config.xml");
//		System.out.println("cacacacacacaa");
//		List<Configuration> lista = new ArrayList<Configuration>();
//		xml.init();
//		xml.loadConfigurations(lista);
//		int len=lista.size();
//		for(int i=0; i<len; i++) {
//            
//			System.out.println(lista.get(i).getName());
//           
//			int len2=lista.get(i).getOutputs().size();
//			for(int j=0; j<len2; j++){
//				System.out.println(lista.get(i).getOutputs().get(j));
//				System.out.println(lista.get(i).getLevels().get(j));
//				System.out.println(lista.get(i).getFormatters().get(j));
//				System.out.println(lista.get(i).getSeparators().get(j));
//			}
//            
//        }
//	}
}
	
