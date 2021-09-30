package redes;

import java.util.HashMap;
import java.util.HashSet;

public abstract class Red{
	// Persona -> { P1, ... Pn } amigos
	private HashMap<String, HashSet<String>> red;

	public Red() {
		red = new HashMap<>();
	}
	
	public void agregarRelacion(String p1, String p2) {
		if(red.containsKey(p1))
			red.get(p1).add(p2);
		else {
			HashSet<String> amigos = new HashSet<>();
			amigos.add(p2);
			red.put(p1, amigos);
		}
	}

	public boolean esAmigo(String p1, String p2) {
		if(red.containsKey(p1)) {
			return amigos(p1).contains(p2);
		}
		return false;	
	}

	public HashSet<String> amigos(String p1) {
		return red.get(p1);
	}

}
