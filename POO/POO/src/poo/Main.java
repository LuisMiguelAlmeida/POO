package poo;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;


import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		Grid grid= new Grid();
		ReadFile handler = new ReadFile(grid);
		
		grid=handler.getGrid();
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		factory.setValidating(true);// Change to true
		factory.setNamespaceAware(true);
		SAXParser parser = null;
		try {
			parser = factory.newSAXParser();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			parser.parse(new File("simulation.xml"), handler);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		grid=handler.getGrid();
		int a= grid.getMaxc();
		System.out.println(Integer.toString(a));
		
	}

}
