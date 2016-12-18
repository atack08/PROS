package Actividad_15;

import java.io.Serializable;

public class Tenista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4080001111299832337L;
	private String apellido;
	private int altura;
	
	
	public Tenista(String apellido, int altura) {
		super();
		this.apellido = apellido;
		this.altura = altura;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getAltura() {
		return altura;
	}


	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	
	
}
