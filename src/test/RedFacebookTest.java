package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

import redes.RedFacebook;
import redes.RedTwitter;

public class RedFacebookTest {
	
	@Test
	public void happyPathTest(){
		RedFacebook fb = new RedFacebook();
		String p1 = "Martin";
		String p2 = "German";
		String p3 = "Adriana";
		HashSet<String> expectedAmigos = new HashSet<>();
		expectedAmigos.add(p2);
		expectedAmigos.add(p3);
		
		fb.agregarRelacion(p1, p2);
		
		fb.agregarRelacion(p1, p3);

		assertTrue(fb.esAmigo(p1, p2));
		assertTrue(fb.esAmigo(p2, p1));
		assertEquals(expectedAmigos, fb.amigos(p1));
		
	}
	
	@Test
	public void redAsimetricaTest() {
		RedTwitter tw = new RedTwitter();
		String p1 = "Martin";
		String p2 = "German";
		
		tw.agregarRelacion(p1, p2);
		
		assertTrue(tw.esAmigo(p1, p2));
		assertFalse(tw.esAmigo(p2, p1));
	}
}
