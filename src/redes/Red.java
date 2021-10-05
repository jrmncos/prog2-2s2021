package redes;

import java.util.HashMap;
import java.util.HashSet;

public abstract class Red<T extends Usuario>{
	// Usuario -> { P1, ... Pn } Usuario
	private HashMap<T, HashSet<T>> red;

	public Red() {
		red = new HashMap<>();
	}
	
	public void agregarRelacion(T p1, T p2) {
		if(red.containsKey(p1))
			red.get(p1).add(p2);
		else {
			HashSet<T> amigos = new HashSet<>();
			amigos.add(p2);
			red.put(p1, amigos);
		}
	}

	public boolean esAmigo(T p1, T p2) {
		if(red.containsKey(p1)) {
			return amigos(p1).contains(p2);
		}
		return false;	
	}

	public HashSet<T> amigos(T p1) {
		return red.get(p1);
	}
	
}
