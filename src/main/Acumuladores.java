package main;

public class Acumuladores {
	
	
	//true || .....
	public static boolean esCapicua(int[][] mtz) {
		boolean paraTodaColumna = true;
		for(int j=0; j < mtz.length; j++) {
			paraTodaColumna = paraTodaColumna && 
					capicuaColumna(mtz, j);
		}
		return paraTodaColumna;
	}
	
	public static boolean capicuaColumna(int[][] mat, int j){
		// I					D
		// 1 	5	6	6	5	1
		System.out.println("capicua columna");
		boolean ret = true;
		for(int i=0; i < mat.length; i++) {
			ret = ret && mat[i][j] == mat[mat.length-1-i][j];
		}
		return ret;
	}
	
	
	public static boolean mayusCorrecta(String palabra) {
		if(palabra.length() < 2) return true;
		
		boolean noHayMayus = !esMayus(palabra.charAt(0)); 
		boolean primeraMayus = esMayus(palabra.charAt(0));
		boolean todoEsMayus = esMayus(palabra.charAt(0));
		
		for(int i=1; i<palabra.length(); i++) {
			boolean esMayus = esMayus(palabra.charAt(i));
			primeraMayus = primeraMayus && !esMayus;
			noHayMayus = noHayMayus && !esMayus;
			todoEsMayus = todoEsMayus && esMayus;
		}
		return noHayMayus || primeraMayus || todoEsMayus;
	}
	
//	private static boolean esMayus2(char c) {
//		return Character.isUpperCase(c);
//	}
	
	private static boolean esMayus(char c) {
		return 65 <= c && c <= 90;
	}
	
	public static boolean mayorDiversidad(int[][] mtx) {
		return parEImpar(mtx) && estrictamenteAscendente(mtx);
	}
	
	//b) todas las columnas tienen al menos un elemento impar, y otro par
	//mat[i][j]
	public static boolean parEImpar(int[][] mtx) {
		if(mtx.length == 0) return true;
		boolean paraTodaColumna = true;
		for(int j=0; j < mtx[0].length; j++) {
			paraTodaColumna = paraTodaColumna && parEImpar(mtx, j);
		}
		
		return paraTodaColumna;
	}
	
	private static boolean parEImpar(int[][] mtx, int j) {
		System.out.println("Par e impar");
		boolean alMenosUnoPar = false;
		boolean alMenosUnoImpar = false;
	
		for(int i=0; i<mtx.length; i++) {
			boolean par = mtx[i][j] % 2 == 0;
			alMenosUnoPar = alMenosUnoPar || par;
			alMenosUnoImpar = alMenosUnoImpar || !par;
		}
		
		return alMenosUnoPar && alMenosUnoImpar;
	}
	
	/*
	 * 
	 * 1 5 6      -> col 0: 1,1,3 false
	 * 1 4 6	  -> col 1: 5,4,5 true
	 * 3 5 1      -> col 3: 6,6,1 true
	 * 
	 */
	//a) todas las filas están en orden estrictamente ascendente
	public static boolean estrictamenteAscendente(int[][] mtx) {
		boolean paraTodaFila = true;
		
		for(int i=0; i< mtx.length; i++) {
			for(int j=0; j < mtx[0].length-1 ; j++) {
				paraTodaFila = paraTodaFila && mtx[i][j] < mtx[i][j+1];
			}
		}
	
		return paraTodaFila;
	}

	public static void main(String[] args) {
		int[][] mtx = {
				{1,5,6},
				{1,4,6},
				{3,5,1}
			};
		
		int[][] mtx2 = {
				{1,5,6},
				{1,4,6},
				{3,5,10}
			};
		
		int[][] mtx3 = {
				{1,5,6},
				{1,4,6},
				{2,5,1}
			};
		
		int[][] mtx4 = {
				{1,5,6},
				{1,4,6},
				{2,5,11},
				{10,11,15}
			};
		
		
		System.out.println(estrictamenteAscendente(mtx));
		System.out.println(estrictamenteAscendente(mtx2));
		
		System.out.println(parEImpar(mtx)); //false
		
		System.out.println(parEImpar(mtx3)); //true
		
		System.out.println(parEImpar(mtx4)); //true
		
		System.out.println(mayorDiversidad(mtx4));
		System.out.println(mayorDiversidad(mtx));
		
		//lazy ->
		// 
		// false || true || cualquier cosa...
		//paraTodaColumna = paraTodaColumna && parEImpar(mtx, j);

		/*
		 * 
		 *  [1  2  3  5] -> mat.length
			[3  4  5  6]
			[3  4  5  6]
			[1  2  3  5]
		 * 
		 */
		
		int[][] mat = {
				{1,2,3,5},
				{3,4,5,6},
				{3,4,5,6},
				{1,2,3,5}
			};
		
		int[][] mat2 = {
				{1,2,3,5},
				{3,4,5,6},
				{3,2,5,6},
				{1,2,3,5}
			};
		
		System.out.println(esCapicua(mat));
		System.out.print(esCapicua(mat2));

	}

}
