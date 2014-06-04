package grupo12.Logger.conf;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

public class XMLReader {

	private List<Configuration> confList = new ArrayList<Configuration>();
	
	
	public XMLReader(String configurationXML) throws Throwable{
		
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse (new File("src/main/resources/"+configurationXML));
        
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
	public List<Configuration> getConfigurationsList(){
		return confList;
	}
	
//	public static void main (String argv []){
//		XMLReader XMLprueba=new XMLReader("default.xml");
//		for (Configuration c : XMLprueba.getConfigurationsList()){
//			System.out.println(c.getName());
//			System.out.println(c.getLevels());
//			System.out.println(c.getFormatters());
//			System.out.println(c.getOutputs());
//		}
//	}
}
	
