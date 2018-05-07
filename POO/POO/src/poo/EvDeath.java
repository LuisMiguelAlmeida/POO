package poo;

public class EvDeath extends Event {
	
	EvDeath(double T, Child S){
		super(T, S);
	}
	
	public double simulate(Grid grid) {
		Child child = this.subject;
		if(child.death) {
			return(this.time);
		}
		child.death=true;
		grid.nevents++;
		return(this.time);
	}

}
