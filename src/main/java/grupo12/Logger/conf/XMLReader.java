package grupo12.Logger.conf;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException; 

public class XMLReader {

	private List<User> userList = new ArrayList<User>();
	
	public XMLReader() {
		//TODO: este path es muy feo
		this("src/main/resources/default.xml");
	}
	
	public XMLReader(String configurationXML){
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse (new File(configurationXML));
        
			doc.getDocumentElement ().normalize ();
			NodeList listOfUsers = doc.getElementsByTagName("user");
			int totalUsers = listOfUsers.getLength();
        
			for(int s=0; s<totalUsers ; s++){
				Node userNode = listOfUsers.item(s);
                if(userNode.getNodeType() == Node.ELEMENT_NODE){
                	
                	Element userElement = (Element)userNode;
                	User aUser=new User();
                	
                	NodeList userNameList = userElement.getElementsByTagName("userName");
                    Element userNameElement = (Element)userNameList.item(0);
                    NodeList textUserNameList = userNameElement.getChildNodes();
                    aUser.setUserName(((Node)textUserNameList.item(0)).getNodeValue().trim());
                    
                    NodeList modeList = userElement.getElementsByTagName("mode");
                    Element modeElement = (Element)modeList.item(0);
                    NodeList textModeList = modeElement.getChildNodes();
                    aUser.setMode(((Node)textModeList.item(0)).getNodeValue().trim());
                    
                    NodeList patternList = userElement.getElementsByTagName("pattern");
                    Element patternElement = (Element)patternList.item(0);
                    NodeList textPatternList = patternElement.getChildNodes();
                    aUser.setPattern(((Node)textPatternList.item(0)).getNodeValue().trim());
                    
                    NodeList outputList = userElement.getElementsByTagName("output");
                    Element outputElement = (Element)outputList.item(0);
                    NodeList textOutputList = outputElement.getChildNodes();
                    aUser.setOutput(((Node)textOutputList.item(0)).getNodeValue().trim());
                    
                    userList.add(aUser);
                }
        	
			}
        
		}catch (SAXParseException err) {
	        System.out.println ("** Parsing error" + ", line " 
	                + err.getLineNumber () + ", uri " + err.getSystemId ());
	           System.out.println(" " + err.getMessage ());

	           }catch (SAXException e) {
	           Exception x = e.getException ();
	           ((x == null) ? e : x).printStackTrace ();

	           }catch (Throwable t) {
	           t.printStackTrace ();
	           }
	}
	public List<User> getUserList(){
		return userList;
	}
	
//	public static void main (String argv []){
//		XMLReader XMLprueba=new XMLReader();
//		for (User u : XMLprueba.getUserList()){
//			System.out.println(u.getUserName());
//			System.out.println(u.getMode());
//			System.out.println(u.getPattern());
//			System.out.println(u.getOutput());
//		}
//	}
}
	
