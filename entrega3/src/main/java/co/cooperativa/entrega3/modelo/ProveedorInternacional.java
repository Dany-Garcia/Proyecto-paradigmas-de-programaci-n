package co.cooperativa.entrega3.modelo;

import java.io.Serializable;

//Subclase ProveedorInternacional que hereda de Proveedor:

/**
 * Representa un proveedor internacional dentro del sistema. Esta clase extiende
 * a {@link Proveedor} e incluye un atributo adicional relacionado con la
 * exportación.
 * <p>
 * Implementa {@link Serializable} para permitir la serialización de instancias.
 */
public class ProveedorInternacional extends Proveedor implements Serializable {

	// ATRIBUTO PROPIO de la clase:

	/**
	 * Código de exportación asociado al proveedor internacional.
	 */
	private String codigoExportado;

	// Constructor sobrecargado:

	/**
	 * Crea una nueva instancia de {@code ProveedorInternacional} con todos los
	 * datos requeridos.
	 *
	 * @param codigoUnico     Código único del proveedor.
	 * @param nombreEmpresa   Nombre de la empresa del proveedor.
	 * @param telefono        Número de teléfono del proveedor.
	 * @param direccion       Dirección del proveedor.
	 * @param codigoExportado Código de exportación del proveedor internacional.
	 */
	public ProveedorInternacional(int codigoUnico, String nombreEmpresa, String telefono, String direccion,
			String codigoExportado) {
		super(codigoUnico, nombreEmpresa, telefono, direccion);
		this.codigoExportado = codigoExportado;
	}

	// Getters y Setters:

	/**
	 * Obtiene el código de exportación del proveedor internacional.
	 *
	 * @return código de exportación.
	 */
	public String getCodigoExportado() {
		return codigoExportado;
	}

	/**
	 * Establece el código de exportación del proveedor internacional.
	 *
	 * @param codigoExportado nuevo código de exportación.
	 */
	public void setCodigoExportado(String codigoExportado) {
		this.codigoExportado = codigoExportado;
	}

	// toString:

	/**
	 * Devuelve una representación en forma de cadena del proveedor internacional,
	 * incluyendo tanto los atributos propios como los heredados.
	 *
	 * @return una cadena que representa al proveedor internacional.
	 */
	@Override
	public String toString() {
		return "ProveedorInternacional [codigoExportado=" + codigoExportado + ", getCodigoUnico()=" + getCodigoUnico()
				+ ", getNombreEmpresa()=" + getNombreEmpresa() + ", getTelefono()=" + getTelefono()
				+ ", getDireccion()=" + getDireccion() + "]";
	}

}
