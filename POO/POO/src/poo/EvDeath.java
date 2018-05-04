package poo;

public class EvDeath extends Event {
	
	public void simulate(Child child, Grid grid) {
		child.death=true;
	}

}
