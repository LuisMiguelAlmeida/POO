package poo;


public class Tupple {
	
	int cost;
	Point point_A;
	Point point_B;
	
	Tupple(int c, Point A, Point B){
		this.cost=c;
		this.point_A=A;
		this.point_B=B;
	}
	
	@Override
	public int hashCode() {
		int A = this.point_A.hashCode();
		int B = this.point_B.hashCode();
		int result = B + A;
		return result;
	}

	
	public boolean equals(Object arg0) {
		if (this == arg0)
			return true;
		if (arg0 == null)
			return false;
		if (!(arg0 instanceof Tupple))
			return false;
		Tupple other = (Tupple) arg0;
		if((this.point_A==other.point_A && this.point_B==other.point_B) || (this.point_B==other.point_A & this.point_A==other.point_B)) {
			return(true);
		}
		else {
			return(false);
		}
	}

	
	

}
