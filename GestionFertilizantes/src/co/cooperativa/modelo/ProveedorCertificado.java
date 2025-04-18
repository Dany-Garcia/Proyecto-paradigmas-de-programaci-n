package co.cooperativa.modelo;

import java.io.Serializable;

//Subsubclase ProveedorCertificado que hereda de ProveedorInternacional:

public class ProveedorCertificado extends ProveedorInternacional implements Serializable{

	// ATRIBUTOS PROPIOS de la clase:

	private int codigoCertificado;
	private String entidadEmisora;

	// Constructor sobrecargado:

	public ProveedorCertificado(int codigoUnico, String nombreEmpresa, String telefono, String direccion,
			String codigoExportado, int codigoCertificado, String entidadEmisora) {
		super(codigoUnico, nombreEmpresa, telefono, direccion, codigoExportado);
		this.codigoCertificado = codigoCertificado;
		this.entidadEmisora = entidadEmisora;
	}

	// Getters y Setters:

	public int getCodigoCertificado() {
		return codigoCertificado;
	}

	public void setCodigoCertificado(int codigoCertificado) {
		this.codigoCertificado = codigoCertificado;
	}

	public String getEntidadEmisora() {
		return entidadEmisora;
	}

	public void setEntidadEmisora(String entidadEmisora) {
		this.entidadEmisora = entidadEmisora;
	}

	// toString:

	@Override
	public String toString() {
		return "ProveedorCertificado [codigoCertificado=" + codigoCertificado + ", entidadEmisora=" + entidadEmisora
				+ ", getCodigoExportado()=" + getCodigoExportado() + ", getCodigoUnico()=" + getCodigoUnico()
				+ ", getNombreEmpresa()=" + getNombreEmpresa() + ", getTelefono()=" + getTelefono()
				+ ", getDireccion()=" + getDireccion() + "]";
	}

}
