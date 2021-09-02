package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Multiconjunto;

class MulticonjuntoTest {

	//Definimos la interseccion
	private Multiconjunto multiConjunto;
	
	@BeforeEach
	public void setUp() {
		multiConjunto = new Multiconjunto();
		multiConjunto.agregar(2);
		multiConjunto.agregar(3);
		multiConjunto.agregar(2);
	}
	
	@Test
	void happyPathTest() {	
		assertEquals(3, multiConjunto.size()); 
		assertEquals(2 ,multiConjunto.pertenece(2));
		assertEquals(1 ,multiConjunto.pertenece(3));
	}
	
	@Test
	void noPerteneceTest() {
		assertEquals(0 ,multiConjunto.pertenece(4));
	}
	
}
