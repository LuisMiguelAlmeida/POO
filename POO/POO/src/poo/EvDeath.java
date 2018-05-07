package poo;

public class EvDeath extends Event {
	
	//construtor
	EvDeath(double T, Child S){
		super(T, S);
	}
	
	//função para simular a morte do individuo associado ao evento
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
