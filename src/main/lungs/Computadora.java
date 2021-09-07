package main.lungs;

public class Computadora {
	private String nombreMaquina;
	private Integer capacidad;

	public Computadora(String nombreMaquina, Integer capacidad) {
		super();
		this.nombreMaquina = nombreMaquina;
		this.capacidad = capacidad;
	}

	public String getNombreMaquina() {
		return nombreMaquina;
	}

	public void setNombreMaquina(String nombreMaquina) {
		this.nombreMaquina = nombreMaquina;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

}
