package poo;
import java.util.*;

public class EvReproduction extends Event {
	
	static Random rand = new Random();
	
	// construtor
	EvReproduction(double T, Child S){
		super(T, S);
	}

	//funcao para simular a reproducao do individuo associado ao evento
	/**
	 * Funcao que simula o evento de Reproducao do objecto Child associado a este objecto
	 * e adiciona a nova Child criada a lista children do Objeto Grid que recebe
	 * @param grid Grid para acesso de parametros do problema
	 * @return tempo associado ao evento a ser simulado
	 */
	public double simulate(Grid grid) {
		Child child = this.subject;
		if(child.death) {
			return(this.time);
		}
		Child newchild;
		newchild = new Child(grid);
		double newpathsize;
		newpathsize = child.path.size();
		newpathsize = newpathsize * (0.9 + (child.comfort * 0.1));
		
		for(int i=0; i<Math.ceil(newpathsize); i ++) {
			newchild.add_point(child.path.get(i));
		}
		grid.add_child(newchild);
		double addtime = grid.expRandom((1-Math.log(child.comfort)) * grid.ro);
		EvReproduction newreproduction2 = new EvReproduction(grid.currtime + addtime, child);
		grid.pec.addEvPEC(newreproduction2);
		grid.nevents++;
		if(grid.children.size()>grid.v_max) {
			grid.epidemic();
		}
		return(this.time);
		
	}
}
