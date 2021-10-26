package arboles;

public class ABB extends AB {

	@Override
	public void agregar(Integer elem) {	
		Nodo nodo = new Nodo(elem);
		if(super.raiz == null) {
			raiz = nodo;
		}
		else {
			agregar(elem, raiz);
		}
	}
	
	public Nodo agregar(Integer elem, Nodo nodo) {
		if(nodo == null) {
			return new Nodo(elem);
		}
		else {
			//No admite repetidos
			if(nodo.info.equals(elem)) {
				return nodo;
			}   
			else if(nodo.info < elem) {
				nodo.der = agregar(elem, nodo.der);
			}
			else {
				nodo.izq = agregar(elem, nodo.izq);
			}
			return nodo;
		}
	}
}
