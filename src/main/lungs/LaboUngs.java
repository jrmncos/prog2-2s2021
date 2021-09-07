package main.lungs;

import java.util.HashMap;

public class LaboUngs {
	private HashMap<String, Reserva> reservas;
	private HashMap<String, Computadora> computadoras;

	public void agregarComputadora(String nombreMaquina, Integer capacidad) {
		computadoras.put(nombreMaquina, new Computadora(nombreMaquina, capacidad));
	}

	public void reservarComputadora(String nombreMaquina, String nombreUsuario) {
		if(reservas.containsKey(nombreMaquina)) {
			if(!reservas.get(nombreMaquina).reservaLlena()) {
				reservas.get(nombreMaquina).agregarAlumno(new Alumno(nombreUsuario));
			}
		}
//		else {
//			reservas.put(nombreMaquina, new Reserva(computadora, alumno))
//		}
	}
	
	//Como defino el mostrar?
	public HashMap<String, Reserva> mostrarReservas(){
		return reservas;
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
