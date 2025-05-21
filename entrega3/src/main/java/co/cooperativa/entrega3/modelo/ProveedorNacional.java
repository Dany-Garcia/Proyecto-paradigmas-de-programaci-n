package co.cooperativa.entrega3.modelo;

import java.io.Serializable;

//Subclase ProveedorNacional que hereda de Proveedor:

/**
 * Representa un proveedor nacional que extiende la clase {@link Proveedor}.
 * <p>
 * Además de los atributos heredados, incluye el RUC (Registro Único de
 * Contribuyentes), un identificador fiscal para proveedores nacionales.
 * <p>
 * Esta clase implementa {@link Serializable} para permitir la serialización de
 * sus objetos.
 */
public class ProveedorNacional extends Proveedor implements Serializable {

	// ATRIBUTO PROPIO de la clase:

	/**
	 * Registro Único de Contribuyentes (RUC) del proveedor nacional.
	 */
	private String ruc;

	// Constructor sobrecargado:

	/**
	 * Crea una nueva instancia de {@code ProveedorNacional} con los datos
	 * especificados.
	 *
	 * @param codigoUnico   Código único del proveedor.
	 * @param nombreEmpresa Nombre de la empresa del proveedor.
	 * @param telefono      Número de teléfono del proveedor.
	 * @param direccion     Dirección del proveedor.
	 * @param ruc           RUC (Registro Único de Contribuyentes) del proveedor
	 *                      nacional.
	 */
	public ProveedorNacional(int codigoUnico, String nombreEmpresa, String telefono, String direccion, String ruc) {
		super(codigoUnico, nombreEmpresa, telefono, direccion);
		this.ruc = ruc;
	}

	// Getters y Setters:

	/**
	 * Obtiene el RUC del proveedor nacional.
	 *
	 * @return RUC del proveedor.
	 */
	public String getRuc() {
		return ruc;
	}

	/**
	 * Establece el RUC del proveedor nacional.
	 *
	 * @param ruc nuevo valor del RUC.
	 */
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	// toString:

	/**
	 * Devuelve una representación en forma de cadena del proveedor nacional,
	 * incluyendo los atributos propios y heredados.
	 *
	 * @return una cadena que representa al proveedor nacional.
	 */
	@Override
	public String toString() {
		return "ProveedorNacional [ruc=" + ruc + ", getCodigoUnico()=" + getCodigoUnico() + ", getNombreEmpresa()="
				+ getNombreEmpresa() + ", getTelefono()=" + getTelefono() + ", getDireccion()=" + getDireccion() + "]";
	}

}
