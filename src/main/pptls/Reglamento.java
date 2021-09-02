package main.pptls;

import java.util.HashMap;
import java.util.HashSet;

public class Reglamento {
	private HashMap<Figura, HashSet<Figura>> reglamento;
	
	// Spock -> {Piedra, Tijera}
	// Piedra -> {Tijera}
	// Papel -> {Spock, Piedra}
	
	public boolean leGana(Figura f1, Figura f2) {
		HashSet<Figura> venciblesPorF1 = reglamento.get(f1);
		if(venciblesPorF1.contains(f2))
			return true;
		else
			return false;
	}

}
