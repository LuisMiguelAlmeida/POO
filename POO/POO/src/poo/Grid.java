package poo;

import java.util.*;

public class Grid {
	
	protected int rows, col; // Grid dimension 
	protected Point initial_point; // Ponto inicial onde sÃ£o colocados todos os individuos
	protected Point final_point; // Ponto final
	protected int n_obstacles; // Numero de obstaculos
	protected Point[] obstacles; // Vetor de obtaculos
	protected int n_tupples;
	protected Tupple[] tupples; // Vetor de tupples
	protected int maxc;// Custo mÃ¡ximo de uma aresta na rede
	protected int final_instant; //Instante final da simulaÃ§Ã£o???
	protected int k;// Max confort
	protected int v;// initial population
	protected int v_max; // Maximum population
	protected int delta; // mean value do movimento (move) 
	protected int ro;	// mean value da reproduÃ§Ã£o
	protected int mew;	// mean value da morte (death)
	double currtime; // tempo corrente da simulaï¿½ï¿½o
	ArrayList<Point> bestpath;// Lista de pontos com o melhor caminho encontrado atï¿½ ao momento
	double bestcomfort; // conforto associado, na altura, ao individuo que atingiu o melhor caminho
	int bestcost; // custo associado ao melhor caminho
	int nevents; // numero de eventos jï¿½ ocorridos
	static Random random = new Random();
	PEC pec;
	protected ArrayList<Child> children; // lista de individuos existentes
	
	//Contructor inicializa tudo a zero ()
	Grid(){
		rows=0;col=0;
		initial_point = new Point(0,0);
		final_point=new Point(0,0);
		n_obstacles=0;
		maxc=1;
		n_tupples=0;
		final_instant=0;
		children=null;
		currtime=0;
		bestcomfort = 0;
		bestcost = 0;
		nevents=0;
		pec= new PEC();
		bestpath=null;
		k=0;v=0;v_max=0;delta=0;ro=0;mew=0;
	}
	
