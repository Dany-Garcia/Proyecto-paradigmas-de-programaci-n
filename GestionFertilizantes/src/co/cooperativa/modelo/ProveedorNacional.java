package co.cooperativa.modelo;

import java.io.Serializable;

//Subclase ProveedorNacional que hereda de Proveedor:

public class ProveedorNacional extends Proveedor implements Serializable {

	// ATRIBUTO PROPIO de la clase:
	private String ruc;

	// Constructor sobrecargado:

	public ProveedorNacional(int codigoUnico, String nombreEmpresa, String telefono, String direccion, String ruc) {
		super(codigoUnico, nombreEmpresa, telefono, direccion);
		this.ruc = ruc;
	}

	// Getters y Setters:

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	// toString:

	@Override
	public String toString() {
		return "ProveedorNacional [ruc=" + ruc + ", getCodigoUnico()=" + getCodigoUnico() + ", getNombreEmpresa()="
				+ getNombreEmpresa() + ", getTelefono()=" + getTelefono() + ", getDireccion()=" + getDireccion() + "]";
	}

}
