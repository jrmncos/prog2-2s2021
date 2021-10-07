package redes;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario implements Notificable, Comparable<Usuario>{
	private String nombre;
	private String mail;
	private String nombreUsuario;
	private List<Notificacion> notificaciones;
	
	//private HashSet<Usuario>
	//Seguidor...
	
	public Usuario(String nombre, String mail, String nombreUsuario) {
		this.nombre = nombre;
		this.mail = mail;
		this.nombre = nombreUsuario;
		this.notificaciones = new ArrayList<Notificacion>();
	}
	
	@Override
	public void recibirNotificacion(Notificacion n) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(Usuario o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
