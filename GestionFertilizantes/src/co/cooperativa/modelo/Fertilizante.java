package co.cooperativa.modelo;

import java.util.Arrays;
import java.io.Serializable;

//Clase con mayor jerarquia Fertlizante:

/** ... */
public class Fertilizante implements Serializable {

	// ATRIBUTOS de la clase:

	/** ... */
	public static final String proveniencia = "Colombia";

	/** Serial sirve como identificador único de un... */
	private int serial;

	/** ... */
	private String nombre;

	/** ... */
	private String tipo;

	/** Precio base del fertilizante. */
	private double precio;

	/** ... */
	private String fechaAdquisicion;

	/** ... */
	private double cantidadDisponible;

	/** ... */
	private Cliente cliente;

	/** ... */
	private Proveedor proveedor;

	/** Arreglo de los registros de trazabilidad que puede tener el fertilizante. */
	private RegistroTrazabilidad[] registroTrazabilidad;

	// Constructor sobrecargado:
	
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

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getFechaAdquisicion() {
		return fechaAdquisicion;
	}

	public void setFechaAdquisicion(String fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}

	public double getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(double cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public RegistroTrazabilidad[] getRegistroTrazabilidad() {
		return registroTrazabilidad;
	}

	public void setRegistroTrazabilidad(RegistroTrazabilidad[] registroTrazabilidad) {
		this.registroTrazabilidad = registroTrazabilidad;
	}

	public static String getProveniencia() {
		return proveniencia;
	}

	// MÉTODOS:

	/** ... */
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

	/** ... */
	protected String personalizarEtiqueta(String info) {
		return "Etiqueta: " + info;
	}

	/** ... */
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
	
	@Override
	public String toString() {
		return "Fertilizante [serial=" + serial + ", nombre=" + nombre + ", tipo=" + tipo + ", precio=" + precio
				+ ", fechaAdquisicion=" + fechaAdquisicion + ", cantidadDisponible=" + cantidadDisponible + ", cliente="
				+ cliente + ", proveedor=" + proveedor + ", registroTrazabilidad="
				+ Arrays.toString(registroTrazabilidad) + "]";
	}

}
