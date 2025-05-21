package co.cooperativa.entrega3.modelo;

import java.io.Serializable;

//Clase Cliente:

/**
 * Representa un cliente dentro del sistema de la cooperativa. La clase
 * implementa {@link Serializable} para permitir la persistencia del objeto.
 * 
 * Un cliente puede ser clasificado como minorista o mayorista. Se almacena la
 * cédula, el nombre y un dato de contacto.
 */
public class Cliente implements Serializable {

	// ATRIBUTOS de la clase:

	/**
	 * Cédula del cliente. Es un identificador único.
	 */
	private String cedula;

	/**
	 * Nombre completo del cliente.
	 */
	private String nombre;

	/**
	 * Información de contacto del cliente (teléfono, correo, etc.).
	 */
	private String contacto;

	/**
	 * Indica si el cliente es minorista.
	 */
	private boolean minorita;

	/**
	 * Indica si el cliente es mayorista.
	 */
	private boolean mayorista;

	// Constructor sobrecargado:

	/**
	 * Crea un nuevo objeto {@code Cliente} con los datos proporcionados.
	 *
	 * @param cedula    Cédula del cliente.
	 * @param nombre    Nombre del cliente.
	 * @param contacto  Información de contacto del cliente.
	 * @param minorita  {@code true} si el cliente es minorista, de lo contrario
	 *                  {@code false}.
	 * @param mayorista {@code true} si el cliente es mayorista, de lo contrario
	 *                  {@code false}.
	 */
	public Cliente(String cedula, String nombre, String contacto, boolean minorita, boolean mayorista) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.contacto = contacto;
		this.minorita = minorita;
		this.mayorista = mayorista;
	}

	// Getters y Setters:

	/**
	 * Obtiene la cédula del cliente.
	 * 
	 * @return La cédula del cliente.
	 */
	public String getCedula() {
		return cedula;
	}

	/**
	 * Establece la cédula del cliente.
	 * 
	 * @param cedula La nueva cédula del cliente.
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	/**
	 * Obtiene el nombre del cliente.
	 * 
	 * @return El nombre del cliente.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del cliente.
	 * 
	 * @param nombre El nuevo nombre del cliente.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el contacto del cliente.
	 * 
	 * @return Información de contacto del cliente.
	 */
	public String getContacto() {
		return contacto;
	}

	/**
	 * Establece el contacto del cliente.
	 * 
	 * @param contacto Nueva información de contacto del cliente.
	 */
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	/**
	 * Indica si el cliente es minorista.
	 * 
	 * @return {@code true} si es minorista, de lo contrario {@code false}.
	 */
	public boolean isMinorita() {
		return minorita;
	}

	/**
	 * Establece si el cliente es minorista.
	 * 
	 * @param minorita {@code true} si es minorista, de lo contrario {@code false}.
	 */
	public void setMinorita(boolean minorita) {
		this.minorita = minorita;
	}

	/**
	 * Indica si el cliente es mayorista.
	 * 
	 * @return {@code true} si es mayorista, de lo contrario {@code false}.
	 */
	public boolean isMayorista() {
		return mayorista;
	}

	/**
	 * Establece si el cliente es mayorista.
	 * 
	 * @param mayorista {@code true} si es mayorista, de lo contrario {@code false}.
	 */
	public void setMayorista(boolean mayorista) {
		this.mayorista = mayorista;
	}

	// toString:

	/**
	 * Devuelve una representación en forma de cadena del cliente.
	 * 
	 * @return Una cadena que representa el objeto Cliente.
	 */
	@Override
	public String toString() {
		return "Cliente [cedula=" + cedula + ", nombre=" + nombre + ", contacto=" + contacto + ", minorita=" + minorita
				+ ", mayorista=" + mayorista + "]";
	}

}
