package test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import objetos.Auto;


public class AutoTest {

	@Test
	public void happyPathTest() {
		Auto a = new Auto("ABC-234", "rojo");
		
		a.dameColor();
		
		a.posiblesColoresDeUnAuto(); //Mal
		
		a.cantidadAutosTotales(); // Mal
		
		ArrayList<String> colores = Auto.colores; //Nunca hiciste un new
		
		Auto.cantidadAutosTotales();
	}
}
