package poo;

public class EvDeath extends Event {
	
	EvDeath(double T, Child S){
		super(T, S);
	}
	
	public void simulate(Grid grid) {
		Child child = this.subject;
		child.death=true;
	}

}
