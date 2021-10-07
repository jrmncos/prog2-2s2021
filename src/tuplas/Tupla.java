package tuplas;

public class Tupla<E1, E2> {
	private E1 e1;
	private E2 e2;
	
	
	
	public Tupla(E1 e1, E2 e2) {
		super();
		this.e1 = e1;
		this.e2 = e2;
	}
	public E1 getE1() {
		return e1;
	}
	public void setE1(E1 e1) {
		this.e1 = e1;
	}
	public E2 getE2() {
		return e2;
	}
	public void setE2(E2 e2) {
		this.e2 = e2;
	}
	
	public void sumar(Tupla<E1,E2> t) {
		System.out.println("Sumar en Tupla");
		if(this.getE1() instanceof String && t.getE1() instanceof String) {
			this.setE1 ((E1)(this.getE1().toString() + t.getE1().toString()));
		}
		
		if(this.getE2() instanceof String && t.getE2() instanceof String) {
			this.setE2 ((E2)(this.getE2().toString() + t.getE2().toString()));
		}
	}
	
	
	

}
