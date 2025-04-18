package co.cooperativa.modelo;

import java.io.Serializable;

//Clase Cliente:

public class Cliente implements Serializable {

	// ATRIBUTOS de la clase:

	private String cedula;

	private String nombre;

	private String contacto;

	private boolean minorita;

	private boolean mayorista;

	// Constructor sobrecargado:

	public Cliente(String cedula, String nombre, String contacto, boolean minorita, boolean mayorista) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.contacto = contacto;
		this.minorita = minorita;
		this.mayorista = mayorista;
	}

	// Getters y Setters:

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public boolean isMinorita() {
		return minorita;
	}

	public void setMinorita(boolean minorita) {
		this.minorita = minorita;
	}

	public boolean isMayorista() {
		return mayorista;
	}

	public void setMayorista(boolean mayorista) {
		this.mayorista = mayorista;
	}

	// toString:

	@Override
	public String toString() {
		return "Cliente [cedula=" + cedula + ", nombre=" + nombre + ", contacto=" + contacto + ", minorita=" + minorita
				+ ", mayorista=" + mayorista + "]";
	}

}
