package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;

import redes.Red;
import redes.RedFacebook;
import redes.RedTwitter;
import redes.UsuarioFacebook;

public class RedFacebookTest {
	
	@Test
	public void happyPathTest(){
		Red<UsuarioFacebook> fb = new RedFacebook();
		String p1 = "Martin";
		String p2 = "German";
		String p3 = "Adriana";
		
		fb.agregarRelacion(p1, p2);
		
		fb.agregarRelacion(p1, p3);

		assertTrue(fb.esAmigo(p1, p2));
		assertTrue(fb.esAmigo(p2, p1));		
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
	
	@Test
	public void castingTest() {
		Red rt = new RedTwitter();
		Red rf = new RedFacebook();
		
		if(rt instanceof RedTwitter) {
			RedTwitter twitter = (RedTwitter) rt;
			twitter.twittear(null);
		}
		
	}
	
	@Test
	public void conc() {
		Red rt = new RedTwitter();
		List<String> ls = List.of("Hola", "adios");
		List<Integer> li = List.of(1,2,3);
		List<Double> ld = List.of(1.0,2.1,3.2);
		
		rt.<Double>conc(ld);
	}
}
