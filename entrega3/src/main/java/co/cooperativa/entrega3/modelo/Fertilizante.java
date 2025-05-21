package co.cooperativa.entrega3.modelo;

import java.util.Arrays;
import java.io.Serializable;

//Clase con mayor jerarquia Fertilizante:

/**
 * Representa un fertilizante dentro del sistema de la cooperativa. Esta clase
 * contiene atributos que permiten identificar y gestionar un fertilizante, como
 * su nombre, tipo, precio, fecha de adquisición, cantidad disponible, el
 * cliente asociado, proveedor asociado y los registros de trazabilidad
 * asociados.
 * 
 * Implementa {@link Serializable} para permitir su persistencia.
 */
public class Fertilizante implements Serializable {

	// ATRIBUTOS de la clase:

	/**
	 * Serial sirve como identificador único del Fertilizante
	 */
	private int serial;

	/**
	 * Nombre del fertilizante.
	 */
	private String nombre;

	/**
	 * Tipo del fertilizante (por ejemplo: orgánico, químico, etc.).
	 */
	private String tipo;

	/** Precio base del fertilizante. */
	private double precio;

	/**
	 * Fecha de adquisición del fertilizante.
	 */
	private String fechaAdquisicion;

	/**
	 * Cantidad disponible del fertilizante en el inventario.
	 */
	private double cantidadDisponible;

	/**
	 * Cliente asociado a la adquisición del fertilizante.
	 */
	private Cliente cliente;

	/**
	 * Proveedor asociado que suministró el fertilizante.
	 */
	private Proveedor proveedor;

	/** Arreglo de los registros de trazabilidad que puede tener el fertilizante. */
	private RegistroTrazabilidad[] registroTrazabilidad;

	// Constructor sobrecargado:

	/**
	 * Crea una nueva instancia de {@code Fertilizante} con todos sus atributos.
	 *
	 * @param serial               Identificador único.
	 * @param nombre               Nombre del fertilizante.
	 * @param tipo                 Tipo de fertilizante.
	 * @param precio               Precio base.
	 * @param fechaAdquisicion     Fecha de adquisición.
	 * @param cantidadDisponible   Cantidad disponible.
	 * @param cliente              Cliente asociado.
	 * @param proveedor            Proveedor asignado.
	 * @param registroTrazabilidad Arreglo de registros de trazabilidad.
	 */
	public Fertilizante(int serial, String nombre, String tipo, double precio, String fechaAdquisicion,
			double cantidadDisponible, Cliente cliente, Proveedor proveedor,
			RegistroTrazabilidad[] registroTrazabilidad) {
		this.serial = serial;
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
		this.fechaAdquisicion = fechaAdquisicion;
		this.cantidadDisponible = cantidadDisponible;
		this.cliente = cliente;
		this.proveedor = proveedor;
		this.registroTrazabilidad = registroTrazabilidad;
	}

	// Getters y Setters:

	/**
	 * Obtiene el identificador único del fertilizante.
	 *
	 * @return serial del fertilizante.
	 */
	public int getSerial() {
		return serial;
	}

	/**
	 * Establece el identificador único del fertilizante.
	 *
	 * @param serial nuevo valor del identificador.
	 */
	public void setSerial(int serial) {
		this.serial = serial;
	}

	/**
	 * Obtiene el nombre del fertilizante.
	 *
	 * @return nombre del fertilizante.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del fertilizante.
	 *
	 * @param nombre nuevo nombre del fertilizante.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el tipo del fertilizante.
	 *
	 * @return tipo del fertilizante.
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Establece el tipo del fertilizante.
	 *
	 * @param tipo nuevo tipo del fertilizante.
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Obtiene el precio base del fertilizante.
	 *
	 * @return precio del fertilizante.
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Establece el precio base del fertilizante.
	 *
	 * @param precio nuevo precio del fertilizante.
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Obtiene la fecha de adquisición del fertilizante.
	 *
	 * @return fecha de adquisición.
	 */
	public String getFechaAdquisicion() {
		return fechaAdquisicion;
	}

	/**
	 * Establece la fecha de adquisición del fertilizante.
	 *
	 * @param fechaAdquisicion nueva fecha de adquisición.
	 */
	public void setFechaAdquisicion(String fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}

