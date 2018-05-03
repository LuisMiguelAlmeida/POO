package poo;

public abstract class Event {
	
	double time;
	
	public abstract void simulate(Child child, Grid grid);

}
