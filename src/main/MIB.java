package main;

import java.util.HashSet;

public class MIB{
	private HashSet<Coordenada> _valoresT;
	
	public boolean leer(int i, int j) {
		return _valoresT.contains(new Coordenada(i,j));
	}

	public void escribir(int i, int j, boolean valor){	
		if(leer(i, j)) {
			if(!valor){
				_valoresT.remove(new Coordenada(i,j));
			}
		}
		else {
			if(valor)
				_valoresT.add(new Coordenada(i,j));
		}
	}
			
}

//Estructura de datos inicial, no funciona
//private Boolean [][] mat;
//
//estrategia: almacenar solo los valores definidos/ o verdaderos
//¿que hacemos si nos preguntan un valor no definido?


// si almaceno todo
//Map<<Coordenada>, Boolean>
//// si almaceno solo los T
//HashSet<Coordenada>
// Coordenada deberia implementar la funcion de hash

//ArrayList<Coordenada> y controlan la repeticion a mano, vamos bien


//MIB m  = new MIB(44444,2000)
//m.escribir(25555552,2555555552,false)  // viola el irep


//Class MIB  
//Int _ancho
//Int _alto
//HashSet<Coordenada> _valoresT
//
//IREP:
//// estamos en rango
//para toda coordenada en _valoreT   la coordenada entra en _ancho y _largo
//// todas las coordendas representan valores true



//MIB(int ancho, int alto)
//	_ancho = ancho
//	_alto = alto








