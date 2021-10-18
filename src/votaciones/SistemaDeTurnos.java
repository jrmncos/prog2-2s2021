package votaciones;

import java.util.List;
import java.util.Map;

public class SistemaDeTurnos {
	/* Constructor del sistema de asignacion de turnos. 
	 * Si el parametro nombre fuera null, debe generar una excepcion.
	 */
	public SistemaDeTurnos(String nombreSistema) {
		
	}

	/* Registrar a los votantes. Antes de asignar un turno el votante debe estar registrado 
	 * en el sistema. 
	 * Si no lo esta, se genera una excepcion.
	 * Si la edad es menor a 16, se genera una excepcion
	 */
	public void registrarVotante(
			int dni, 
			String nombre, 
			int edad, 
			boolean enfPrevia, 
			boolean trabaja) {
		//Implementar....
	}

	/* Agregar una nueva mesa del tipo dado en el parametro y asignar el presidente 
	 *  de cada una, el cual deberia estar entre los votantes registrados y sin turno asignado.
	 *  -  Devuelve el numero de mesa  creada.
	 *  si el president es un votante que no esta registrado debe devolver Empty
	 *  si el tipo de mesa no es valido debe generar una excepcion
	 *  Los tipos validos son:  Enf_Preex, Mayor65, General y Trabajador
	 */
	public int agregarMesa(final String tipoMesa, int dni) {
		//Implementar....

		return -1;
	}

	/* Asigna un turno a un votante determinado. 
	 *   -  Si el dni no pertenece a un votante registrado debe generar una excepcion.
	 *   -  Si el votante ya tiene turno asignado se devuelve el turno como: Numero de 
	 *        Mesa y Franja Horaria.
	 *  -  Si aun no tiene turno asignado se busca una franja horaria disponible en una
	 *       mesa del tipo correspondiente al votante  y se devuelve el turno asignado, como
	 *       Numero de Mesa y Franja Horaria.
	 *  -  Si no hay mesas con horarios disponibles no modifica nada y devuelve null.
	 *  (Se supone que el turno permitira conocer la mesa y la franja horaria asignada)
	 */
	public Tupla<Integer, Integer> asignarTurno(int dni){
		//Implementar....

		return new Tupla<Integer, Integer>(null, null);
	}

	/* Asigna turnos automoticamente a los votantes sin turno. 
	 *  El sistema busca si hay alguna mesa y franja horaria factible en la que haya disponibilidad.
	 *  Devuelve la cantidad de turnos que pudo asignar.
	 */
	public int asignarTurnos() {
		return -1;
	}

	/* Hace efectivo el voto del votante determinado por su dni.
	 *  Si el DNI no esta registrado entre los votantes debe generar una excepcion
	 *  Si ya habia votado devuelve false.
	 *  Sino, efectua el voto y devuelve true.
	 */
	public boolean votar(int dni) {
		//Implementar....

		return false;
	}
	
	/* 
	 * Cantidad de votantes con Turno asignados al tipo de mesa que se pide.
	 * -  Permite conocer cuantos votantes se asignaron hasta el momento a alguno
	 *      de los tipos de mesa que componen el sistema de votacion.
	 * -  Si la clase de mesa solicitada no es valida debe generar una excepcion
	 */
	public int votantesConTurno(final String tipoMesa) {
		//Implementar....

		return -1;
	}

	/* Consulta el turno de un votante dado su DNI. Devuelve Mesa y franja horaria.
	* -  Si el DNI no pertenece a un votante genera una excepcion.
	* -  Si el votante no tiene turno devuelve Empty.
	*/
	public Tupla<Integer, Integer> consultaTurno(int dni){
		//Implementar....

		return null;
	}

	/* Dado un numero de mesa, devuelve una Map cuya clave es la franja horaria y
	 *  el valor es una lista con los DNI de los votantes asignados a esa franja.  
	 *  Sin importar si se presentaron o no a votar.
	 *  -  Si el numero de mesa no es valido genera una excepcion.
	 *  -  Si no hay asignados devuelve un Map vacio.
	 */
	public Map<Integer,List<Integer>> asignadosAMesa(int numMesa){
		//Implementar....

		return null;
	}

	/*
	 *  Consultar la cantidad de votantes sin turno asignados a cada tipo de mesa.
	 *  Devuelve una Lista de Tuplas donde se vincula el tipo de mesa con la cantidad
	 *  de votantes sin turno que esperan ser asignados a ese tipo de mesa.
	 *  La lista no puede tener 2 elementos para el mismo tipo de mesa.
	 */
	public List<Tupla<String, Integer>> sinTurnoSegunTipoMesa(){
		//Implementar....

		return null;
	}
}
