package co.cooperativa.entrega3.modelo;

import java.io.Serializable;

//Clase que no se puede heredar RegistroTrazabilidad:

/**
 * Representa un registro de trazabilidad asociado a un lote específico.
 * <p>
 * Esta clase incluye información sobre la fecha de registro y detalles del
 * seguimiento, y utiliza un atributo {@code final} para el lote, lo que
 * garantiza su inmutabilidad.
 * <p>
 * Además, implementa {@link Serializable} para permitir la persistencia de
 * instancias.
 * <p>
 * La clase contiene un método {@code final} que no puede ser sobrescrito y no
 * está diseñada para ser extendida (aunque no es {@code final} como clase, se
 * comporta como tal en práctica).
 */
public class RegistroTrazabilidad implements Serializable {

	// ATRIBUTOS de la clase:

	/**
	 * Identificador del lote al que pertenece el registro de trazabilidad. Este
	 * valor es {@code final}, por lo que no puede ser modificado una vez asignado.
	 */
	private final String loteAsociado; // Atributo final, que no se puede modificar

	/**
	 * Fecha en la que se registró la información de trazabilidad.
	 */
	private String fechaRegistro;

	/**
	 * Información detallada del seguimiento o control del lote.
	 */
	private String infoSeguimiento;

	// Constructor sobrecargado:

	/**
	 * Crea una nueva instancia de {@code RegistroTrazabilidad} con los valores
	 * especificados.
	 *
	 * @param loteAsociado    Lote asociado al registro (valor inmutable).
	 * @param fechaRegistro   Fecha del registro de trazabilidad.
	 * @param infoSeguimiento Información adicional del seguimiento del lote.
	 */
	public RegistroTrazabilidad(String loteAsociado, String fechaRegistro, String infoSeguimiento) {
		this.loteAsociado = loteAsociado;
		this.fechaRegistro = fechaRegistro;
		this.infoSeguimiento = infoSeguimiento;
	}

	// Getters y Setters:

	/**
	 * Obtiene la fecha del registro.
	 *
	 * @return la fecha en que se realizó el registro.
	 */
	public String getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * Establece una nueva fecha para el registro.
	 *
	 * @param fechaRegistro nueva fecha del registro.
	 */
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * Obtiene la información de seguimiento.
	 *
	 * @return los detalles del seguimiento del lote.
	 */
	public String getInfoSeguimiento() {
		return infoSeguimiento;
	}

	/**
	 * Establece nueva información de seguimiento.
	 *
	 * @param infoSeguimiento nueva información de seguimiento.
	 */
	public void setInfoSeguimiento(String infoSeguimiento) {
		this.infoSeguimiento = infoSeguimiento;
	}

	/**
	 * Obtiene el lote asociado al registro.
	 *
	 * @return el identificador del lote.
	 */
	public String getLoteAsociado() {
		return loteAsociado;
	}

	// MÉTODO que no pude sobre escribirse:

	/**
	 * Muestra por consola la información completa del registro de trazabilidad.
	 * Este método es {@code final}, por lo que no puede ser sobrescrito.
	 */
	public final void mostrarInformacion() {
		System.out.println("Lote Asociado: " + loteAsociado);
		System.out.println("Fecha de registro: " + fechaRegistro);
		System.out.println("Información del seguimiento: " + infoSeguimiento);

	}

	// toString:

	/**
	 * Devuelve una representación textual del objeto {@code RegistroTrazabilidad}.
	 *
	 * @return una cadena con el estado de todos los atributos.
	 */
	@Override
	public String toString() {
		return "RegistroTrazabilidad [loteAsociado=" + loteAsociado + ", fechaRegistro=" + fechaRegistro
				+ ", infoSeguimiento=" + infoSeguimiento + "]";
	}

}
