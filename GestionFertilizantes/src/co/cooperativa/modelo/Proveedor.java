package co.cooperativa.modelo;

import java.io.Serializable;

//Super clase Proveedor:

public class Proveedor implements Serializable{

	// ATRIBUTOS de la clase:

	private int codigoUnico;

	private String nombreEmpresa;

	private String telefono;

	private String direccion;

	// Constructor sobrecargado:

	public Proveedor(int codigoUnico, String nombreEmpresa, String telefono, String direccion) {
		this.codigoUnico = codigoUnico;
		this.nombreEmpresa = nombreEmpresa;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	// Getters y Setters:

	public int getCodigoUnico() {
		return codigoUnico;
	}

	public void setCodigoUnico(int codigoUnico) {
		this.codigoUnico = codigoUnico;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	// toString:

	@Override
	public String toString() {
		return "Proveedor [codigoUnico=" + codigoUnico + ", nombreEmpresa=" + nombreEmpresa + ", telefono=" + telefono
				+ ", direccion=" + direccion + "]";
	}

}
