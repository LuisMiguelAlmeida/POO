package poo;
import java.util.*;

public class EvMove extends Event {

	public void simulate(Child child, Grid grid) {
		//options: 0-mover para direita; 1-mover para esquerda; 2- mover para cima; 3-mover para baixo
		int[] options = new int[4];
		int possib=0;
		for(int i=0; i<4; i++) {
			options[i]=1;
		}
		Point point;
		point=child.path.get(child.path.size()-1);
		if(point.x==grid.col) {
			options[0]=0;
		}
		else if(point.x==1) {
			options[1]=0;
		}
		if(point.y==grid.rows) {
			options[2]=0;
		}
		else if(point.y==1) {
			options[3]=0;
		}
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
					}
					else if(i==1) {
						newpoint.x = newpoint.x - 1;
					}
					else if(i==2) {
						newpoint.y=newpoint.y + 1;
					}
					else if(i==3) {
						newpoint.y= newpoint.y - 1;
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
