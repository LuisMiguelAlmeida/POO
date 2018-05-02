package poo;
import java.util.*;

public class PEC {
	
	ArrayList<Event> list;
	
	public void addEvPEC(Event ev) {
		
		double time;
		time=ev.time;
		Event dummy;
		if(this.list.isEmpty()) {
			this.list.add(ev);
		}
		else {
			for(int i=0; i<this.list.size(); i++) {
				dummy=this.list.get(i);
				if(time<dummy.time) {
					this.list.add(i, ev);
					break;
				}
				else if(i==(this.list.size()-1)) {
					this.list.add(ev);
				}
			}
		}
	}
	
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

}
