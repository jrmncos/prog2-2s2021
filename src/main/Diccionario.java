package main;

import java.util.ArrayList;


//Hash
// f(x) -> y
// f(x') -> y Colision
// f("Hola") -> asdva123
// f("Holaa") -> acjklajskh1jk2

// Diccionario java: HashMap

// Crear el metodo eliminar
// Crear los test unitarios para el Diccionario
public class Diccionario<K,V> {
	private ArrayList<Tupla<K,V>> datos;
	// ArrayList<Tupla<String,Integer>>
	// {("Hola", 3), ("Computadora", 10) ....}
	
	//O(n)
	public boolean agregar(K key, V value) {
		//Max(if else)
		//if: O(n) + O(n) -> O(2) O(n) -> O(1) O(n) -> O(n)
		if(pertenece(key)) {
			//for(T nombreVariable: nombreEstructura)
			for(Tupla<K, V> tupla: datos) {
				if(tupla.getX() == key) {
					tupla.setY(value);
				}
			}
		}
		else {
			//O(1)
			datos.add(new Tupla<>(key, value));
		}
		return true;
	}
	
	//O(n)
	public boolean pertenece(K key) {
		for(Tupla<K, V> tupla: datos) {
			if(tupla.getX() == key) {
				return true;
			}
		}
		return false;
	}
	
	//O(n)
	public V obtener(K key) {
		for(Tupla<K, V> tupla: datos) {
			if(tupla.getX() == key) {
				return tupla.getY();
			}
		}
		return null;
	}
	
	public boolean eliminar(K key) {
		return true;
	}
	

}
