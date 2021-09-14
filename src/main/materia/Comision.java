package main.materia;

import java.util.HashMap;

public class Comision {
	
	//Numero Librera, Nombre
	String nombre;
	Docente docente;
	HashMap<Integer, String> alumnos;
	
	public Comision(String nombreComision, String nombreDocente) {
		nombre = nombreComision;
		docente = new Docente(nombreDocente);
	}
}
