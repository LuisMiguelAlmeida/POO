package poo;

public abstract class Event {
	
	double time; // Tempo em que o evento vai ocorrer
	Child subject;
	
	Event(double T, Child S){
		this.time=T;
		this.subject=S;
	}
	
	public abstract double simulate(Grid grid);

}
