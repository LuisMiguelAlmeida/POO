package poo;
import java.util.*;

public class EvMove extends Event {
	
	static Random rand = new Random();
	
	//construtor
	EvMove(double T, Child S){
		super(T, S);
	}

	//fun��o para simular um movimento do individuo associado ao evento
	/**
	 * Funcao que simula o evento de Movimento do objecto Child associado a este objecto
	 * @param grid Grid para acesso de parametros do problema
	 * @return tempo associado ao evento a ser simulado
	 */
	public double simulate(Grid grid) {
		Child child = this.subject;
		if(child.death) {
			return(this.time);
		}
		//options(index do vetor): 0-mover para direita; 1-mover para esquerda; 2- mover para cima; 3-mover para baixo
		int[] options = new int[4];
		int possib=0;
		for(int i=0; i<4; i++) {
			options[i]=1;
		}
		//Obtem o ultimo ponto do percurso do individuo (onde ele está atualmente)
		Point point;
		point=child.path.get(child.path.size()-1);
		// Impossivel mover-se para a direita (fora da rede)
		if((point.x==grid.col)||(grid.getobs(point.x+1, point.y))) {
			options[0]=0;
		}
		// Impossivel mover-se para a esquerda (fora da rede)
		if((point.x==1)||(grid.getobs(point.x-1, point.y))) {
			options[1]=0;
		}
		// Impossivel mover-se para a cima (fora da rede)
		if((point.y==grid.rows)||(grid.getobs(point.x, point.y+1))) {
			options[2]=0;
		}
		// Impossivel mover-se para a baixo (fora da rede)
		if((point.y==1)||(grid.getobs(point.x, point.y-1))) {
			options[3]=0;
		}
		// Conta o numero de movimentos possiveis
		for(int i=0; i<4; i++) {
			if(options[i]==1) {
				possib++;
			}
		}
		int j = rand.nextInt(possib);
		Point newpoint = new Point(point.x, point.y);
		for(int i=0; i<4; i++) {
			if(j==0) {
				if(options[i]==1) {
					if(i==0) {
						newpoint.x=newpoint.x + 1;
						break;
					}
					else if(i==1) {
						newpoint.x = newpoint.x - 1;
						break;
					}
					else if(i==2) {
						newpoint.y=newpoint.y + 1;
						break;
					}
					else if(i==3) {
						newpoint.y= newpoint.y - 1;
						break;
					}
					
				}
			}
			if(options[i]==1 && j>0) {
				j--;
			}
		}
		child.add_point(newpoint);
		if(newpoint.equals(grid.final_point)) {
			if(grid.bestcost>child.cost || grid.bestcost==0) {
				if(grid.bestpath!=null) {
					grid.bestpath.clear();
				}
				grid.bestpath=null;
				grid.bestpath= new ArrayList<Point>();
				for(int i=0; i<child.path.size(); i++) {
					grid.bestpath.add(child.path.get(i));
				}
				grid.bestcomfort=child.comfort;
				grid.bestcost=child.cost;
			}
			
		}
		
		double m=(1-Math.log(child.comfort)* grid.delta);
		double addtime = grid.expRandom(m);
		EvMove newmove = new EvMove(grid.currtime + addtime, child);
		grid.pec.addEvPEC(newmove);
		grid.nevents++;
		return(this.time);
	}
}
