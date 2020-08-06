package esh.jets;

import java.io.File;
import java.util.Scanner; //Scanner class imported

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class jetplaneapp {	

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		String user, pass;
		
		System.out.print("Enter Username: ");
		user = input.nextLine();
		
		System.out.print("Enter Password: ");
		pass = input.nextLine();
		
		if(user.equals("client") && (pass.equals("password"))||(user.equals("admin") && (pass.equals("passwordadmin")))) {	
			System.out.println("Welcome");
			readfile("jetplanes.xml","jets");

			
			 if(user.equals("admin") && (pass.equals("passwordadmin"))) {
				 
				 readfile("Confirmations.xml","confirmation");
				 readfile("Booking.xml","clientbooking");
		        	
		        }
			
		}
		else {
			System.out.println("Incorrect login");
	
		}							
	} 
	public static void readfile(String filename,String field) {
		try {
			
		  	File inputFile = new File(filename);
		
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(inputFile);
	        doc.getDocumentElement().normalize();
	      
	        NodeList nList = doc.getElementsByTagName(field);
	        
	        for (int i = 0; i < nList.getLength(); i++) {
        		Node nNode = nList.item(i);
        	   	if (nNode.getNodeType() == Node.ELEMENT_NODE) {
        		   Element eElement = (Element) nNode;
        		   System.out.println();
        		   System.out.println("List attributes for node: " + eElement.getNodeName());
        	         
        	        
        	        NamedNodeMap attributes = eElement.getAttributes();
       
        	        int numAttrs = attributes.getLength();
        	 
        	        for (int j = 0; j < numAttrs; j++) {
        	            Attr attr = (Attr) attributes.item(j);
        	             
        	            String attrName = attr.getNodeName();
        	            String attrValue = attr.getNodeValue();
        	             
        	            System.out.println(attrName + " with value: " + attrValue);
        	        }
        	   	}
    		}

	        
        }
	 
		catch(Exception e) {
			System.err.println(e.getMessage());			
			
        } 
	}
}
