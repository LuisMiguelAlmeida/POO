package poo;

public class Grid {
	
	protected int rows, col; // Grid dimension 
	protected Point initial_point; // Ponto inicial onde são colocados todos os individuos
	protected Point final_point; // Ponto final
	protected int n_obstacles; // Numero de obstaculos
	protected Point[] obstacles; // Vetor de obtaculos
	protected int n_tupples;
	protected Tupple[] tupples; // Vetor de tupples
	protected int maxc;// Custo máximo de uma aresta na rede
	protected int final_instant; //Instante final da simulação???
	protected int k;// Max confort
	protected int v;// initial population
	protected int v_max; // Maximum population
	protected int delta; // mean value do movimento (move) 
	protected int ro;	// mean value da reprodução
	protected int mew;	// mean value da morte (death)
	
	//Contructor inicializa tudo a zero ()
	Grid(){
		rows=0;col=0;
		initial_point = new Point(0,0);
		final_point=new Point(0,0);
		n_obstacles=0;
		maxc=0;n_tupples=0;
		final_instant=0;
		k=0;v=0;v_max=0;delta=0;ro=0;mew=0;
	}
	// Getters and setters
	public int getrows() {
		return rows;
	}
	public void setrows(int rows) {
		this.rows = rows;
	}
	public int getcol() {
		return col;
	}
	public void setcol(int col) {
		this.col = col;
	}
	public Point getInitial_point() {
		return initial_point;
	}
	public void setInitial_point(Point initial_point) {
		this.initial_point = initial_point;
	}
	public Point getFinal_point() {
		return final_point;
	}
	public void setFinal_point(Point final_point) {
		this.final_point = final_point;
	}
	public int getN_obstacles() {
		return n_obstacles;
	}
	public void setN_obstacles(int n_obstacles) {
		this.n_obstacles = n_obstacles;
	}
	public Point[] getObstacles() {
		return obstacles;
	}
	public void setObstacles(Point[] obstacles) {
		this.obstacles = obstacles;
	}
	public void put1obstacle(Point point, int index) {
		this.obstacles[index]=point;
	}
	public Tupple[] getTupples() {
		return tupples;
	}
	public void setTupples(Tupple[] tupples) {
		this.tupples = tupples;
	}
	public void setzone(Point initial, Point finale, int cost,int index) {
		this.tupples[index] = new Tupple(cost, initial, finale);
	}
	public void create_Array_Tupples(int size) {
		this.tupples = new Tupple[size];
	}
	public int getMaxc() {
		return maxc;
	}
	public void setMaxc(int maxc) {
		this.maxc = maxc;
	}
	public int getFinal_instant() {
		return final_instant;
	}
	public void setFinal_instant(int final_instant) {
		this.final_instant = final_instant;
	}
	public int getK() {
		return k;
	}
	public void setK(int k) {
		this.k = k;
	}
	public int getV() {
		return v;
	}
	public void setV(int v) {
		this.v = v;
	}
	public int getV_max() {
		return v_max;
	}
	public void setV_max(int v_max) {
		this.v_max = v_max;
	}
	public int getDelta() {
		return delta;
	}
	public void setDelta(int delta) {
		this.delta = delta;
	}
	public int getRo() {
		return ro;
	}
	public void setRo(int ro) {
		this.ro = ro;
	}
	public int getMew() {
		return mew;
	}
	public void setMew(int mew) {
		this.mew = mew;
	}
	
	
}
