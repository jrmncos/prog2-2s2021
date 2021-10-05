package redes;


public class Usuario implements Notificable, Comparable<Usuario>{
	private String nombre;
	private String mail;
	private String nombreUsuario;
	//Seguidor...
	
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
