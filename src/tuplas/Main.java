package tuplas;

import java.util.LinkedList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		Tupla<String,String> t1 = new Tupla<String,String>("a","b");
		Tupla<String,String> t2 = new Tupla<String,String>("c","d");
		Coordenada c1 = new Coordenada(1,2);
		Coordenada c2 = new Coordenada(1,2);
//		t1.sumar(t2);
//		c1.sumar(c2);
		Tupla<Integer,Integer> t3 = new Pixel(1,2,3);
		Tupla<Integer,Integer>t4 = new Coordenada(1,2);
		
		if(t3 instanceof Pixel) {
			((Pixel) t3).metodoEspecificoDePixel();
		}
		//t3.sumar(t3);
		//t3.sumar(c2);
		//c2.sumar(t3);

		//System.out.println((String)t1.getE1());
		//System.out.println(c1.getE1());
		
		

		
	}

}
