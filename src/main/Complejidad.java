package main;

public class Complejidad {
	
	
	// [ 10, 2, 15, 7]
	// 1 Primer for 
	// 0 -> [2, 10, 15, 7]
	// 1 -> [2, 10, 15, 7]
	// 2 -> [2, 10, 7, 15]
	// 2 Primer for
	// 0 -> [2, 10, 7, 15]
	// 1 -> [2, 7, 10, 15]
	// 2 -> [2, 7, 10, 15]
	//
	
	
	// n-1 + n-2 + n-3 + ...... + 1
	// 6 + 24n-1 + 24n2-1
	static void ordenarPorBurbujeo(int a[]) {
		for (int i = 1; i < a.length; i++) { // (1 + 2n-1) * ()
			for (int j = 0; j < a.length-i; j++) { //(1 + 2n-1) * ()
				if (a[j] > a[j + 1]) // 3 + 
					swap(a[j], a[j + 1]); // 3
										
			}
		}
	}
	
	//(n/2) * (n+1)
	
	static void swap(int n, int m) {
		int aux = n;
		n = m;
		m = aux;
	}
	
	// (1+2n-1) * ((1+2n-1) * (6))
	// (1+2(n-1)) * (6+12(n-1))
	// 6 + 12(n-1) + 12(n-1) + 24(n-1)
	// 6 + 24n-1 + 24n2-1
	
	//6 + 24n-1 + 24n2-1 ->
	// 1) Notacion O grande
	// 2) Reglas de algebra de ordenes
	
	// 22n - 17 = g
	// 21n2 = f
	
	// 21n2 + 22n - 17 = Regla 2
	// O(21n2 + 22n - 17)
	// 21n2 = Regla 3
	// 21 = f
	// n2 = g
	// O(21n2)
	// O(21) * O(n2) = Regla 4
	// O(1) * O(n2) = Regla 3
	// O(n2) <-
	
	

	
	
	//Demostrar utilizando el teorema de O grande 
	//Que  f(n)= raiz(n) + ln(n) + 1000
	//Pertenece a g(n) = raiz(n)
	
	//Segun el teorema de O grande...
	// f e g <=> c, n0 tal que 
	// f < n g para todo n > n0
	
	// 10 < 11
	// 50 < 61 => 10 + 50 + 8 < 11 + 61 + 10
	// 8 < 10
	
	// raiz(n) < 2 raiz(n)
	// ln(n) < raiz(n)
	// 1000 < raiz(n)
	
	// 1000 + ln(n) + raiz(n) < 100 raiz(n)
	
	// n0 = 20
	
	// 1000 + ln(20) + raiz(20) < 100 raiz(20) 
	// 1000 + 3 + 4 < 100 * 4
	// 1007 < 400 -> false
	
	
	// n0 = 90
	
	//1000 + ln(90) + raiz(90) < 100 raiz(90)
	// 1000 + 5 + 9 < 100 * 9
	// 1014 < 900 -> false
	
	// n0 = 130
	// 1000 + ln(130) + raiz(130) < 100 raiz(130)
	// 1000 + 5 +11 < 100 * 11
	// 1016 < 1100 -> true
	
	// Como encontre g = 100 * raiz(n)
	// c = 100
	// y n0 = 130
	// Podemos afirmar que por el teorema de O grande
	// f pertenece a g
	
	
	
	//n-1 + n-2 + n-3 + ...... + 1
	//1 + 2 + 3 + .... + n-2 + n-1 + n  
	
	// (1 + n) 
	// (2 + n- 1) -> ( 1 + n )
	// (3 + n-2) -> ( 1 + n )
	//.
	//.
	//.
	// la ultima pareja
	
	// # parejas puedo formar en total?
	// n/2 parejas
	
	// cuanto vale cada pareja?
	// (n+1)
	
	
	// -> (n/2) * (n+1) -> Algebra de ordenes, O grande
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

