package hanoi;

import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		
		int testHeight = 8;
		// int testHeight = 8;
		
		Torres t = new Torres(testHeight);
		AgenteT ag = new AgenteT(t);
		
		
		List<Torres> solution = ag.amplitud();
		
		try {
			for(Torres auxT : solution) {
				auxT.ver();
			}
			System.out.print("\nIteraciones: " + ag.getIter());
			System.out.print("\nProfundidad: " + (solution.size() - 1));
			System.out.print("\nDone");
		} catch (Exception e) {
			System.out.print("Error");
		}
		
	}
	
}