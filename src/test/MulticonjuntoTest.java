package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Multiconjunto;

class MulticonjuntoTest {

	//Definimos la interseccion
	private Multiconjunto<Integer> multiConjunto;
	
	@BeforeEach
	public void setUp() {
		multiConjunto = new Multiconjunto<>();
		multiConjunto.agregar(2);
		multiConjunto.agregar(3);
		multiConjunto.agregar(2);
	}
	
	@Test
	void happyPathTest() {	
		assertEquals(3, multiConjunto.size()); 
		assertEquals(2 ,multiConjunto.obtener(2));
		assertEquals(1 ,multiConjunto.obtener(3));
	}
	
	@Test
	void noPerteneceTest() {
		assertEquals(0 ,multiConjunto.obtener(4));
	}
	
	@Test
	void multiconjuntoStringTest() {
		Multiconjunto<String> multiconjuntoSt = new Multiconjunto<>();
		multiconjuntoSt.agregar("Hola");
		multiconjuntoSt.agregar("Hola");
		multiconjuntoSt.agregar("Hola");
		multiconjuntoSt.agregar("UNGS");
		
		assertEquals(4, multiconjuntoSt.size()); 
		assertEquals(3 ,multiconjuntoSt.obtener("Hola"));
		assertEquals(1 ,multiconjuntoSt.obtener("UNGS"));
		assertEquals(0 ,multiconjuntoSt.obtener("Adios"));
	}
	
	
	/*
	 * Objeto: Sustantivo, atributos (estado) + metodos (comportamiento)
	 * 
	 * Clase: Plantilla a partir de la cual creo los objetos
	 * 
	 * 
	 * 
	 * 
	 */
	
}
