package test;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

import main.Coordenada;

public class HashCoordenadaTest {

	@Test
	public void happyPathTest() {
		HashSet<String> conjuntoSt = new HashSet<String>();
		conjuntoSt.add("Hola");
		conjuntoSt.add("Adios");
	
		assertTrue(conjuntoSt.contains("Adios"));
		
	}
	
	@Test
	public void coordenadasTest() {
		HashSet<Coordenada> conjuntoCoordenadas = new HashSet<Coordenada>();
		
		Coordenada c1 = new Coordenada(4,5); // hash(c1) -> 1234
		Coordenada c2 = new Coordenada(1,2); // hash(c2) -> 1234
		
		
		conjuntoCoordenadas.add(c1);
		conjuntoCoordenadas.add(c2);
			
		assertTrue(conjuntoCoordenadas.contains(c1));
	}
	
	@Test
	public void coordenadasIgualesTest() {
		Coordenada c1 = new Coordenada(4,5);
		Coordenada c2 = new Coordenada(4,5);
		
		assertTrue(c1.equals(c2));
		assertTrue(c1.hashCode() == c2.hashCode());
	}
}
