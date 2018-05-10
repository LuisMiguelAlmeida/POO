package poo;

public abstract class Event implements Events{
	
	double time; // Tempo em que o evento vai ocorrer
	Child subject; // Child sobre a qual vai ser invocado o evento
	
	Event(double T, Child S){
		this.time=T;
		this.subject=S;
	}
	
	public abstract double simulate(Grid grid);

}
