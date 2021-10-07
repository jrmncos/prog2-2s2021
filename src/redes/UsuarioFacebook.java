package redes;

import java.util.HashSet;
import java.util.Set;

public class UsuarioFacebook extends Usuario {
	//Amigos
	private Set<UsuarioFacebook> amigos;

	public UsuarioFacebook(String nombre, String mail, String nombreUsuario) {
		super(nombre, mail, nombreUsuario);
		this.amigos = new HashSet<UsuarioFacebook>();
	}

	
	
	
	
}
