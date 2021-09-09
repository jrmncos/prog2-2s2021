package main.lungs;

import java.util.ArrayList;
import java.util.HashMap;

public class LaboUngs {
	private HashMap<String, Reserva> reservas;
	private HashMap<String, Computadora> computadoras;
	
	public LaboUngs() {
		reservas = new HashMap<>();
		computadoras = new HashMap<>();
	}

	public void agregarComputadora(String nombreMaquina, Integer capacidad) {
		computadoras.put(nombreMaquina, new Computadora(nombreMaquina, capacidad));
	}

	public void reservarComputadora(String nombreMaquina, String nombreUsuario) {
		if(reservas.containsKey(nombreMaquina)) {
			if(!reservas.get(nombreMaquina).reservaLlena()) {
				reservas.get(nombreMaquina).agregarAlumno(nombreUsuario);
			}
		}
		else {
			Computadora computadora = computadoras.get(nombreMaquina);
			ArrayList<String> alumnos = new ArrayList<String>();
			alumnos.add(nombreUsuario);
			reservas.put(nombreMaquina, new Reserva(computadora, alumnos));
		}
	}
	
	public String mostrarReservas(){
		//Complejidad Espacial: <-
//		String[] strings = {"hola", "adios", "ungs", "complejidad"};
//		String ret = "";
//		for(String st: strings) {
//		ret = ret + st; // ""+"hola"
//						// "hola"+"adios"
//						// "hola"+"adios"+"ungs" <-
//						// "hola"+"adios"+"ungs"+"complejidad"
//						// O(n**2)
//	}
		
		StringBuilder stb = new StringBuilder();
		for(String nombreMaquina: reservas.keySet()) {
			stb.append(nombreMaquina);
			stb.append(" Esta reservada por: ");
			stb.append(reservas.get(nombreMaquina).alumnos());
			stb.append("\n");	
		}
		
		return stb.toString();
	}
	
	//O(1)
	public Integer capacidadActual(String nombreMaquina) {
		if(!reservas.containsKey(nombreMaquina)) {
			return computadoras.get(nombreMaquina).getCapacidad();
		}
		else {
			return reservas.get(nombreMaquina).capacidadActual();
		}
	}
}
