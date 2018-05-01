package poo;
import java.util.*;

public class Grid {
	
	int n, m; // Grid dimension
	Point initial_point;
	Point final_point;
	int n_obstacles; // Numero de obstaculos
	Point[] obstacles; // Vetor de obtaculos
	ArrayList<Tupple> tupples; // Lista de tupples
	int maxc;
	int final_instant;
	int k;
	int v;
	int v_max;
	int delta;
	int ro;
	int mew;
	
	// Constructor
	Grid(int _n, int _m, Point _i, Point _f, int n_o, Point[] obst )
	{
		n=_n;
		m=_m;
		initial_point=_i;
	    final_point= _f;
		n_obstacles=n_o;
		obstacles=obst;
		tupples=null;
	}
}
