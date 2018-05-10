package poo;

public class EvPrint extends Event {
	
	//construtor
	EvPrint(double T, Child S){
		super(T, S);
	}
	
	//fun��o para imprimir as informa��es pedidas no enunciado
	/**
	 * Funcao que imprime para o ecra todas as informacoes pedidas no enunciado
	 * @param grid Grid para acesso de parametros do problema
	 * @return tempo associado ao evento a ser simulado
	 */
	public double simulate(Grid grid) {
		grid.currtime=time;
		Child best = grid.findbestone();
		System.out.println("");
		if(grid.currtime==grid.final_instant) {
			String prefix="Path of the best fit individual";
			String format = "%-40s%s";
			System.out.printf(format, prefix, "");
			grid.print_path(best.path);
			System.out.printf("%n");
		}
		else {
			String format = "%-40s%s%n";
			String prefix = "Present instant:";
			System.out.printf(format, prefix, grid.currtime);
			prefix = "Number of realized events:";
			System.out.printf(format, prefix, grid.nevents);
			prefix = "Population size:";
			int pop=0;
			for(int i=0; i<grid.children.size(); i++) {
				if(!grid.children.get(i).death) {
					pop++;
				}
			}
			System.out.printf(format, prefix, pop);
			prefix = "Final point has been hit: ";
			String sufix;
			if(grid.bestpath==null) {
				sufix="No";
				System.out.printf(format, prefix, sufix);
				prefix="Path of the best fit individual";
				format = "%-40s%s";
				System.out.printf(format, prefix, "");
				grid.print_path(best.path);
				System.out.printf("%n");
				prefix="Cost/Comfort:";
				format = "%-40s%s/%s%n";
				System.out.printf(format, prefix, best.cost, best.comfort);
				
			}
			else {
				sufix="Yes";
				System.out.printf(format, prefix, sufix);
				prefix="Path of the best fit individual";
				format = "%-40s%s";
				System.out.printf(format, prefix, "");
				grid.print_path(grid.bestpath);
				System.out.printf("%n");
				prefix="Cost/Comfort:";
				format = "%-40s%s/%s%n";
				System.out.printf(format, prefix, grid.bestcost, grid.bestcomfort);
			}
			
		}
		return(this.time);
	}

}
