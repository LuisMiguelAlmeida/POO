package poo;

public class Point {
	

	// Coordinates of a Point
	protected int x;
	protected int y;
	
	Point(int _x, int _y)
	{
		x=_x;
		y=_y;
	}
	
	
	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
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
