package poo;



import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadFile extends DefaultHandler{

	Grid grid;
	

		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
        {
        	 

        	  int length = attributes.getLength();
        	  
        	  switch (qName) 
        	  {
	        	  // process each attribute
        	  case "simulation":
	        	  for (int i=0; i<length; i++) 
	        	  {
		        	// get qualified (prefixed) name by index
		        	String name = attributes.getQName(i);
		        		switch(name)
		        		{
		        		case "finalinst":
				        	
				
				        	// get attribute's value by index.
				        	String value = attributes.getValue(i);
				        	System.out.println("Value:" + value);
		        		}
	        	  }
        	  
        	  }
        	  /*  If qname=simulation then nananana (continuar a fazer*/
        	  /*switch (qName) {

              case "finalist":
                  System.out.println(x);
                  String name = attributes.getQName(i);
  	        	System.out.println("Name:" + name);
                  break;

              case "lastname":
                  bln = true;
                  break;

              case "occupation":
                  boc = true;
                  break;
        	  	}*/
        	  

        }
		// Aqui escrevemos o que está dentro de <elem> thisshouldbewrittenn </elem>
		
		  @Override
		    public void characters(char[] ch, int start, int length) throws SAXException {

		        //if (bfn) {
		            //System.out.println(new String(ch, start, length) + "in the middle of the elem");
		            
		        

		       
		    }
		
		
		
		// Devemos escrever nesta função, os atributos deste objecto??
		public void endElement(String uri, String localName,
		        String qName) throws SAXException {

		    //if ("zone".equals(qName)) {
		      // System.out.println("Hi guys i ahave");
		    //}
		}
		
	
	
}
