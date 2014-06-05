package grupo12.Logger.conf;

import java.io.File;
import java.util.List;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

public class XMLReader extends ConfigFileParser{

	private static final String xmlFile = "logger-config.xml";
	
	
	private void buildConfigurations() throws Exception{
	
		File cfg = new File(xmlFile);
		
		if (!cfg.exists()){
			
			callNext();
		}
		
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		Document doc = docBuilder.parse (cfg);
    
		doc.getDocumentElement ().normalize ();
		NodeList listOfUsers = doc.getElementsByTagName("user");
		int totalUsers = listOfUsers.getLength();
    
		for(int s=0; s<totalUsers ; s++){
			Node confNode = listOfUsers.item(s);
            if(confNode.getNodeType() == Node.ELEMENT_NODE){
            	
            	Element confElement = (Element)confNode;
            	Configuration aConfiguration=new Configuration();
            	
            	NodeList userNameList = confElement.getElementsByTagName("userName");
                Element userNameElement = (Element)userNameList.item(0);
                NodeList textUserNameList = userNameElement.getChildNodes();
                aConfiguration.setName(((Node)textUserNameList.item(0)).getNodeValue().trim());
                
                NodeList modeList = confElement.getElementsByTagName("mode");
                Element modeElement = (Element)modeList.item(0);
                NodeList textModeList = modeElement.getChildNodes();
                aConfiguration.setLevels(((Node)textModeList.item(0)).getNodeValue().trim());
                
                NodeList patternList = confElement.getElementsByTagName("pattern");
                Element patternElement = (Element)patternList.item(0);
                NodeList textPatternList = patternElement.getChildNodes();
                aConfiguration.setFormatters(((Node)textPatternList.item(0)).getNodeValue().trim());
                
                NodeList outputList = confElement.getElementsByTagName("output");
                Element outputElement = (Element)outputList.item(0);
                NodeList textOutputList = outputElement.getChildNodes();
                aConfiguration.setOutputs(((Node)textOutputList.item(0)).getNodeValue().trim());
                
                confList.add(aConfiguration);
            }
    	
		}
	}

	
	@Override
	public List<Configuration> getConfigurationsList(){
		try {
			buildConfigurations();
		} catch (Exception e) {
			// FIXME ser mas claro
			e.printStackTrace();
		}
		return confList;
	}
	
}
	
