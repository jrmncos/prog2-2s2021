package tuplas;

public class Coordenada extends Tupla<Integer, Integer>{

	public Coordenada(Integer e1, Integer e2) {
		super(e1, e2);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void sumar(Tupla<Integer, Integer> t){
		System.out.println("Sumar en Coordenada");
		super.setE1(super.getE1() + t.getE1()); 
		super.setE2(super.getE2() + t.getE2()); 
	}

}
