package poo;

public class EvPrint extends Event {
	
	EvPrint(double T, Child S){
		super(T, S);
	}
	
	public void simulate(Grid grid) {
		if(grid.currtime==grid.final_instant) {
			String prefix="Path of the best fit individual";
			String format = "%-40s%s";
			System.out.printf(format, prefix, "");
			grid.print_path();
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
				System.out.printf(format, prefix, best);
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
				grid.print_path();
				System.out.printf("%n");
				prefix="Cost/Comfort:";
				format = "%-40s%s/%s%n";
				System.out.printf(format, prefix, grid.bestcost, grid.bestcomfort);
			}
			
		}
	}

}
