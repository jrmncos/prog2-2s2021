package main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class EjemplosHashMap {
	
	public static void main(String[] args) {
		//Fiesta de 15
		HashSet<Integer> conjunto = new HashSet<>();
		conjunto.contains(4);
		conjunto.add(4);
		for(Integer elem: conjunto) {
			System.out.println(elem);
		}
		
		HashMap<String, Integer> invitados = new HashMap<>();
		invitados.put("Diego", 1);
		invitados.put("Erik", 1);
		invitados.put("Alejandro", 2);
		
		if(invitados.containsKey("Diego"))
			System.out.println(invitados.get("Diego"));
		
		invitados.put("Diego", 2);
		
		//Tengo un texto, y quiero contar la cantidad de repeticiones de una palabra
		
		String st = "Hola fw visita recorrido ungs campus ungs recorrido hola hola hola";
		
		HashMap<String, Integer> dicc = cantidadRepeticiones(st);
		
		for(String k: dicc.keySet()) {
			System.out.println(k);
		}
		
		for(Integer v: dicc.values()) {
			System.out.println(v);
		}
		
		for(Map.Entry<String, Integer> entry: dicc.entrySet()) {
			System.out.println(entry);
		}
		
	}
	
	public static HashMap<String, Integer> cantidadRepeticiones(String st){
		HashMap<String, Integer> palabraXRepeticion = new HashMap<>();
		String[] palabras = st.split(" ");
		// {Hola, fw, visita, recorrido, ungs, campus, ungs, recorrido, hola, hola hola}
		for(String palabra: palabras) {
			if(palabraXRepeticion.containsKey(palabra)) {
				palabraXRepeticion.put(palabra, palabraXRepeticion.get(palabra) + 1);
			}
			else {
				palabraXRepeticion.put(palabra, 1);
			}
			
			//palabraXRepeticion.put(palabra, palabraXRepeticion.getOrDefault(palabra, 0)+1);
		}
		
		return palabraXRepeticion;
	}
}
