package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import redes.Red;
import redes.RedFacebook;
import redes.RedTwitter;
import redes.UsuarioFacebook;
import redes.UsuarioTwitter;

public class RedFacebookTest {
	
	@Test
	public void happyPathTest(){
		Red<UsuarioFacebook> fb = new RedFacebook();
		UsuarioFacebook p1 = new UsuarioFacebook("Martin", "martin@someemail.com", "martinp");
		UsuarioFacebook p2 = new UsuarioFacebook("German", "German@someemail.com", "germanc");
		UsuarioFacebook p3 = new UsuarioFacebook("Adriana", "adriana@someemail.com", "adrianag");
		
		fb.agregarRelacion(p1, p2);
		
		fb.agregarRelacion(p1, p3);

		assertTrue(fb.esAmigo(p1, p2));
		assertTrue(fb.esAmigo(p2, p1));		
	}
	
	@Test
	public void redAsimetricaTest() {
		RedTwitter tw = new RedTwitter();
	
		UsuarioTwitter p1 = new UsuarioTwitter("Martin", "martin@someemail.com", "martinp");
		UsuarioTwitter p2 = new UsuarioTwitter("German", "German@someemail.com", "germanc");
		
		tw.agregarRelacion(p1, p2);
		
		assertTrue(tw.esAmigo(p1, p2));
		assertFalse(tw.esAmigo(p2, p1));
	}
	
	@Test
	public void castingTest() {
		Red<UsuarioTwitter> rt = new RedTwitter();
		
		if(rt instanceof RedTwitter) {
			RedTwitter twitter = (RedTwitter) rt;
			twitter.twittear(null);
		}
		
	}
	
	@Test
	public void conc() {
		Red<UsuarioTwitter> rt = new RedTwitter();
		List<Double> ld = List.of(1.0,2.1,3.2);
		
		rt.<Double>conc(ld);
	}
}
