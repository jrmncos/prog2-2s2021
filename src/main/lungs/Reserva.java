package main.lungs;

import java.util.ArrayList;

public class Reserva {
	private Computadora computadora;
	private ArrayList<Alumno> alumnos;
	
	public boolean reservaLlena() {
		return alumnos.size() == computadora.getCapacidad();
	}
	
	public void agregarAlumno(Alumno usuario) {
		alumnos.add(usuario);
	}
	
	public Integer capacidadActual() {
		return computadora.getCapacidad() - alumnos.size();
	}
	
}
