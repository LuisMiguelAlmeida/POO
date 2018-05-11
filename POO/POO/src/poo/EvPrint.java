package poo;

public class EvPrint extends Event {
	
	//construtor
	EvPrint(double T, Child S){
		super(T, S);
	}
	
	//funcao para imprimir as informacoes pedidas no enunciado
	/**
	 * Funcao que imprime para o ecra todas as informacoes pedidas no enunciado
	 * @param grid Grid para acesso de parametros do problema
	 * @return tempo associado ao evento a ser simulado
	 */
	public double simulate(Grid grid) {
		grid.currtime=time;		
		
		String format = "%n%s%s:%n";
		String prefix = "Observation ";
		System.out.printf(format, prefix, (int)((grid.currtime/grid.final_instant)*20));
		format = "%10s%-40s%s%n";
		prefix = "Present instant:";
		System.out.printf(format, "", prefix, grid.currtime);
		prefix = "Number of realized events:";
		System.out.printf(format, "", prefix, grid.nevents);
		prefix = "Population size:";
		int pop=0;
		for(int i=0; i<grid.children.size(); i++) {
			if(!grid.children.get(i).death) {
				pop++;
			}
		}
		System.out.printf(format, "", prefix, pop);
		prefix = "Final point has been hit: ";
		String sufix;
		if(grid.bestcost==0) {
			sufix="No";
			System.out.printf(format, "", prefix, sufix);
			prefix="Path of the best fit individual";
			format = "%10s%-40s%s";
			System.out.printf(format, "", prefix, "");
			grid.print_path(grid.bestpath);
			System.out.printf("%n");
			prefix="Comfort:";
			format = "%10s%-40s%s%n";
			System.out.printf(format, "", prefix, grid.bestcomfort);
		}
		else {
			sufix="Yes";
			System.out.printf(format, "", prefix, sufix);
			prefix="Path of the best fit individual";
			format = "%10s%-40s%s";
			System.out.printf(format, "", prefix, "");
			grid.print_path(grid.bestpath);
			System.out.printf("%n");
			prefix="Cost:";
			format = "%10s%-40s%s%n";
			System.out.printf(format, "", prefix, grid.bestcost);
		}
		
		if(grid.currtime==grid.final_instant) {
			prefix="Path of the best fit individual = ";
			format = "%n%s%s";
			System.out.printf(format, prefix, "");
			grid.print_path(grid.bestpath);
		}

		return(this.time);
	}

}
