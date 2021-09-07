package main;

import java.util.HashMap;
import java.util.LinkedList;

public class Multiconjunto<T> {
	// T -> 3
	// T2 -> 1
	//.
	//.
	// { (T,2), (T,4), (T,1)..... }
	//private LinkedList<Tupla<T, Integer>> elementos;
	
	private HashMap<T, Integer> elementos;
	private Integer size;
	// T -> 2
	// T -> 10
	// .
	// .
	// T -> 1
	
	// Irep:
	// Elementos admite repetidos
	// El orden de elementos no esta garantizado, puede ser arbitrario
	
	public Multiconjunto() {
		elementos = new HashMap<>();
		size = 0;
	}
	//O(n)
//	public void agregar(T elem) {
//		for(Tupla<T, Integer> t: elementos) {
//			if(t.getX().equals(elem)) {
//				t.setY(t.getY() + 1);
//				return;
//			}
//		}
//		Tupla<T, Integer> t = new Tupla<T, Integer>(elem, 1);
//		elementos.add(t);
//	}
	/*
	 * "Hola" -> 3
	 * "Ungs" -> 1
	 * 
	 * 
	 */
	//O(1)
	public void agregar(T elem) {
		if(elementos.containsKey(elem)) {
			Integer cantidadApariciones = elementos.get(elem);
			elementos.put(elem, cantidadApariciones + 1);
		}
		else {
			elementos.put(elem, 1);
		}
		//elementos.put(elem, elementos.getOrDefault(elem, 0) + 1);
		size = size + 1;
	}
	
	//O(n)
	// ("Hola",1), ("Adios",1), ("UNGS", 7) -> 3
	// -> 9
//	public Integer size() {
//		int cont = 0;
//		for(Tupla<T, Integer> t: elementos)
//			cont = cont + t.getY();
//		return cont;
//	}
	
	// T1 -> 2
	// T2 -> 10
	// .
	// .
	// Tn -> 1
	//O(1)
	public Integer size() {
		return size;
	}
	
	//O(n)
//	public Integer obtener(T elem) {
//		for(Tupla<T, Integer> t: elementos) {
//			if(t.getX().equals(elem))
//				return t.getY();
//		}
//		return 0;
//	}
	
	//O(1)
	public Integer obtener(T elem) {
//		if(elementos.containsKey(elem)) {
//			return elementos.get(elem);
//		}
//		else {
//			return 0;
//		}
		return elementos.getOrDefault(elem, 0);
	}
	
	@Override
	public String toString() {
		return "Multiconjunto [elementos=" + elementos + "]";
	}
	
}
