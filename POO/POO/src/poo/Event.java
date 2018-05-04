package poo;

public abstract class Event {
	
	double time; // Tempo em que o evento vai ocorrer
	
	public abstract void simulate(Child child, Grid grid);

}
