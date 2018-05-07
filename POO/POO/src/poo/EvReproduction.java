package poo;
import java.util.*;

public class EvReproduction extends Event {
	
	EvReproduction(double T, Child S){
		super(T, S);
	}

	public void simulate(Grid grid) {
		Child child = this.subject;
		if(child.death) {
			return;
		}
		Child newchild;
		newchild = new Child(grid);
		double newpathsize;
		newpathsize = child.path.size();
		Random rand;
		rand = new Random();
		int percentage;
		percentage = rand.nextInt(10) + 1;
		newpathsize = newpathsize * (0.9 + (percentage/100));
		for(int i=0; i<newpathsize; i ++) {
			newchild.add_point(child.path.get(i));
		}
		newchild.change_comfort(child.path.get(child.path.size() - 1));
		grid.add_child(newchild);
		
	}
}
