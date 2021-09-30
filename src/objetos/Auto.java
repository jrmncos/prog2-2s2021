package objetos;

import java.util.ArrayList;

import utils.WriterUtils;

public class Auto {
	private String patente; 
	private String color;
	private String cantidadRuedas;
	
	public static ArrayList<String> colores;
	
	public Auto(String patente, String color) {
		this.patente = patente;
		this.color = color;
	}
	
	public Auto modificarAutoAPartir(String patente, String color) {
		return null;	
	}
	
	private Auto modificarAutoAPartir(String patente) {
		WriterUtils.escribirEnFile(WriterUtils.directorioRoot, patente);
		return null;
	}
	
	private Auto modificarAutoAPartir(Integer cantidadRuedas) {
		return null;
	}
	
	public String dameColor() {
		return color;
	}
	
	public Integer calcularVelocidad() {
		calculoTiempoVelocidad();
		return null;
	}
	
	private void calculoTiempoVelocidad() {
		
	}
	
	public ArrayList<String> posiblesColoresDeUnAuto(){
		return null;
	}
	
	public static Integer cantidadAutosTotales() {
		//
		
		return null;
	}
	
}
