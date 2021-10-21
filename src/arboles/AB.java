package arboles;

public class AB { // arbol binario
	private Nodo raiz;

	public static class Nodo{ //clase interna
		private Integer info;
		private Nodo izq;
		private Nodo der;
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
		// TODO Auto-generated method stub
		return false;
	}

	public void crearCiclo(Integer elem1, Integer elem2) {
		// TODO Auto-generated method stub
		
	}
	
	
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
	
	
	
	

}
