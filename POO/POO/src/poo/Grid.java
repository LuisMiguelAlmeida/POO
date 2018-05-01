package poo;

public class Grid {
	
	int n, m; // Grid dimension
	Point initial_point;
	Point final_point;
	int n_obstacles; // Numero de obstaculos
	Point[] obstacles; // Vetor de obtaculos
	
	// Constructor
	Grid(int _n, int _m, Point _i, Point _f, int n_o, Point[] obst )
	{
		n=_n;
		m=_m;
		initial_point=_i;
	    final_point= _f;
		n_obstacles=n_o;
		obstacles=obst;
	}
}
