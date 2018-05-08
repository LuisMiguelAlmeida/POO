package poo;

import java.util.ArrayList;

public class EvPrint extends Event {
	
	//construtor
	EvPrint(double T, Child S){
		super(T, S);
	}
	
	//função para imprimir as informações pedidas no enunciado
	/**
	 * Função que imprime para o ecrã todas as informações pedidas no enunciado
	 * @param grid Grid para acesso de parametros do problema
	 * @return tempo associado ao evento a ser simulado
	 */
	public double simulate(Grid grid) {
		if(grid.currtime==grid.final_instant) {
			ArrayList<Point> bestpath;
			if(grid.bestpath==null) {
				bestpath=(grid.findbestone()).path;
			}
			else {
				bestpath=grid.bestpath;
			}
			String prefix="Path of the best fit individual";
			String format = "%-40s%s";
			System.out.printf(format, prefix, "");
			grid.print_path(bestpath);
			System.out.printf("%n");
		}
		else {
			String format = "%-40s%s%n";
			String prefix = "Present instant:";
			System.out.printf(format, prefix, grid.currtime);
			prefix = "Number of realized events:";
			System.out.printf(format, prefix, grid.nevents);
			prefix = "Population size:";
			System.out.printf(format, prefix, grid.children.size());
			prefix = "Final point has been hit: ";
			String sufix;
			if(grid.bestpath==null) {
				sufix="No";
				System.out.printf(format, prefix, sufix);
				Child best = grid.findbestone();
				prefix="Path of the best fit individual";
				format = "%-40s%s";
				System.out.printf(format, prefix, "");
				grid.print_path(grid.bestpath);
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
