package tuplas;

public class Pixel extends Coordenada{
	private Integer color;

	public Pixel(Integer e1, Integer e2, Integer color) {
		super(e1, e2);
		this.color = color;
	}
	
	@Override
	public void sumar(Tupla<Integer, Integer> t){
		System.out.println("Sumar en Pixel");
		super.setE1(super.getE1() + t.getE1()); 
		super.setE2(super.getE2() + t.getE2()); 
	}
	
	public void metodoEspecificoDePixel() {
		
	}

}
