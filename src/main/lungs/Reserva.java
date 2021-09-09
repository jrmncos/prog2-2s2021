package main.lungs;

import java.util.ArrayList;

public class Reserva {
	private Computadora computadora;
	private ArrayList<String> alumnos;
	
	public Reserva(Computadora computadora, ArrayList<String> alumnos) {
		this.computadora = computadora;
		this.alumnos = alumnos;
	}

	public boolean reservaLlena() {
		return alumnos.size() == computadora.getCapacidad();
	}
	
	public void agregarAlumno(String usuario) {
		alumnos.add(usuario);
	}
	
	public Integer capacidadActual() {
		return computadora.getCapacidad() - alumnos.size();
	}
	
	public ArrayList<String> alumnos(){
		return alumnos;
	}
	
}
