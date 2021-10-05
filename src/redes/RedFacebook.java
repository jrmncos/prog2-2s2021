package redes;

public class RedFacebook extends Red<UsuarioFacebook>{

	@Override
	public void agregarRelacion(UsuarioFacebook p1, UsuarioFacebook p2) {
		super.agregarRelacion(p1, p2);
		super.agregarRelacion(p2, p1);
		
	}
	
}
