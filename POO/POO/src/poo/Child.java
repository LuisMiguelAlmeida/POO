package poo;

import java.util.*;

public class Child {

	double comfort;
	ArrayList<Point> path;// Lista de pontos com o caminho percorrido pelo child
	int length;
	int cost;
	boolean death;
	Grid grid;
	
	
	// Constructor
	Child(Grid A){
		comfort=0;
		length=0;
		path=null;
//		event=null;
		grid=A;
		cost=0;
		death=false;
	}
	
	// Calcula a distancia entre o ultimo ponto do caminho e ponto final da rede
	/**
	 * 
	 * Calcula a distancia entre o ponto A e o ponto de destino do problema em questao
	 * @param A Ponto a partir do qual e calculadaa distancia
	 * @return result Distancia entre o ponto A eo ponto de destino
	 */
	int dist(Point A) {
		int x_dist;
		int y_dist;
		int result;
		
		x_dist=Math.abs(A.x - this.grid.final_point.x);
		y_dist=Math.abs(A.y - this.grid.final_point.y);
		result=y_dist+x_dist;
		return(result);
	}
	
	// Calcula o tamanho do percurso do individuo (numero de pontos -1 = numero de arestas)
	/**
	 * Calcula o tamanho do percurso da Child sobre a qual e invocado e atualiza o
	 * parametro length.
	 */
	void path_length()
	{
		int array_lenght= this.path.size();
		this.length=array_lenght-1;
	}
	
	// Conforto do individuo
	/**
	 * Funcao que altera o conforto da Child sobre a qual e invocado, atualizando o parametro
	 * comfort
	 * @param A ultimo ponto do caminho da Child a que se quer atualizar o conforto
	 */
	void change_comfort(Point A){
		double first_term = this.grid.maxc - 1;
		first_term=first_term*this.length;
		first_term=first_term+3;
		first_term=(this.cost-this.length + 2)/first_term;
		first_term=1-first_term;
		first_term=Math.pow(first_term, grid.k);
		double second_term = grid.rows+grid.col+1;
		second_term = dist(A)/second_term;
		second_term = 1-second_term;
		second_term= Math.pow(second_term, grid.k);
		this.comfort=first_term*second_term;
		if(this.death) {
			System.out.println("DEAD!!!");
		}
		System.out.println("COST: " + this.cost);
		System.out.println("Length: " + this.length + "\n");
		
	}
	
	/**
	 * Funcao que remove um ponto da lista path da Child sobre a qual e invocado,
	 * fazendo as alteracoeses necessarias aos parametros cost, comfort e length
	 * @param A Ponto a ser removido
	 */
	void remove_point(Point A) 
	{
		Point orig;
		int origindex;
		origindex=this.path.indexOf(A);
		origindex--;
		System.out.println("REMOVE SECOND :" + origindex);
		orig=this.path.get(origindex);
		this.length=this.length - 1;
    	Tupple T;
		T= new Tupple(0, A, orig);
		
		this.cost -= this.grid.moveCost(T);
		this.path.remove(A);
		
	}
	
	//Alterar o add para ter em conta o ciclo
	/**
	 * Funcao que adiciona um ponto a lista path da Child sobre a qual e invocado,
	 * fazendo as alteracoes necessarias aos parametros cost, comfort e length
	 * @param A Ponto a ser adicionado
	 */
	void add_point(Point A) {
		
		// Se não houver nenhum caminho, então cria-se um novo array
		if(path==null)
		{
			path= new ArrayList<Point>();
		}
		// Se encontrarmos um ciclo no percurso, elimina-se todos os pontos que pertencem a este
		if(this.path.contains(A)) 
		{
			System.out.println("PONTO REPETIDO");
			int index = this.path.indexOf(A);
			int remove;
			while(index+1<this.path.size())
			{
				remove=this.path.size();
				remove--;
				System.out.println("REMOVE ONE :" + remove);
				this.remove_point(this.path.get(remove));
			}
			
		}
		else 
		{
			// Adiciona um novo ponto ao caminho do individuo
			int size=this.path.size();
			size--;
			this.path.add(A);
			if(this.path.size()==1) {
				System.out.println("BEING BORN!!");
			}
			
			Point orig;
			if(this.path.size()>1)
			{
				this.length=this.length + 1;
				orig=path.get(size);
				Tupple T;
				T= new Tupple(0, A, orig);
				
				// Ve se o novo caminho do individuo contem zonas especiais 
				this.cost += this.grid.moveCost(T);
			}				
		}
		change_comfort(A); // Atualiza o comforto do individuo
	}
	

	
	
}
