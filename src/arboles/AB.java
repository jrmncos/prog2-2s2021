package arboles;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AB { // arbol binario
	protected Nodo raiz;

	public static class Nodo{ //clase interna
		protected Integer info;
		protected Nodo izq;
		protected Nodo der;
		public Nodo(Integer info){
			this.info = info;
		}
	
		@Override
		public String toString(){
			return info.toString();
		}
		
	}	
	
	/*
 * 		arbol.agregar(10);
		arbol.agregar(7);
		arbol.agregar(2);
		arbol.agregar(87);
		arbol.agregar(9);
		arbol.agregar(73);
	 */
	
	/*							10
	 * 						7		2
	 * 					87		9
	 				73     
	 */			
	
	public void agregar(Integer elem) {	
		Nodo nuevo = new Nodo(elem);	
		if (raiz == null)
			raiz = nuevo;
		else
			agregar(raiz, nuevo);		
	}
	
	private void agregar(Nodo nodo, Nodo nuevo) {
		if (nodo.izq == null)
			nodo.izq = nuevo;
		else if(nodo.der == null)
			nodo.der = nuevo;
		else
			agregar(nodo.izq, nuevo);
	}


	@Override
	public String toString() {
		return toString(raiz);
	}

	private String toString(Nodo n) {
		// StringBuilder sb = new StringBuilder();
		String ret = "";

		if (n != null) {
			ret = ret + n + "," + toString(n.izq) + toString(n.der);
		}

		return ret;

	}


	// 1 Firma:
	// boolean estaEl8()
	
	// 2 Cuando termina el algoritmo ?
	// Cuando llegue a algo que es null
	
	// 3 Escribir con nuestras palabras lo que deberia hacer
	
	// estaEl8() es o bien el nodo actual es el 8, o el esta el 8 en nodo.izq o 
	//o esta el 8 en nodo.der
	
	
	/*
	 * 				2
	 * 		3				-1
	 * 
	 * 					8		10
	 * 
	 */
	
	
	/*
	 * 
	 * 		2 == 8 || estaEl8(3) (false) || estaEl8(-1) (true)
	 * 
	 * 					3 == 8 || estaEl8(null) || estaEl8(null)
	 * 
	 * 								false			false
	 * 
	 * 
	 * 	
	 * 		-1 == 8 || estaEl8(8) (true) || estaEl8(10)
	 * 					
	 * 					8 == 8 (true) || estaEl8(null) || estaEl8(null)
	 * 					
	 * 
	 * 
	 */
	public boolean pertenece(Integer elem) {
		return pertenece(raiz, elem);
	}
	
	private boolean pertenece(Nodo n, Integer elem) {
		if(n == null) 
			return false;
		
		return n.info.equals(elem) || 
				pertenece(n.izq, elem) || 
				pertenece(n.der, elem);
	}
	
	
	/*
	 * Altura de un ab
	 * 
	 * 1) Firma
	 * 
	 * 2) Cuando termina el algoritmo ? Termina cuando encontro un Nodo null
	 * y devuelve 0
	 * 
	 * 3)
	 * 
	 * La altura de un arbol es sumo el nodo actual (1)
	 * decido si me quedo con la altura izq, o la altura der
	 * 
	 * 1 + Max(altura(arbol.izq), altura(arbol.der)) 
	 * 
	 */
	
	
	public Integer altura() {
		return altura(raiz);
	}
	
	private Integer altura(Nodo nodo) {
		if(nodo == null) {
			return 0;
		}
		else {
			return 1 + 
					Integer.max(altura(nodo.izq), altura(nodo.der));
		}
	}
	
	/*
	 * 1) Firma
	 * 
	 * 2) Cuando termina el algoritmo? 
	 * 
	 * Si termina cuando es null, devuelvo 0
	 * 
	 * Termina cuando encontre una hoja devuelvo 1
	 * 
	 * 
	 * 3) Escribir
	 * 
	 * cantHojas = 1 si Nodo es hoja, 0 caso contrario 
	 * 
	 * + cantHojas(izq) + cantHojas(der)
	 * 
	 * 
	 */
	
	// Arbol this -> 10
	
	public Integer cantHojas() {
		// Aca haya que definir cosas..
		return cantHojas(raiz);
	}
	
	
	private int cantHojas(Nodo n) {
		if (n == null)
			return 0;
		if (esHoja(n))
			return 1;
		return cantHojas(n.izq) + cantHojas(n.der);
	}
	
	private boolean esHoja(Nodo n) {
		return n.izq == null && n.der == null;
	}

	public Integer cantNodos() {
		return cantNodos(raiz);
	}
	
	private Integer cantNodos(Nodo n) {
		if(n == null) {
			return 0;
		}
		else {
			return 1 + cantNodos(n.izq) + cantNodos(n.der);
		}
	}
	
	
	public Boolean balanceado() {
		return balanceado(raiz);
	}
	
	private Boolean balanceado(Nodo n) {
		if (n == null)
			return true;
		return (Math.abs(altura(n.izq) - altura(n.der)) <= 1) 
				&& balanceado(n.izq) 
				&& balanceado(n.der);
	}

	public boolean tieneCiclos() {
		Set<Integer> nodosVisitados = new HashSet<>();
		return tieneCiclos(raiz, nodosVisitados);
	}
	
	private boolean tieneCiclos(Nodo nodo, Set<Integer> nodosVisitados) {
		if(nodo == null) {
			return false;
		}
		else {
			if(nodosVisitados.contains(nodo.info)) {
				return true;
			}
			else {
				nodosVisitados.add(nodo.info);
				return tieneCiclos(nodo.izq, nodosVisitados)
						|| tieneCiclos(nodo.der, nodosVisitados);
			}
		}
			
	}

	
	public void crearCiclo(Integer elem1, Integer elem2) {
		if(pertenece(elem1) && pertenece(elem2)) {
			Nodo n1 = buscar(elem1, raiz);
			Nodo n2 = buscar(elem2, raiz);
			
			n1.izq = n2;
		}
	}
	
	private Nodo buscar(Integer elem, Nodo nodo) {
		if(nodo == null) {
			return null;
		}
		else if(nodo.info.equals(elem)) {
			return nodo;
		}
		else {
			Nodo nodoIzq =  buscar(elem, nodo.izq);
			Nodo nodoDer =  buscar(elem, nodo.der);
			
			return nodoIzq != null ? nodoIzq: nodoDer;
		}
	}
			
			/*
			 *     if(nodo.izq != null)
			 *        return nodoIzq
			 *     else
			 *        return nododER
			 */
			
		// condicion ? caso afirmativo : caso negativo
		

	
	/*
	 * 				10
	 * 		7				1
	 * 
	 *    2							10
	 * 1								40
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 					
	 * 					7
	 * 				2
	 * 			1
	 * 
	 * estaBalanceado(Nodo n)
	 * if(...)
	 * 
	 * 
	 * else
	 * 
	 *      return altura(n.izq) - altura(n.der) <= 1
	 *      && estaBalanceado(n.izq) && estaBalanceado(n.der)
	 *      
	 *      
	 * 
	 * 
	 */
	
	
	public boolean esABB() {
		// Me traigo los nodos inorder
		// Chequeo que los nodos esten ordenados de menor a mayor
		List<Integer> nodos = this.inorder();
		
		boolean ret = true;
		for(int i=0; i < nodos.size()-1; i++) {
			ret = ret && nodos.get(i) <= nodos.get(i+1);
		}
		
		return ret;
	}
	
	/*							10
	 * 						7		2
	 * 					87		9
	 				73     
	 */			
	
	public void preorder() {
		preorder(raiz);
	}
	
	private void preorder(Nodo nodo) {
		if(nodo != null) {
			System.out.println(nodo.info);
			preorder(nodo.izq);
			preorder(nodo.der);
		}
	}
	

	public List<Integer> inorder() {
		List<Integer> l = new ArrayList<>();
		return inorder(raiz, l);
	}
	
	private List<Integer> inorder(Nodo nodo, List<Integer> l) {
		if(nodo != null) {
			inorder(nodo.izq, l);
			l.add(nodo.info);
			inorder(nodo.der, l);
		}
		return l;
	}
	
	public boolean igualEstruc(ABB abb2) {
		return igualAux(raiz, abb2.raiz);
	}
	
	private boolean igualAux(Nodo propio, Nodo otro) {
		if(propio==null) {
			return otro == null;
		}
		else {
			if(otro==null) {
				return false;
			}
			else {
				return propio.info.equals(otro.info) 
						&& igualAux(propio.izq, otro.izq)
						&& igualAux(propio.der, otro.der);
			}
		}
	}
	
	// Complejidad
	// Cuantas veces visita cada nodo ?
	
	
	public void recorrerPorNivel() {
		Integer cantidadNiveles = this.altura();
		recorrerPorNivel(0, cantidadNiveles);
	}
	
	private void recorrerPorNivel(Integer nivelActual, Integer ultimo) {
		if(nivelActual == ultimo) {
			return;
		}
		else {
			imprimirNivel(this.raiz, nivelActual); // O(n)
			recorrerPorNivel(nivelActual + 1, ultimo);
		}
	}
	
	// O(n)
	private void imprimirNivel(Nodo nodo, int nivel) {
		if (nodo == null)
			return;
		if (nivel == 0) {
			System.out.println(nodo.info);
		}
		imprimirNivel(nodo.izq, nivel - 1);
		imprimirNivel(nodo.der, nivel - 1);
	}
	
	// => O(n * n) 
	
	/*
	 * 					2
	 * 
	 * 			1				4
	 * 									
	 * 					3			5
	 * 
	 */
	// Despues de procesar el 1.
	/*
	 * 					2
	 * 
	 * 			4				1
	 * 									
	 * 		5			3			
	 * 
	 */
	
	
	public void reverse() {
		reverse(this.raiz);
	}
	
	private void reverse(Nodo nodo) {
		if(nodo == null || esHoja(nodo))
			return;
		else {
			swapHijos(nodo);
			reverse(nodo.izq);
			reverse(nodo.der);
		}
	}
	
	private void swapHijos(Nodo nodo) {
		Nodo aux = nodo.der;
		nodo.der = nodo.izq;
		nodo.izq = aux;	
	}
	
}
