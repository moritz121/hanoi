package hanoi;

import java.util.ArrayList;
import java.util.List;

import mundosolitario.OverrideHashCode;
import mundosolitario.RepresentacionEstadoOptimizacion;

public class Torres extends OverrideHashCode implements RepresentacionEstadoOptimizacion<Torres> {
	
	private int height;
	private List<Integer> tower1;
	private List<Integer> tower2;
	private List<Integer> tower3;
	
	public Torres() {
		this.height = 8;
		this.tower1 = new ArrayList<Integer>();
		this.tower2 = new ArrayList<Integer>();
		this.tower3 = new ArrayList<Integer>();
		
		for(int i=height;i>0;i--) {
			this.tower1.add(i);
		}
		
	}
	
	public Torres(int height) {
		this.height = height;
		this.tower1 = new ArrayList<Integer>();
		this.tower2 = new ArrayList<Integer>();
		this.tower3 = new ArrayList<Integer>();
		
		for(int i=height;i>0;i--) {
			this.tower1.add(i);
		}
		
	}
	
	public Torres(int height, List<Integer> tower1, List<Integer> tower2, List<Integer> tower3) {
		this.height = height;
		this.tower1 = new ArrayList<Integer>(tower1);
		this.tower2 = new ArrayList<Integer>(tower2);
		this.tower3 = new ArrayList<Integer>(tower3);
	}
	
	@Override
	public List<Torres> calculaSucesores() {
		
		List<Torres> sucesores = new ArrayList<Torres>();
		List<Integer> aux1 = new ArrayList<Integer>();
		List<Integer> aux2 = new ArrayList<Integer>();
		int auxHeight;
		
		if(!(this.tower1 == null)) {
			if(!this.tower1.isEmpty()) {	
				aux1 = new ArrayList<Integer>(this.tower1);
				if(this.tower2 == null) {
					aux2 = new ArrayList<Integer>();
				} else {
					aux2 = new ArrayList<Integer>(this.tower2);
				}
				auxHeight = aux1.size() -1;
				aux2.add(aux1.get(auxHeight));
				aux1.remove(auxHeight);
				sucesores.add(new Torres(auxHeight, aux1, aux2, this.tower3));
			}
		}
		
		if(!(this.tower2 == null)) {
			if(!this.tower2.isEmpty()) {
				// Option2
				aux1 = new ArrayList<Integer>(this.tower2);
				if(this.tower3 == null) {
					aux2 = new ArrayList<Integer>();
				} else {
					aux2 = new ArrayList<Integer>(this.tower3);
				}
				auxHeight = aux1.size() -1;
				aux2.add(aux1.get(auxHeight));
				aux1.remove(auxHeight);
				sucesores.add(new Torres(auxHeight, this.tower1, aux1, aux2));
				
				// Option1
				aux1 = new ArrayList<Integer>(this.tower2);
				if(this.tower1 == null) {
					aux2 = new ArrayList<Integer>();
				} else {
					aux2 = new ArrayList<Integer>(this.tower1);
				}
				auxHeight = aux1.size() -1;
				aux2.add(aux1.get(auxHeight));
				aux1.remove(auxHeight);
				sucesores.add(new Torres(auxHeight, aux2, aux1, this.tower3));
				
			}
		}
		
		if(!(this.tower3 == null)) {
			if(!this.tower3.isEmpty()) {
				aux1 = new ArrayList<Integer>(this.tower3);
				if(this.tower2 == null) {
					aux2 = new ArrayList<Integer>();
				} else {
					aux2 = new ArrayList<Integer>(this.tower2);
				}
				auxHeight = aux1.size() -1;
				aux2.add(aux1.get(auxHeight));
				aux1.remove(auxHeight);
				sucesores.add(new Torres(auxHeight, this.tower1, aux2, aux1));
			}
		}
		
		return sucesores;
		
	}
	
	// Gets
	
	public int getHeight() {
		return this.height;
	}
	
	public List<Integer> getList(int i) {
		if(i==1) {
			return this.tower1;
		} else if(i==2) {
			return this.tower2;
		} else {
			return this.tower3;
		}
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj == null) {
			return false;
		}
		if(this == obj) {
			return true;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		
		Torres aux = (Torres) obj;
		
		if(!(this.tower1 == null)) {
			if(!this.tower1.equals(aux.tower1))
				return false;
		} else {
			if(!(aux == null))
				return false;
		}
		
		if(!(this.tower2 == null)) {
			if(!this.tower2.equals(aux.tower2))
				return false;
		} else {
			if(!(aux == null))
				return false;
		}
		
		if(!(this.tower3 == null)) {
			if(!this.tower3.equals(aux.tower3))
				return false;
		} else {
			if(!(aux == null))
				return false;
		}
		
		this.ver();
		
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int hash = 1;
		hash = prime * hash + this.height + ((this.tower1 == null) ? 0 : this.tower1.hashCode()) + ((this.tower2 == null) ? 0 : this.tower2.hashCode()) + ((this.tower3 == null) ? 0 : this.tower3.hashCode());
		return hash;
	}

	@Override
	public int costeArco(Torres eDestino) {
		// TODO Auto-generated method stub
		return 1;
	}
	
	public void ver() {
		System.out.print(this.toString());
	}
	
	public String toString() {
		return "Estado:\nPrimera torre: " + this.tower1 + "\nSegunda torre: " + this.tower2 + "\nTercera torre: " + this.tower3 + "\nFin de estado\n";	
	}
	
}