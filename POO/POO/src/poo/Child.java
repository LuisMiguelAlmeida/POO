package poo;
import java.util.*;
public class Child {

	double comfort;
	ArrayList<Point> path;
	int length;
	int cost;
	Grid grid;
	
	Child(Grid A){
		comfort=0;
		length=0;
		path=null;
		grid=A;
		cost=0;
	}
	
	int dist(Point A) {
		int x_dist;
		int y_dist;
		int result;
		
		x_dist=Math.abs(A.x - this.grid.final_point.x);
		y_dist=Math.abs(A.y - this.grid.final_point.y);
		result=y_dist+x_dist;
		return(result);
	}
	
	void change_comfort(Point A){
		this.comfort=(((1- ( (this.cost-this.length+2) / ((this.grid.maxc - 1)*this.length+3) ) )^grid.k) *  ((1- ( (dist(A)) / (grid.n+grid.m+1) ) )^grid.k));
	}
	
	// criar as funçõespara adicionar a lista do path, remover, etc.
	
	void add_point(Point A) {
		if(path==null) {
			path= new ArrayList<Point>();
		}
		this.path.add(A);
		this.length=this.length + 1;
		
		Point orig;
		int size;
		size=path.size();
		orig=path.get(size-1);
		Tupple T;
		T= new Tupple(0, A, orig);
		
		if(this.grid.tupples.contains(T)) {
			int index = this.grid.tupples.indexOf(T);
			Tupple exists = this.grid.tupples.get(index);
			this.cost=this.cost + exists.cost;
		}
		else {
			this.cost=this.cost+1;
		}
		change_comfort(A);
	}
	
	
}
