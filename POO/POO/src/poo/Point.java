package poo;

public class Point {
	// Coordinates of a Point
	int x;
	int y;
	
	Point(int _x, int _y)
	{
		x=_x;
		y=_y;
	}
	
	@Override
	public int hashCode() {
		int prime = 32452837;
		int result = (this.y*prime) + this.x;
		return result;
	}
	
	public boolean equals(Object arg0) {
		if (this == arg0)
			return true;
		if (arg0 == null)
			return false;
		if (!(arg0 instanceof Point))
			return false;
		Point other = (Point) arg0;
		if(this.x==other.x && this.y==other.y) {
			return(true);
		}
		else {
			return(false);
		}
	}

}
