package interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p1 = new Persona("German", "Costilla", 40861249);
		Persona p2 = new Persona("Martin", "Pustilnik", 39861249);
		Persona p3 = new Persona("Diego", "Lucero", 41861249);
		Persona p4 = new Persona("Candela", "Gonzalez", 42861249);;
				
		List<Persona> personas = new LinkedList<Persona>();
		personas.add(p1);
		personas.add(p2);
		personas.add(p3);
		personas.add(p4);
		System.out.println(personas);

		Collections.sort(personas);
		//Quisiera ordenar esa lista
		
		System.out.println(personas);

	}

}