	/**
	 * Obtiene la cantidad disponible del fertilizante.
	 *
	 * @return cantidad disponible.
	 */
	public double getCantidadDisponible() {
		return cantidadDisponible;
	}

	/**
	 * Establece la cantidad disponible del fertilizante.
	 *
	 * @param cantidadDisponible nueva cantidad disponible.
	 */
	public void setCantidadDisponible(double cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	/**
	 * Obtiene el cliente asociado al fertilizante.
	 *
	 * @return cliente.
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Establece el cliente asociado al fertilizante.
	 *
	 * @param cliente nuevo cliente.
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	/**
	 * Obtiene el proveedor asoicado del fertilizante.
	 *
	 * @return proveedor.
	 */
	public Proveedor getProveedor() {
		return proveedor;
	}

	/**
	 * Establece el proveedor del fertilizante.
	 *
	 * @param proveedor nuevo proveedor.
	 */
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	/**
	 * Obtiene el arreglo de registros de trazabilidad del fertilizante.
	 *
	 * @return arreglo de {@link RegistroTrazabilidad}.
	 */
	public RegistroTrazabilidad[] getRegistroTrazabilidad() {
		return registroTrazabilidad;
	}

	/**
	 * Establece el arreglo de registros de trazabilidad del fertilizante.
	 *
	 * @param registroTrazabilidad nuevo arreglo de trazabilidad.
	 */
	public void setRegistroTrazabilidad(RegistroTrazabilidad[] registroTrazabilidad) {
		this.registroTrazabilidad = registroTrazabilidad;
	}

	// MÉTODOS:

	/**
	 * Calcula el precio total sumando un valor al precio base del fertilizante.
	 *
	 * @param total valor a sumar al precio base.
	 * @return precio total.
	 */
	public double calcularPrecioTotal(double total) {
		return precio + total;
	}

	/**
	 * Verifica si la cantidad disponible del fertilizante es menor o igual al
	 * umbral mínimo especificado.
	 *
	 * @param umbral el valor mínimo permitido de stock para el fertilizante.
	 * @return {@code true} si la cantidad disponible es menor o igual al umbral,
	 *         {@code false} en caso contrario.
	 */
	public boolean verificarStockMinimo(double umbral) {
		return this.cantidadDisponible <= umbral;
	}

	// MÉTODOS SOBRECARGADOS:

	/**
	 * Devuelve una etiqueta personalizada con la información proporcionada.
	 *
	 * @param info información a incluir en la etiqueta.
	 * @return etiqueta personalizada.
	 */
	protected String personalizarEtiqueta(String info) {
		return "Etiqueta: " + info;
	}

	/**
	 * Devuelve una etiqueta personalizada con estilo y la información
	 * proporcionada.
	 *
	 * @param info   información a incluir en la etiqueta.
	 * @param estilo estilo a aplicar a la etiqueta.
	 * @return etiqueta personalizada con estilo.
	 */
	protected String personalizarEtiqueta(String info, String estilo) {
		return "Etiqueta: " + info + " en estilo " + estilo;
	}

	// MÉTODOS ESPECIALES:

	/**
	 * Asigna un proveedor al fertilizante.
	 *
	 * @param proveedor el proveedor a asignar
	 */
	public void asignarProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
		System.out.println("Proveedor asignado: " + proveedor.getNombreEmpresa());
	}

	/**
	 * Retorna el proveedor asignado al fertilizante.
	 *
	 * @return el objeto Proveedor
	 */
	public Proveedor obtenerProveedor() {
		return this.proveedor;
	}

	// toString:

	/**
	 * Devuelve una representación en forma de cadena del objeto fertilizante.
	 *
	 * @return una cadena con los valores de los atributos del fertilizante.
	 */
	@Override
	public String toString() {
		return "Fertilizante [serial=" + serial + ", nombre=" + nombre + ", tipo=" + tipo + ", precio=" + precio
				+ ", fechaAdquisicion=" + fechaAdquisicion + ", cantidadDisponible=" + cantidadDisponible + ", cliente="
				+ cliente + ", proveedor=" + proveedor + ", registroTrazabilidad="
				+ Arrays.toString(registroTrazabilidad) + "]";
	}

}
