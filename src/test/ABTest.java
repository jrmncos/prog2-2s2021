package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import arboles.AB;
import arboles.ABB;

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
	
	@Test
	public void happyPathABB() {
		ABB abb = new ABB();
		abb.agregar(10);
		abb.agregar(2);
		abb.agregar(34);
		abb.agregar(8);
		abb.agregar(18);
		
		//abb.inorder();
		
		assertEquals((Integer) 5, abb.cantNodos());
		assertTrue(abb.balanceado());
	}
	
	@Test
	public void inorderTest() {
		ABB abb = new ABB();
		abb.agregar(10);
		abb.agregar(2);
		abb.agregar(34);
		abb.agregar(8);
		abb.agregar(18);
		
		
		List<Integer> expected = 
				List.of(2, 8, 10, 18, 34);
		
		List<Integer> inorder = abb.inorder();
		
		assertEquals(expected, inorder);
	}
	
	@Test
	public void esABBTest() {
		ABB abb = new ABB();
		abb.agregar(10);
		abb.agregar(2);
		abb.agregar(34);
		abb.agregar(8);
		abb.agregar(18);
		
		assertTrue(abb.esABB());
	}
	
	@Test
	public void noEsABBTest() {
		AB ab = new AB();
		ab.agregar(10);
		ab.agregar(2);
		ab.agregar(34);
		ab.agregar(8);
		ab.agregar(18);
		
		assertFalse(ab.esABB());
	}
	
}
