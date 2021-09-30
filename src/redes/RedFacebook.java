package redes;

public class RedFacebook extends Red{

	@Override
	public void agregarRelacion(String p1, String p2) {
		super.agregarRelacion(p1, p2);
		super.agregarRelacion(p2, p1);
		
	}
	
}
