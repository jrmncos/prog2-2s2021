package lista;

public class ListaRec {
	private Nodo head;
	private Integer size;
	
	public ListaRec() {
		this.size = 0;
	}
	
	static class Nodo {
		Integer valor;
		Nodo tail;
		
		public Nodo(Integer valor) {
			this.valor = valor;
		}
		
		public Nodo(Nodo tail, Integer valor) {
			this.valor = valor;
			this.tail = tail;
		}
		
	}
	
//	public ListaRec reverse() {
//		
//	}
	
	//Modifico el this
	public void reverse() {
		reverse(head);
	}
	// Firma Ok
	// Condicion final..
	// Escritura:
	// el reverse de una lista enlazada es
	// reverse(tail) + head
	
	//Asumamos que el operador + realiza la concatenacion de listas
	// { 2, 3 ,4 , 10 } -> { 10, 4, 3, 2 }
	// reverse( {3, 4, 10} ) + 2
	// reverse( {4, 10} ) + 3
	// reverse( {10} ) + 4
	
	// head -> 10 -> 4 -> 3 -> 2 -> Null
	
	// reverse(tail) + head

	private Nodo reverse(Nodo n) {
		if(n.tail == null) {
			this.head = n;
			return head;
		}
		else {
			// reverse(tail) + head
			Nodo nodo = reverse(n.tail);
			nodo.tail = new Nodo(n.valor);
			return nodo.tail;
		}
	}
	
	// Me llega un 5
	// {5 -> Null}
	// Agregar 3
	// { 5 -> 3 -> Null }	
	public void agregar(Integer elem) {
		head = agregar(head, elem);
	}
	
	private Nodo agregar(Nodo nodo, Integer elem) {
		if(nodo == null) {
			this.size++;
			return new Nodo(elem);
		}
		else {
			nodo.tail = agregar(nodo.tail, elem);
			return nodo;
		}
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
	
	public Integer size() {
		return size;
	}
	
	public boolean pseudoEquals(ListaRec lista) {
		if(lista.size != this.size()) return false;
		else return pseudoEquals(this.head, lista.head);
	}
	
	private boolean pseudoEquals(Nodo n1, Nodo n2) {
		if(n1 == null) {
			return true;
		}
		else {
			return n1.valor.equals(n2.valor) && pseudoEquals(n1.tail, n2.tail);
		}
	}
	
	
	
}
