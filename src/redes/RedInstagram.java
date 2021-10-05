package redes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RedInstagram extends Red{
	private Map<String, Set<String>> mejoresAmigos;
	
	public RedInstagram() {
		super();
		mejoresAmigos = new HashMap<>();
	}
	
	public void agregarMejoresAmigos(String p1, String p2) {
		if(mejoresAmigos.containsKey(p1))
			mejoresAmigos.get(p1).add(p2);
		else {
			HashSet<String> amigos = new HashSet<>();
			amigos.add(p2);
			mejoresAmigos.put(p1, amigos);
		}
	}
}
