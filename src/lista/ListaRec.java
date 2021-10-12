package lista;

public class ListaRec {
	private Nodo head;
	
	static class Nodo {
		Integer valor;
		Nodo tail;
	}
	
	public void agregarElemento(Integer elem) {
		
	}
	// { 2, 3, 4 } l.sumar() -> 9
	
	// Firma ok
	public Integer sumar() {
		return sumar(head);
	}
	
	private Integer sumar(Nodo nodo) {
		// Termina cuando llegue a algo null
		if(nodo == null) {
			return 0;
		}
		else {
			// Suma el head, y despues suma el resto
			// head + sumar(tail)
			return nodo.valor + sumar(nodo.tail);
		}
	}
	
	
	public Integer min() {
		return min(head, Integer.MAX_VALUE);
	}
	
	//Firma
	private Integer min(Nodo nodo, Integer minActual) {
		if(nodo == null) {
			return 0;
			//Devolver algo tal que no me cambie el minActual
		
		}else {
			// min(actual || minActual, min(tail)) 
//			if(nodo.valor < minActual) {
//				return min(nodo.tail, nodo.valor);
//			}
//			else {
//				return min(nodo.tail, minActual);
//			}
			// (condicion) ? caso verdadero: caso falso
			return nodo.valor < minActual ? 
					min(nodo.tail, nodo.valor): min(nodo.tail, minActual);
				
		}
		
	}
}
