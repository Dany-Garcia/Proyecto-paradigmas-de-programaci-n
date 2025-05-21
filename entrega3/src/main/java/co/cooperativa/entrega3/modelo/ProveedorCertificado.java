package co.cooperativa.entrega3.modelo;

import java.io.Serializable;

//Subsubclase ProveedorCertificado que hereda de ProveedorInternacional:

/**
 * Representa un proveedor certificado que hereda de
 * {@link ProveedorInternacional}. Además de los atributos heredados, incluye
 * información específica sobre la certificación, como el código del certificado
 * y la entidad emisora.
 * <p>
 * Esta clase implementa {@link Serializable} para permitir su persistencia.
 */
public class ProveedorCertificado extends ProveedorInternacional implements Serializable {

	// ATRIBUTOS PROPIOS de la clase:

	/**
	 * Código del certificado otorgado al proveedor.
	 */
	private int codigoCertificado;

	/**
	 * Nombre de la entidad que emitió el certificado.
	 */
	private String entidadEmisora;

	// Constructor sobrecargado:

	/**
	 * Crea una nueva instancia de {@code ProveedorCertificado} con los datos
	 * especificados.
	 *
	 * @param codigoUnico       Código único del proveedor.
	 * @param nombreEmpresa     Nombre de la empresa del proveedor.
	 * @param telefono          Número de teléfono del proveedor.
	 * @param direccion         Dirección del proveedor.
	 * @param codigoExportado   Código de exportación del proveedor internacional.
	 * @param codigoCertificado Código del certificado del proveedor.
	 * @param entidadEmisora    Entidad que emitió el certificado.
	 */
	public ProveedorCertificado(int codigoUnico, String nombreEmpresa, String telefono, String direccion,
			String codigoExportado, int codigoCertificado, String entidadEmisora) {
		super(codigoUnico, nombreEmpresa, telefono, direccion, codigoExportado);
		this.codigoCertificado = codigoCertificado;
		this.entidadEmisora = entidadEmisora;
	}

	// Getters y Setters:

	/**
	 * Obtiene el código del certificado del proveedor.
	 *
	 * @return código del certificado.
	 */
	public int getCodigoCertificado() {
		return codigoCertificado;
	}

	/**
	 * Establece el código del certificado del proveedor.
	 *
	 * @param codigoCertificado nuevo código del certificado.
	 */
	public void setCodigoCertificado(int codigoCertificado) {
		this.codigoCertificado = codigoCertificado;
	}

	/**
	 * Obtiene el nombre de la entidad que emitió el certificado.
	 *
	 * @return entidad emisora del certificado.
	 */
	public String getEntidadEmisora() {
		return entidadEmisora;
	}

	/**
	 * Establece la entidad que emitió el certificado.
	 *
	 * @param entidadEmisora nueva entidad emisora del certificado.
	 */
	public void setEntidadEmisora(String entidadEmisora) {
		this.entidadEmisora = entidadEmisora;
	}

	// toString:

	/**
	 * Devuelve una representación en forma de cadena del proveedor certificado,
	 * incluyendo los atributos heredados.
	 *
	 * @return cadena que representa al proveedor certificado.
	 */
	@Override
	public String toString() {
		return "ProveedorCertificado [codigoCertificado=" + codigoCertificado + ", entidadEmisora=" + entidadEmisora
				+ ", getCodigoExportado()=" + getCodigoExportado() + ", getCodigoUnico()=" + getCodigoUnico()
				+ ", getNombreEmpresa()=" + getNombreEmpresa() + ", getTelefono()=" + getTelefono()
				+ ", getDireccion()=" + getDireccion() + "]";
	}

}
