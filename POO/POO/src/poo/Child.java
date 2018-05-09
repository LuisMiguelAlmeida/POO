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
	 * @param A Ponto a partir do qual é calculadaa distância
	 * @return result Distância entre o ponto A eo ponto de destino
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
	 * Calcula o tamanho do percurso da Child sobre a qual é invocado e atualiza o
	 * parâmetro length.
	 */
	void path_length()
	{
		int array_lenght= this.path.size();
		this.length=array_lenght-1;
	}
	
	// Conforto do individuo
	/**
	 * Função que altera o conforto da Child sobre a qual é invocado, atualizando o parâmetro
	 * comfort
	 * @param A Último ponto do caminho da Child a que se quer atualizar o conforto
	 */
	void change_comfort(Point A){
		this.comfort= Math.pow( (1-( (this.cost-this.length+2) / ((this.grid.maxc - 1)*this.length+3))), grid.k) *  Math.pow( 1-(dist(A)) / (grid.rows+grid.col+1), grid.k);
	}
	
	/**
	 * Função que remove um ponto da lista path da Child sobre a qual é invocado,
	 * fazendo as alterações necessárias aos parâmetros cost, comfort e length
	 * @param A Ponto a ser removido
	 */
	void remove_point(Point A) 
	{
		this.path.remove(A);
		this.length=this.length - 1;
		
		Point orig;
		int size;
		size=path.size();
		orig=path.get(size-1);
    	Tupple T;
		T= new Tupple(0, A, orig);
		
		this.cost -= this.grid.moveCost(T);
		change_comfort(A); // Atualiza o comforto do individuo
		
	}
	
	//Alterar o add para ter em conta o ciclo
	/**
	 * Função que adiciona um ponto à lista path da Child sobre a qual é invocado,
	 * fazendo as alterações necessárias aos parâmetros cost, comfort e length
	 * @param A Ponto a ser adicionado
	 */
	void add_point(Point A) {
		
		// Se nÃ£o houver nenhum caminho, entÃ£o cria-se um novo array
		if(path==null)
		{
			path= new ArrayList<Point>();
		}
		// Se encontrarmos um ciclo no percurso, elimina-se todos os pontos que pertencem a este
		if(this.path.contains(A)) 
		{
			int index = this.path.indexOf(A);
			int size = this.path.size();
			Point P;
			for(int i=index+1; i<size; i++)
			{
				P=this.path.get(i);
				this.remove_point(P);
			}
			
		}
		else 
		{
			// Adiciona um novo ponto ao caminho do individuo
			this.path.add(A);
			this.length=this.length + 1;
			
			Point orig;
			int size;
			size=path.size();
			orig=path.get(size-1);
			Tupple T;
			T= new Tupple(0, A, orig);
			
			// Ve se o novo caminho do individuo contem zonas especiais 
			this.cost += this.grid.moveCost(T);
				
		}
		change_comfort(A); // Atualiza o comforto do individuo
	}
	

	
	
}
