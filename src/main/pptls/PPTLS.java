package main.pptls;

public class PPTLS {
	private Reglamento reglamento;
	private String ganador;
	
	public void jugar(Figura f1, Figura f2) {
		String empate = "Empate";
		if(reglamento.leGana(f1, f2)) {
			ganador = "Jugador 1";
			return;
		}
		if(reglamento.leGana(f2, f1)) {
			ganador = "Jugador 2";
			return;
		}
		ganador = empate;
	}
	
	public String ganador() {
		return ganador;
	}
}
