package test;

import org.junit.jupiter.api.Test;

import main.Conjunto;
import main.Mesa;

public class ConjuntoTest {
	
	
	@Test
	public void happyPathTest() {
		Conjunto<String> conjString = new Conjunto<String>();
		conjString.agregar("Hola");
		conjString.agregar("Adios");
		
		Conjunto<Integer> conjInteger = new Conjunto<>();
		conjInteger.agregar(4);
		conjInteger.agregar(10);
		
		Conjunto<Mesa> conjMesa = new Conjunto<>();
		conjMesa.agregar(new Mesa());
		
		
	}
}
