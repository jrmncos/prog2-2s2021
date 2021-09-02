package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Tupla;

class TuplaTest {

	@Test
	void happyPathTest() {
		Tupla<Integer, Integer> t = new Tupla<>(2, 5);
				
		assertEquals(2, t.getX());
		assertEquals(5, t.getY());
	}
	
	@Test
	void distintosTiposTest() {
		Tupla<String, Integer> t = new Tupla<>("Hola", 10);
				
		assertEquals("Hola", t.getX());
		assertEquals(10, t.getY());
	}

}
