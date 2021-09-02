package main;

public class Tupla<X, Y> {
	private X x;
	private Y y;
	//Irep:
	//Una vez creada la tupla, no puedo modificarla
	
	public Tupla(X x, Y y) {
		this.x = x;
		this.y = y;
	}

	public X getX() {
		return x;
	}

	public Y getY() {
		return y;
	}

	public void setX(X x) {
		this.x = x;
	}

	public void setY(Y y) {
		this.y = y;
	}
	
	
}
