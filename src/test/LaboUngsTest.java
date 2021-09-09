package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import main.lungs.LaboUngs;

public class LaboUngsTest {
	
	@Test
	public void happyPathTest() {
		LaboUngs labo = new LaboUngs();
		labo.agregarComputadora("Compu-I7", 2);
		labo.agregarComputadora("Compu-Ryzen5", 3);
		
		labo.reservarComputadora("Compu-I7", "Martin");
		labo.reservarComputadora("Compu-I7", "German");
		
		//Expected, Actual
		assertEquals(Integer.valueOf(0), labo.capacidadActual("Compu-I7"));
		//assertEquals("Compu-I7 Esta reservada por: [Martin, German]",labo.mostrarReservas());
	}
}
