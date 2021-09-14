package main.materia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

//1)
public class Materia {
	String nombre;
	Docente coordinador; // IREP: docenteACargo pertenece a algun Docente en comisiones.values().getDocente
	HashMap<String, Comision> comisiones; //IREP para toda key en comisiones comisiones.get(key).nombre == key
	
	
	public void agregarComision(String nombreComision, String nombreDocente) {
		comisiones.put(nombreComision, new Comision(nombreComision, nombreDocente));
	}
	
	public String docenteACargo(String nombreComision) {
		return comisiones.get(nombreComision).docente.getNombreDocente();
	}
	
	public void setCoordinador(String nombreCoordinador) {
		for(Comision c: comisiones.values()) {
			Docente d = c.docente;
			if(d.getNombreDocente().equals(nombreCoordinador)) {
				this.coordinador = d;
			}
		}
		
//		for(Comision c : comisiones.values()) {
//			if (comisiones.values().contains(c)) {
//				this._coordinador = d;
//			}
//		}
	}
	
	public Set<Integer> libretas(String nombreComision){
		return comisiones.get(nombreComision).alumnos.keySet();
	}
	// ArrayList{ 2, 3, 4, 10}
	// for(int i=0; i < arraylist.size(); i++)
	//       //arraylist.remove(1)
}


