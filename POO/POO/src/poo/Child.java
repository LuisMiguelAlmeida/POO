package poo;
public class Child {

	double comfort;
	Point_Node path;
	int length;
	int cost;
	Grid grid;
	
	Child(Grid A){
		comfort=0;
		length=0;
		path=null;
		grid=A
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
		this.comfort=(((1- ( (this.cost-this.length+2) / ((this.grid.cmax - 1)*this.length+3) ) )^grid.k) *  ((1- ( (dist(A)) / (grid.n+grid.m+1) ) )^grid.k));
	}
	
	// criar as funçõespara adicionar a lista do path, remover, etc.
	
	
	
}
