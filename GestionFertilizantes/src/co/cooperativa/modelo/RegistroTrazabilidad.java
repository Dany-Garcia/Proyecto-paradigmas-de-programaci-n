package co.cooperativa.modelo;

import java.io.Serializable;

//Clase que no se puede heredar RegistroTrazabilidad:

public class RegistroTrazabilidad implements Serializable {

	// ATRIBUTOS de la clase:

	/** ... */
	private final String loteAsociado; // Atributo final, que no se puede modificar

	/** ... */
	private String fechaRegistro;

	/** ... */
	private String infoSeguimiento;

	// Constructor sobrecargado:

	public RegistroTrazabilidad(String loteAsociado, String fechaRegistro, String infoSeguimiento) {
		this.loteAsociado = loteAsociado;
		this.fechaRegistro = fechaRegistro;
		this.infoSeguimiento = infoSeguimiento;
	}

	// Getters y Setters:

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getInfoSeguimiento() {
		return infoSeguimiento;
	}

	public void setInfoSeguimiento(String infoSeguimiento) {
		this.infoSeguimiento = infoSeguimiento;
	}

	public String getLoteAsociado() {
		return loteAsociado;
	}

	// MÉTODO que no pude sobre escribirse:

	public final void mostrarInformacion() {
		System.out.println("Lote Asociado: " + loteAsociado);
		System.out.println("Fecha de registro: " + fechaRegistro);
		System.out.println("Información del seguimiento: " + infoSeguimiento);

	}

	// toString:

	@Override
	public String toString() {
		return "RegistroTrazabilidad [loteAsociado=" + loteAsociado + ", fechaRegistro=" + fechaRegistro
				+ ", infoSeguimiento=" + infoSeguimiento + "]";
	}

}
