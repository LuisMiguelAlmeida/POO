package poo;

public class Tupple {
	
	int cost;
	Point point_A;
	Point point_B;
	Tupple next;
	
	Tupple(int c, Point A, Point B){
		this.cost=c;
		this.point_A=A;
		this.point_B=B;
		this.next=null;
	}

	
	public boolean equals(Tupple arg0) {
		if((this.point_A==arg0.point_A || this.point_A==arg0.point_B) && (this.point_B==arg0.point_A || this.point_B==arg0.point_B)) {
			return(true);
		}
		else {
			return(false);
		}
	}

	//fazer este override
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	

}
