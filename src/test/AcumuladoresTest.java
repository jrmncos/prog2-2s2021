package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Acumuladores;

class AcumuladoresTest {

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void happyPathParEImparTest() {
		//Inicializacion
		int[][] mtx = {
				{1,5,6},
				{1,4,6},
				{2,5,1}}; 
		//Asserts
		assertTrue(Acumuladores.parEImpar(mtx));
	}
	
	@Test
	void parEImparMatrizNoParEImparTest() {
		int[][] mtx = {
				{1,5,6},
				{1,7,6},
				{2,5,1}};
		assertFalse(Acumuladores.parEImpar(mtx));
	}
	
	@Test
	void parEImparMatrizVaciaTest() {
		int[][] mtx = {};
		assertTrue(Acumuladores.parEImpar(mtx));
	}
	

}
