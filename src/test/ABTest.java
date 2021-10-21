package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

import arboles.AB;

public class ABTest {
	
	@Test
	public void happyPathTest() {
		AB arbol = new AB(); 
		arbol.agregar(10);
		arbol.agregar(7);
		arbol.agregar(2);
		arbol.agregar(87);
		arbol.agregar(9);
		
		assertEquals((Integer) 5, arbol.cantNodos());
		assertTrue(arbol.pertenece(10));
		assertTrue(arbol.pertenece(7));
		assertTrue(arbol.pertenece(2));
		assertTrue(arbol.pertenece(87));
		assertTrue(arbol.pertenece(9));
	}
	
	@Test
	public void noPerteneceTest() {
		AB arbol = new AB(); 
		arbol.agregar(10);
		
		assertFalse(arbol.pertenece(1));
	}
	
	@Test
	public void cantHojasArbolVacio() {
		AB arbol = new AB(); 
	
		assertEquals((Integer) 0, arbol.cantHojas());
	}
	
	@Test
	public void balanceadoTest() {
		AB arbol = new AB(); 
		arbol.agregar(10);
		arbol.agregar(7);
		arbol.agregar(2);
		arbol.agregar(87);
		arbol.agregar(9);
		
		assertTrue(arbol.balanceado());
	}
	
	@Test
	public void noBalanceadoTest() {
		AB arbol = new AB(); 
		arbol.agregar(10);
		arbol.agregar(7);
		arbol.agregar(2);
		arbol.agregar(87);
		arbol.agregar(9);
		arbol.agregar(73);
		
		assertFalse(arbol.balanceado());
	}
	
	
	@Test
	public void equalsContenidoTest() {
		AB arbol = new AB(); 
		arbol.agregar(10);
		arbol.agregar(7);
		arbol.agregar(2);
		arbol.agregar(87);
		arbol.agregar(9);
		arbol.agregar(73);
		
		AB arbol2 = new AB(); 
		arbol2.agregar(10);
		arbol2.agregar(7);
		arbol2.agregar(2);
		arbol2.agregar(87);
		arbol2.agregar(9);
		arbol2.agregar(73);
		
		assertTrue(arbol.equals(arbol2));
	}
	
	@Test
	public void tieneCiclosTest() {
		AB arbol = new AB(); 
		arbol.agregar(10);
		arbol.agregar(7);
		arbol.agregar(2);
		arbol.agregar(87);
		arbol.agregar(9);
		arbol.agregar(73);
		
		arbol.crearCiclo(73, 9);
		
		assertTrue(arbol.tieneCiclos());
	}
	
}
