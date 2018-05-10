package poo;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;


import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		long startTime = System.nanoTime();
		
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
		//Adiciona população inicial
		for(int i=0; i<grid.v; i++) {
			Child n = new Child(grid);
			n.add_point(grid.initial_point);
			grid.add_child(n);
		}
		for(int i=1; i<=20; i++) {
			EvPrint print = new EvPrint((((grid.final_instant)/20)*i), null);
			grid.pec.addEvPEC(print);
		}
		Event currevent;
		while(grid.currtime < grid.final_instant) {
			//System.out.println("CURRENT TIME: "+grid.currtime);
			currevent=grid.pec.nextEvPEC();
			//System.out.println("Next time: "+currevent.time);
			grid.currtime=currevent.simulate(grid);
			currevent=null;
		}
		
		long endTime=System.nanoTime();
		System.out.println("TOOK " + (endTime-startTime)*10E-9+ "s");
		
		
	}

}
