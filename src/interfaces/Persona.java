package interfaces;

public class Persona implements Comparable<Persona>{
	private String nombre;
	private String apellido;
	private Integer dni;
	
	public Persona(String nombre, String apellido, Integer dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public Integer getDni() {
		return dni;
	}
	
	
	// this < o -> negativo
	// this == o -> 0
	// this > 0 -> positivo
	@Override
	public int compareTo(Persona o) {
		if(this.dni < o.getDni()) {
			return 1;
		}
		else if (this.dni.equals(o.getDni())) {
			return 0;
		}
		else {
			return -1;
		}
	}
	
	
	
	
}
