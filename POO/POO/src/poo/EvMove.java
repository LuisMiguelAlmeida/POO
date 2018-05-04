package poo;
import java.util.*;

public class EvMove extends Event {

	public void simulate(Child child, Grid grid) {
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
		Random rand = new Random();
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
		child.path.add(newpoint);
	}
}