	/**
	 * Função que indica se existe um obstáculo num ponto
	 * @param x Coordenada x do ponto onde se quer verificar a existência de um obstáculo
	 * @param y Coordenada y do ponto onde se quer verificar a existência de um obstáculo
	 * @return Retorna true se existir um obstáculo e false caso contrário
	 */
	public boolean getobs(int x, int y) {
		for(int i=0; i<n_obstacles; i++) {
			if((this.obstacles[i].x == x) && (this.obstacles[i].y == y))
				return true;
		}
		return false;
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
	public int getN_tupples() {
		return n_tupples;
	}
	public void setN_tupples(int n_tupples) {
		this.n_tupples = n_tupples;
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

	//TODO Overlap das zonas especiais
	/**
	 * Função que indica o custo do movimento entre dois pontos
	 * @param T Objeto que contem os dois pontos entre os quais existirá o movimento
	 * @return Retorna o custo do movimento
	 */
	public int moveCost(Tupple T) {
		
		// T -> Ultima aresta percorrida pelo individuo
		 for (int i=0; i<this.n_tupples; i++) 
		 {
			 
			Tupple temp = tupples[i];
			// Verifica se 
			
			// Se a aresta T estiver na mesma coluna que o ponto A
			if(temp.point_A.x ==T.point_A.x && temp.point_A.x ==T.point_B.x ) 
			{
				if(temp.point_A.y >= T.point_A.y && temp.point_A.y >= T.point_B.y && temp.point_B.y <= T.point_A.y && temp.point_B.y <= T.point_B.y  )
					return temp.cost;
				
				if(temp.point_A.y <= T.point_A.y && temp.point_A.y <= T.point_B.y && temp.point_B.y >= T.point_A.y && temp.point_B.y >= T.point_B.y  )
					return temp.cost;
			}
			// Se a aresta T estiver na mesma coluna que o ponto B
			if(temp.point_B.x ==T.point_A.x && temp.point_B.x ==T.point_B.x ) 
			{
				if(temp.point_A.y >= T.point_A.y && temp.point_A.y >= T.point_B.y && temp.point_B.y <= T.point_A.y && temp.point_B.y <= T.point_B.y  )
					return temp.cost;
				
				if(temp.point_A.y <= T.point_A.y && temp.point_A.y <= T.point_B.y && temp.point_B.y >= T.point_A.y && temp.point_B.y >= T.point_B.y  )
					return temp.cost;
			}
			// Se a aresta T estiver na mesma linha que o ponto A
			if(temp.point_A.y==T.point_A.y && temp.point_A.y==T.point_B.y) 
			{
				if(temp.point_A.x >=T.point_A.x && temp.point_A.x >=T.point_B.x && temp.point_B.x <=T.point_A.x && temp.point_B.x <=T.point_B.x)
					return temp.cost;
				
				if(temp.point_A.x <=T.point_A.x && temp.point_A.x <=T.point_B.x && temp.point_B.x >=T.point_A.x && temp.point_B.x >=T.point_B.x)
					return temp.cost;
			}
			
			// Se a aresta T estiver na mesma linha que o ponto B
			if(temp.point_B.y==T.point_A.y && temp.point_B.y==T.point_B.y) 
			{
				if(temp.point_A.x >=T.point_A.x && temp.point_A.x >=T.point_B.x && temp.point_B.x <=T.point_A.x && temp.point_B.x <=T.point_B.x)
					return temp.cost;
				
				if(temp.point_A.x <=T.point_A.x && temp.point_A.x <=T.point_B.x && temp.point_B.x >=T.point_A.x && temp.point_B.x >=T.point_B.x)
					return temp.cost;
			}
			
			 
		 }
		 return 1;
	}
	
	/**
	 * Função que adiciona um Objeto Child à lista children de uma Grid
	 * @param A Objeto Child a adicionar
	 */
	void add_child(Child A) {
		
		// Se nÃ£o houver nenhum individuo, entÃ£o cria-se uma nova Lista
		if(children==null)
		{
			children= new ArrayList<Child>();
		} 
		// Adiciona um novo individuo ï¿½ lista de indivï¿½duos
		this.children.add(A);
		double addtime = this.expRandom((1.0-Math.log10(A.comfort)) * this.delta);
		EvMove newmove = new EvMove(this.currtime + addtime, A);
		this.pec.addEvPEC(newmove);
		addtime = this.expRandom((1.0-Math.log10(1.0 - A.comfort)) * this.mew);
		EvDeath newdeath = new EvDeath(this.currtime + addtime, A);
		this.pec.addEvPEC(newdeath);
		addtime = this.expRandom((1.0-Math.log10(A.comfort)) * this.ro);
		EvReproduction newreproduction1 = new EvReproduction(this.currtime + addtime, A);
		this.pec.addEvPEC(newreproduction1);

	}
	
	/**
	 * Função que remove um Objeto Child à lista children de uma Grid
	 * @param A Objeto Child a remover
	 */
	void remove_child(Child A) {
		 
		// Remove um individuo da lista de individuos existentes
		this.children.remove(A);

	}

	/**
	 * Função que calcula o valor de uma variável aleatória exponencial
	 * @param m Média da variável aleatórioa exponencial
	 * @return Valor aleatório
	 */
	public double expRandom(double m) {
		double next = random.nextDouble();
		return -m*Math.log(1.0-next);
	}
	
	/**
	 * Função que encontra o objeto Child na lista children com maior conforto
	 * @return Retorna o objeto Child com maior conforto
	 */
	Child findbestone() {
		Child best;
		best=this.children.get(0);
		for(int i=0; i<this.children.size(); i++) {
			if(best.comfort<(this.children.get(i)).comfort) {
				best=this.children.get(i);
			}
		}
		return(best);
	}
	
	/**
	 * Função que imprime um caminho para o ecrã
	 * @param bestpath Caminho a imprimir
	 */
	void print_path(ArrayList<Point> bestpath) {
		for(int i=0; i<bestpath.size(); i++) {
			if(i==0) {
				System.out.print("{");
			}
			System.out.print(bestpath.get(i));
			if(i<bestpath.size() - 1) {
				System.out.print(", ");
			}
			if(i==bestpath.size() - 1) {
				System.out.print("}");
			}
		}
	}
	
}
