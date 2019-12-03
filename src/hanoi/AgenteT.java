package hanoi;

import java.util.List;

import agentesolitario.AgenteSolitario;
import mundosolitario.OverrideHashCode;

public class AgenteT extends AgenteSolitario<Torres> {

	private int iter;
	
	protected AgenteT(Torres t) {
		super(t);
		iter = 0;
	}
	
	public int getIter() {
		return iter;
	}

	@Override
	public boolean esFinal(Torres t) {
		
//		t.ver();
//		System.out.print("\nSucesores:" + t.calculaSucesores() + "--------------------------------\n");
		
		int auxHeight = t.getHeight();
		List<Integer> auxList = t.getList(3);
		
		if(!t.getList(1).isEmpty() || !t.getList(2).isEmpty())
			return false;
		
		for(int i=auxHeight;i>0;i--) {
			if(i!=auxList.get(auxHeight-i)) {
				return false;
			}
		}
		
		iter++;
		return true;
	}
	
	@Override
	public int h(Torres t) {
		List<Integer> aux = t.getList(3);
		int auxH = t.getHeight();
		int res = 0;
		for(int i=0;i<auxH;i++) {
			res += aux.get(i);
		}
		return res;
	}
	
}