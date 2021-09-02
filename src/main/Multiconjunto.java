package main;

import java.util.ArrayList;

public class Multiconjunto {
	// T -> 3
	// T2 -> 1
	//.
	//.
	private ArrayList<Tupla<Integer, Integer>> elementos;
	// Irep:
	// Elementos admite repetidos
	// El orden de elementos no esta garantizado, puede ser arbitrario
	
	public Multiconjunto() {
		elementos = new ArrayList<>();
	}
	//O(n)
	public void agregar(Integer i) {
		for(Tupla<Integer, Integer> t: elementos) {
			if(t.getX() == i) {
				t.setY(t.getY() + 1);
				return;
			}
		}
		Tupla<Integer, Integer> t = new Tupla<Integer, Integer>(i, 1);
		elementos.add(t);
	}
	//O(n)
	// (1,1), (4,1), (5, 7) -> 3
	// -> 9
	public Integer size() {
		int cont = 0;
		for(Tupla<Integer, Integer> t: elementos)
			cont = cont + t.getY();
		return cont;
	}
	//O(n)
	public Integer pertenece(Integer elem) {
		for(Tupla<Integer, Integer> t: elementos) {
			if(t.getX() == elem)
				return t.getY();
		}
		return 0;
	}

}
