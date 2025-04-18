package co.cooperativa.modelo;

import java.io.Serializable;

//Subclase ProveedorInternacional que hereda de Proveedor:

public class ProveedorInternacional extends Proveedor implements Serializable{

	// ATRIBUTO PROPIO de la clase:
	private String codigoExportado;

	// Constructor sobrecargado:

	public ProveedorInternacional(int codigoUnico, String nombreEmpresa, String telefono, String direccion,
			String codigoExportado) {
		super(codigoUnico, nombreEmpresa, telefono, direccion);
		this.codigoExportado = codigoExportado;
	}

	// Getters y Setters:

	public String getCodigoExportado() {
		return codigoExportado;
	}

	public void setCodigoExportado(String codigoExportado) {
		this.codigoExportado = codigoExportado;
	}

	// toString:

	@Override
	public String toString() {
		return "ProveedorInternacional [codigoExportado=" + codigoExportado + ", getCodigoUnico()=" + getCodigoUnico()
				+ ", getNombreEmpresa()=" + getNombreEmpresa() + ", getTelefono()=" + getTelefono()
				+ ", getDireccion()=" + getDireccion() + "]";
	}

}
