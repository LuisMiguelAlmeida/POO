package poo;



import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ReadFile extends DefaultHandler{
	
	//Atributos
	Grid grid;
	protected int x,y, xi,yi, xf,yf;
	protected int n_obst; // Variavel auxiliar que nos ajuda a criar um vetor de obstaculos
	protected int n_tupples; 
	protected boolean zoones=false;
	
		//Construtor
		ReadFile(Grid _grid){
			grid=_grid;
			n_obst=0;
			n_tupples=0;
			x=0;y=0;
			zoones=false;
		}
		// Getters and Setters
		public Grid getGrid() {
			return grid;
		}

		public void setGrid(Grid grid) {
			this.grid = grid;
		}
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
        {
        	 

        	  int length = attributes.getLength();
        	  
        	  System.out.println(qName);
        	  switch (qName) 
        	  {
	        	  // process each attribute
        	  case "simulation":
	        	  for (int i=0; i<length; i++) 
	        	  {
	        		  String value = attributes.getValue(i);
		        	// get qualified (prefixed) name by index
		        	String name = attributes.getQName(i);
		        		switch(name)
		        		{
		        		case "finalinst":		        			
				        	grid.setFinal_instant(Integer.parseInt(value));
				        	break;
		        		case "initpop":
				        	grid.setV(Integer.parseInt(value));
				        	break;
		        		case "maxpop":
				        	grid.setV_max(Integer.parseInt(value));
				        	break;	
		        		case "comfortsens":
		        			grid.setK(Integer.parseInt(value));
		        			break;
				        	
		        		}
	        	  }
	          // Parametros da rede	 
        	  case "grid":
	        	  for (int i=0; i<length; i++) 
	        	  {
	        		  String value = attributes.getValue(i);
		        	// get qualified (prefixed) name by index
		        	String name = attributes.getQName(i);
		        		switch(name)
		        		{
		        		case "colsnb":		        			
				        	grid.setcol(Integer.parseInt(value));
				        	break;
		        		case "rowsnb":
				        	grid.setrows(Integer.parseInt(value));
				        	break;
		        		}
	        	  }
	        	
        	  case "initialpoint":
	        	  for (int i=0; i<length; i++) 
	        	  {
	        		  String value = attributes.getValue(i);
		        	// get qualified (prefixed) name by index
		        	String name = attributes.getQName(i);
		        		switch(name)
		        		{
		        		case "xinitial":		        			
				        	x=(Integer.parseInt(value));
				        	break;
		        		case "yinitial":
				        	y=(Integer.parseInt(value));
				        	break;
		        		}
	        	  }	

        	  case "finalpoint":
	        	  for (int i=0; i<length; i++) 
	        	  {
	        		  String value = attributes.getValue(i);
		        	// get qualified (prefixed) name by index
		        	String name = attributes.getQName(i);
		        		switch(name)
		        		{
		        		case "xfinal":		        			
				        	x=(Integer.parseInt(value));
				        	break;
		        		case "yfinal":
				        	y=(Integer.parseInt(value));
				        	break;
		        		}
	        	  }	  
        	  
	        ///////////////////////////////case for specialzones	  
        	  case "specialcostzones":
	        	  for (int i=0; i<length; i++) 
	        	  {
	        		  String value = attributes.getValue(i);
		        	// get qualified (prefixed) name by index
		        	String name = attributes.getQName(i);
		        		switch(name)
		        		{
		        		case "num":		        			
				        	x=(Integer.parseInt(value));
				        	grid.create_Array_Tupples(x);
				        	break;
		        		
		        		}
	        	  }	  
        	  case "zone":
	        	  for (int i=0; i<length; i++) 
	        	  {
	        		  String value = attributes.getValue(i);
		        	// get qualified (prefixed) name by index
		        	String name = attributes.getQName(i);
		        	
		        		switch(name)
		        		{
		        		case "xinitial":		        			
				        	xi=(Integer.parseInt(value));	
				        	break;
		        		case "xfinal":		        			
				        	xf=(Integer.parseInt(value));	
				        	break;
		        		case "yinitial":		        			
				        	yi=(Integer.parseInt(value));	
				        	break;
		        		case "yfinal":		        			
				        	yf=(Integer.parseInt(value));	
				        	zoones=true;
				        	break;
		        		}
	        	  }
	        	  
	        	  
	        	  
	        	  
	        	  
	        	  
	        ////////////////////////////////////////////////////////////
        	  case "obstacles": // Inicializa o vetor de pontos a onde estao localizados os obtaculos
	        	  
	        		String value = attributes.getValue(0);        	
		        	String name = attributes.getQName(0);
		        		switch(name)
		        		{
		        		case "num":		        			
				        	grid.setN_obstacles((Integer.parseInt(value)));
				        	grid.setObstacles(new Point[grid.getN_obstacles()]);
				        	break;
		        		}
        	   
        	  case "obstacle":
	        	  for (int i=0; i<length; i++) 
	        	  {
	        		  String value1 = attributes.getValue(i);
		        	// get qualified (prefixed) name by index
		        	String name1 = attributes.getQName(i);
		        		switch(name1)
		        		{
		        		case "xpos":		        			
				        	x=(Integer.parseInt(value1));
				        		
				        	break;
		        		case "ypos":
				        	y=(Integer.parseInt(value1));
				        	break;
		        		}
	        	  }	
        	  case "death":
	        	  
	        		  String value1 = attributes.getValue(0);
		        	// get qualified (prefixed) name by index
		        	String name1 = attributes.getQName(0);
		        		switch(name1)
		        		{
		        		case "param":		        			
				        	x=(Integer.parseInt(value1));
				        	grid.setMew(x);
				        	break;
		        		}
	        	  
        	  case "reproduction":
	        	  
        		  String value2 = attributes.getValue(0);
	        	// get qualified (prefixed) name by index
	        	String name2 = attributes.getQName(0);
	        		switch(name2)
	        		{
	        		case "param":		        			
			        	x=(Integer.parseInt(value2));
			        	grid.setRo(x);
			        	break;
	        		}
        	  case "move":
	        	  
        		  String value3 = attributes.getValue(0);
	        	// get qualified (prefixed) name by index
	        	String name3 = attributes.getQName(0);
	        		switch(name3)
	        		{
	        		case "param":		        			
			        	x=(Integer.parseInt(value3));
			        	grid.setDelta(x);	        
			        	break;
	        		}	
	        	  
        	  }
        	 

        }
		// Aqui escrevemos o que está dentro de <elem> thisshouldbewrittenn </elem>
		
		  @Override
		    public void characters(char[] ch, int start, int length) throws SAXException {

			  if (zoones) {
				 String costt=new String(ch, start, length);
				 int cost=Integer.parseInt(costt);
			     Point initial= new Point(xi, yi);
				 Point finale= new Point(xf, yf);
				 grid.setzone(initial, finale,  cost,n_tupples);
		        
				 //Atualiza o maximo custo de uma aresta
				 int maxcost=grid.getMaxc();
				 if (maxcost<cost)
				 {
					 grid.setMaxc(cost);
				 }
		          n_tupples++;
		          zoones=false;
		        }
		        

		       
		    }
		
		
		
		// Devemos escrever nesta função, os atributos deste objecto??
		@Override  
		public void endElement(String uri, String localName,
		        String qName) throws SAXException {
			zoones=false;
			// Depois de ler os dois pontos do ficheiro guarda num objecto Point
		    if ("initialpoint".equals(qName)) {
		       grid.setInitial_point(new Point(x,y));
		    }
		    
		    if ("finalpoint".equals(qName)) {
			       grid.setFinal_point(new Point(x,y));
			}
		    if ("obstacle".equals(qName)) {
			       grid.put1obstacle((new Point(x,y)), n_obst);
			       n_obst++;
			}
		    
		}
		
	
	
}
