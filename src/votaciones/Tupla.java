package votaciones;

public class Tupla<X, Y> {
	final X x;
	final Y y;
	
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
}
