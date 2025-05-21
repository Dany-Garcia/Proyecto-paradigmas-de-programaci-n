package co.cooperativa.entrega3.modelo;

import java.io.Serializable;

//Super clase Proveedor:

/**
 * Representa un proveedor dentro del sistema de la cooperativa. Un proveedor
 * está identificado por un código único y contiene información relacionada con
 * su empresa, como el nombre, teléfono y dirección.
 * <p>
 * Esta clase implementa {@link Serializable} para permitir la serialización de
 * objetos.
 */
public class Proveedor implements Serializable {

	// ATRIBUTOS de la clase:

	/**
	 * Código único que identifica al proveedor.
	 */
	private int codigoUnico;

	/**
	 * Nombre de la empresa del proveedor.
	 */
	private String nombreEmpresa;

	/**
	 * Número de teléfono del proveedor.
	 */
	private String telefono;

	/**
	 * Dirección física de la empresa del proveedor.
	 */
	private String direccion;

	// Constructor sobrecargado:

	/**
	 * Crea una nueva instancia de {@code Proveedor} con los datos especificados.
	 *
	 * @param codigoUnico   Código único del proveedor.
	 * @param nombreEmpresa Nombre de la empresa del proveedor.
	 * @param telefono      Número de teléfono del proveedor.
	 * @param direccion     Dirección del proveedor.
	 */
	public Proveedor(int codigoUnico, String nombreEmpresa, String telefono, String direccion) {
		this.codigoUnico = codigoUnico;
		this.nombreEmpresa = nombreEmpresa;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	// Getters y Setters:

	/**
	 * Obtiene el código único del proveedor.
	 *
	 * @return código único del proveedor.
	 */
	public int getCodigoUnico() {
		return codigoUnico;
	}

	/**
	 * Establece el código único del proveedor.
	 *
	 * @param codigoUnico nuevo código único.
	 */
	public void setCodigoUnico(int codigoUnico) {
		this.codigoUnico = codigoUnico;
	}

	/**
	 * Obtiene el nombre de la empresa del proveedor.
	 *
	 * @return nombre de la empresa.
	 */
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	/**
	 * Establece el nombre de la empresa del proveedor.
	 *
	 * @param nombreEmpresa nuevo nombre de la empresa.
	 */
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	/**
	 * Obtiene el número de teléfono del proveedor.
	 *
	 * @return número de teléfono.
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Establece el número de teléfono del proveedor.
	 *
	 * @param telefono nuevo número de teléfono.
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Obtiene la dirección del proveedor.
	 *
	 * @return dirección del proveedor.
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Establece la dirección del proveedor.
	 *
	 * @param direccion nueva dirección del proveedor.
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	// toString:

	/**
	 * Devuelve una representación en forma de cadena del proveedor.
	 *
	 * @return una cadena con los valores de los atributos del proveedor.
	 */
	@Override
	public String toString() {
		return "Proveedor [codigoUnico=" + codigoUnico + ", nombreEmpresa=" + nombreEmpresa + ", telefono=" + telefono
				+ ", direccion=" + direccion + "]";
	}

}
