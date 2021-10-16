package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lista.ListaRec;

public class ListaRecTest {
	private ListaRec listaDescendente;
	
	@BeforeEach
	public void setUp() {
		listaDescendente = new ListaRec();
		listaDescendente.agregar(4);
		listaDescendente.agregar(3);
		listaDescendente.agregar(2);
		listaDescendente.agregar(1);
	}
	
	@Test
	public void happyPathTest() {
		ListaRec lista = new ListaRec();
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(3);
		
		Integer expectedSize = 3;
		Integer expectedSum = 6;
	
		assertEquals(expectedSize, lista.size());
		assertEquals(expectedSum, lista.sumar());
	}
	
	@Test
	public void reverseTest() {
		ListaRec lista = new ListaRec();
		lista.agregar(1);
		lista.agregar(2);
		lista.agregar(3);
		lista.agregar(4);
		
		lista.reverse();
		
		assertTrue(listaDescendente.pseudoEquals(lista));

	}
}
