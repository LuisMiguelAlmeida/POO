package poo;

public class EvDeath extends Event {
	
	//construtor
	EvDeath(double T, Child S){
		super(T, S);
	}
	
	//função para simular a morte do individuo associado ao evento
	/**
	 * Funcao que simula o evento de Morte do objecto Child associado a este objecto
	 * @param grid Grid para acesso de parametros do problema
	 * @return tempo associado ao evento a ser simulado
	 */
	public double simulate(Grid grid) {
		Child child = this.subject;
		if(child.death) {
			return(this.time);
		}
		grid.pec.delete(child);
		child.death=true;
		for(int i=0; i<grid.children.size(); i++) {
			if(grid.children.get(i)==child) {
				grid.children.remove(i);
			}
		}
		grid.nevents++;
		return(this.time);
	}

}
