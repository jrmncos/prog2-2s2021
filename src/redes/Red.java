package redes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public abstract class Red<U extends Usuario>{
	// Usuario -> { P1, ... Pn } Usuario
	private HashMap<U, HashSet<U>> red;
	
	
	
	// Martin -> "German, Adriana, Daniel, Jose"
	// German -> "Martin" //Valido en FB
	// .
	// .
	// Adriana -> "Martin,.."

	public Red() {
		red = new HashMap<>();
	}
	
	public void agregarRelacion(U p1, U p2) {
		if(red.containsKey(p1))
			red.get(p1).add(p2);
		else {
			HashSet<U> amigos = new HashSet<>();
			amigos.add(p2);
			red.put(p1, amigos);
		}
	}

	public boolean esAmigo(U p1, U p2) {
		if(red.containsKey(p1)) {
			return amigos(p1).contains(p2);
		}
		return false;	
	}

	public HashSet<U> amigos(U p1) {
		return red.get(p1);
	}
	
	//Ejemplo metodo generico
	public <T> String conc(List<T> list) {
		String conc = "";
		for(T l: list) {
			conc = conc + l.toString();
		}
		
		return conc;
	}
	
	//Ejemplo metodo generico
	public <N extends Number> String conc2(List<N> list) {
		String conc = "";
		for(N l: list) {
			conc = conc + l.toString();
		}
		
		return conc;
	}
	
	public String conc3(List<Number> list) {
		String conc = "";
		for(Number l: list) {
			conc = conc + l.toString();
		}
		
		return conc;
	}
	
}
