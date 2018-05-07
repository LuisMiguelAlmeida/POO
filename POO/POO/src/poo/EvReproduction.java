package poo;
import java.util.*;

public class EvReproduction extends Event {
	
	static Random rand = new Random();
	
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
		int percentage;
		percentage = rand.nextInt(10) + 1;
		newpathsize = newpathsize * (0.9 + (percentage/100));
		for(int i=0; i<newpathsize; i ++) {
			newchild.add_point(child.path.get(i));
		}
		newchild.change_comfort(child.path.get(child.path.size() - 1));
		grid.add_child(newchild);
		double addtime = grid.expRandom((1-Math.log(newchild.comfort)) * grid.delta);
		EvMove newmove = new EvMove(grid.currtime + addtime, newchild);
		grid.pec.addEvPEC(newmove);
		addtime = grid.expRandom((1-Math.log(1 - child.comfort)) * grid.mew);
		EvDeath newdeath = new EvDeath(grid.currtime + addtime, child);
		grid.pec.addEvPEC(newdeath);
		addtime = grid.expRandom((1-Math.log(newchild.comfort)) * grid.ro);
		EvReproduction newreproduction1 = new EvReproduction(grid.currtime + addtime, newchild);
		grid.pec.addEvPEC(newreproduction1);
		addtime = grid.expRandom((1-Math.log(child.comfort)) * grid.ro);
		EvReproduction newreproduction2 = new EvReproduction(grid.currtime + addtime, child);
		grid.pec.addEvPEC(newreproduction2);
		grid.nevents++;
		
		
	}
}
