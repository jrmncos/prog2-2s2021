package votaciones;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaDeTurnosTest {
	private SistemaDeTurnos sistema;
	private static final Fixture F = Fixture.INSTANCE;
	
	@BeforeEach
	public void setUp() {
		sistema = new SistemaDeTurnos("Sede UNGS");
				
		sistema.registrarVotante(
				F.dniFrodo, 
				"Frodo", 
				23, 
				!F.trabaja, 
				!F.tieneEnfPrevia
		);
		sistema.registrarVotante(
				F.dniEowyn,
				"Eowyn",
				 25, 
				!F.trabaja, 
				F.tieneEnfPrevia
		);
		sistema.registrarVotante(
				F.dniBilbo,
				"Bilbo", 
				65, 
				!F.trabaja, 
				F.tieneEnfPrevia
		);
		sistema.registrarVotante(
				F.dniGandalf, 
				"Gandalf", 
				70, 
				F.trabaja, 
				!F.tieneEnfPrevia
		);
		sistema.registrarVotante(
				F.dniLegolas, 
				"Legolas", 
				80, 
				F.trabaja,
				!F.tieneEnfPrevia
		);
		sistema.registrarVotante(
				F.dniGaladriel, 
				"Galadriel", 
				81, 
				F.trabaja, 
				!F.tieneEnfPrevia
		);
		sistema.registrarVotante(
				F.dniArwen, 
				"Arwen", 
				50, 
				F.trabaja, 
				!F.tieneEnfPrevia
			);
		
		// # Votantes = 7
		// Mayores de 65 = 4
		// Trabajadores = 4
		// EnfPrexistente = 2
	}
	
	/*
	 * Al agregar una mesa se genera un ID de mesa.
	 * Se espera que al presidente a cargo se le asigne un Turno
	 */
	@Test
	public void asignacionMesas() {
		final Integer numMesaEnfPreexistente = sistema.
				agregarMesa(F.enfPreexistente, F.dniFrodo);
		
		final Integer numMesaMayor65 = sistema.
				agregarMesa(F.mayor65, F.dniBilbo);
		
		final Integer numMesaGeneral = sistema.
				agregarMesa(F.general, F.dniGaladriel);
		
		final Integer numMesaTrabajador = sistema.
				agregarMesa(F.trabajador, F.dniGandalf);
		
		assertNotNull(numMesaEnfPreexistente);
		assertNotNull(numMesaMayor65);
		assertNotNull(numMesaGeneral);
		assertNotNull(numMesaTrabajador);
		
		assertNotNull(sistema.consultaTurno(F.dniFrodo));
		assertNotNull(sistema.consultaTurno(F.dniBilbo));
		assertNotNull(sistema.consultaTurno(F.dniGaladriel));
		assertNotNull(sistema.consultaTurno(F.dniGandalf));
	}
	
	/*
	 * Al querer crear una mesa sin un votante 
	 * registrado deberia devolver una excepcion
	 */
	@Test
	public void asignacionMesasDniInvalido() {
		assertThrows(Exception.class, () ->
				sistema.agregarMesa(F.trabajador, F.dniSinVotante));
	}
	
	/*
	 * Al querer crear una mesa con un tipo de mesa invalido
	 * deberia devolver una excepcion
	 */
	@Test
	public void asignacionMesasTipomMesaInvalido() {
		assertThrows(Exception.class, () ->
				sistema.agregarMesa(F.tipoMesaInvalida, F.dniFrodo));
	}
	
	/*
	 * Se deberia asignar un turno para cada votante, 
	 * dado que no superan la capacidad total de las mesas
	 * No valida que los votantes se hayan asignado a su mesa correspondiente
	 */
	@Test
	public void asignacionTest() {
		final Integer votantesEsperados = 7;
		assertEquals(votantesEsperados, sistema.asignarTurnos());
	}
	
	/*
	 * Agrego una mesa solo para votantes trabajadores
	 * Se espera que solo se asignen los votantes trabajadores + presidente mesa: 
	 * En este caso no se valida el IREP de la franja horaria en si
	 * Ya que cada algoritmo puede asignar a los votantes en distintas franjas
	 */
	@Test
	public void asignacionPorTipoMesaTest() {
		final Integer numMesaEnfPreexistente = sistema.
				agregarMesa(F.trabajador, F.dniBilbo);
		
		sistema.asignarTurnos();
		
		final Map<Integer, List<Integer>> franjaHoraria = sistema.asignadosAMesa(numMesaEnfPreexistente);

		final Set<Integer> votantes = extraerVotantes(franjaHoraria.values());
		
		final Set<Integer> votantesEsperados = 
				Set.of(F.dniGandalf, F.dniLegolas, F.dniGaladriel,F.dniArwen);
		
		
		assertFalse(franjaHoraria.isEmpty());
		assertEquals(votantesEsperados, votantes);
		
	}
	
	/*
	 * En contraposicion al anterior Test, sino agrego una mesa para trabajadores
	 * Quedarian afuera las votaciones
	 */
	@Test
	public void votantesSinTurnoTest() {
		sistema.agregarMesa(F.general, F.dniFrodo);
		sistema.agregarMesa(F.enfPreexistente, F.dniEowyn);
		sistema.agregarMesa(F.mayor65, F.dniBilbo);
		
		sistema.asignarTurnos();
		
		final List<Tupla<String, Integer>> votantesSinTurno = sistema.sinTurnoSegunTipoMesa();
		
		final Integer cantVotantesSinTurno = extraerVotantesSinTurno(votantesSinTurno);
		
		final Integer expectedVotantesSinTurno = 4;
		
		assertEquals(expectedVotantesSinTurno, cantVotantesSinTurno);
	}
	
	/*
	 * Agrego una mesa general, como Frodo esta en el padron, 
	 * deberia asignarse un Turno
	 */
	@Test
	public void asignarTurnoTest() {
		sistema.agregarMesa(F.general, F.dniGaladriel);
		
		final Tupla<Integer, Integer> turno = sistema.asignarTurno(F.dniFrodo);
		final Tupla<Integer, Integer> turnoAsignado = sistema.consultaTurno(F.dniFrodo);
		assertNotNull(turno);
		assertNotNull(turnoAsignado);
	}
	
	/*
	 * Agrego una mesa general, como el dniSinVotante no esta en el padron, 
	 * no deberia asignarse un Turno y lanza una excepcion
	 */
	@Test
	public void asignarTurnoDniInvalidoTest() {
		sistema.agregarMesa(F.general, F.dniGaladriel);
		
		assertThrows(Exception.class, () ->
		sistema.asignarTurno(F.dniSinVotante));
	}
	
	/*
	 * No hay mesas, intengo agregar un turno y devuelve null
	 */
	@Test
	public void asignarTurnoInvalidoTest() {
		assertNull(sistema.asignarTurno(F.dniFrodo));
	}
	
	/*
	 * Agrego una mesa General y va a votar Frodo
	 * Luego, intenta votar otra vez y devuelve False
	 */
	@Test
	public void votarTest() {
		sistema.agregarMesa(F.general, F.dniGaladriel);
		
		Boolean voto = sistema.votar(F.dniFrodo);
		
		assertTrue(voto);
		assertFalse(sistema.votar(F.dniFrodo));
		
	}
	/*
	 * La asignacion de turnos por franja horaria debe ser valida
	 */
	@Test
	public void irepFranjaHorariaTest() {
		final List<Integer> dnis = generarNDnis(F.cantDnis);
				
		final Integer numMesa = sistema.agregarMesa(F.enfPreexistente, F.dniFrodo);
		
		//Una mesa con enfPreexistente soporta 20 votantes por franja horaria
		//Tengo 10 franjas horarias: 8,9,10....17
		//Deberia admitir como maximo 20 * 10 votantes
		
		//Cargo en el sistema  F.cantDnis votantes
		// Todos utilizando su dni como nombre, con 70 de edad y con enf preexistente
		dnis.forEach((dni) -> {
			sistema.registrarVotante(
					dni
					, String.valueOf(dni)
					, F.edad
					, F.tieneEnfPrevia
					, !F.trabaja);
		});
		
		Map<Integer,List<Integer>> asignadosXFranjaHoraria = 
				sistema.asignadosAMesa(numMesa);
		
		for(List<Integer> franjaHoraria: asignadosXFranjaHoraria.values()) {
			assertEquals(F.cupoXFranjaHorariaEnfPreexistente, (Integer)franjaHoraria.size());
		}
		
	
	}
	
	private List<Integer> generarNDnis(Integer n) {
		return IntStream.range(0, F.cantDnis).boxed().collect(Collectors.toList());
	}
	
	private Set<Integer> extraerVotantes(Collection<List<Integer>> votantesXFranjaHoraria) {
		Set<Integer> votantes = new HashSet<>();
		votantesXFranjaHoraria.forEach(
				(votanteFranjaHoraria) -> votantes.addAll(votanteFranjaHoraria)
		);
		return votantes;
	}
	
	private Integer extraerVotantesSinTurno(List<Tupla<String, Integer>> votantesSinTurno) {	
		return votantesSinTurno
				.stream()
				.map(tupla -> tupla.getY()).reduce(0, Integer::sum);
	}
	
}
