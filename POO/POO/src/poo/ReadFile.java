package poo;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadFile extends DefaultHandler{

	Grid grid;
	

		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
        {
        	 

        	  int length = attributes.getLength();
 
        	  // process each attribute

        	  for (int i=0; i<length; i++) 
        	  {
	        	// get qualified (prefixed) name by index
	        	String name = attributes.getQName(i);
	        	System.out.println("Name:" + name);
	
	        	// get attribute's value by index.
	
	        	String value = attributes.getValue(i);
	
	        	System.out.println("Value:" + value);
	
	        	
	        	// get local name by index
	
	        	String lName = attributes.getLocalName(i);
	
	        	System.out.println("Local Name:" + lName);
        	  }

        }
		
	/*}*/
	
}
