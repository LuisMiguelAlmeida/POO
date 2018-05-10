package poo;
import java.util.*;

public class PEC implements Pec{
	
	ArrayList<Event> list;
	
	PEC(){
		list=new ArrayList<Event>();
	}
	
	/**
	 * Funcao que adiciona um evento ao objeto PEC por ordem cronol�gica
	 * @param ev Objeto Evento a ser adicionado ao objeto PEC
	 */
	public void addEvPEC(Event ev) 
	{
		
		double time;
		time=ev.time;
		Event dummy;
		// Se o PEC estiver vazio então adiciona no inicio da lista
		if(this.list.isEmpty()) {
			this.list.add(ev);
		}
		// Caso contrario vai procurar o evento que tem um tempo maior que o seu
		// de forma a inserido antes deste evento na lista
		else 
		{
			// Vai inserir o novo evento antes de um evento com um tempo de simulação superior
			for(int i=0; i<this.list.size(); i++)
			{
				dummy=this.list.get(i);
				if(time<dummy.time) {
					this.list.add(i, ev);
					break;
				}
				else if(i==this.list.size()-1) {
					this.list.add(ev);
					break;
				}
			}
		}
	}
	// Retorna o primeiro evento a ser simulado
	/**
	 * Funcao que remove o primeiro evento da PEC
	 * @return Retorna o evento retirado da PEC para que este possa ser simulado
	 */
	public Event nextEvPEC() {
		
		if(this.list.isEmpty()) {
			return(null);
		}
		else {
			Event ev;
			ev=this.list.get(0);
			this.list.remove(0);
			
			return(ev);
		}
	}
	
	public void delete(Child target) {
		for(int i=0; i<this.list.size(); i++) {
			if(this.list.get(i).subject==target) {
				this.list.remove(i);
			}
		}
	}

}
