package main;

import java.util.ArrayList;

public class Conjunto<T> {
	private ArrayList<T> datos;
	
	public Conjunto() {
		datos = new ArrayList<T>();
	}
	
	public void agregar(T elem) {
		//Esta mal! falta tener en cuenta los repetidos
		datos.add(elem);
	}
	
	public boolean pertenece(T elem) {
		return datos.contains(elem);
	}
	
	public boolean eliminar(T elem) {
		return datos.remove(elem);
	}
	
	public Integer size() {
		return datos.size();
	}
}
