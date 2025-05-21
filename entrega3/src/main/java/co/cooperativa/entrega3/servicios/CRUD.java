package co.cooperativa.entrega3.servicios;

import co.cooperativa.entrega3.modelo.Fertilizante;

//Interface CRUD:

/**
 * Interfaz que define las operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * para objetos de tipo {@link Fertilizante}.
 * <p>
 * Esta interfaz establece el contrato que deben implementar las clases de
 * servicio que gestionen fertilizantes dentro del sistema.
 */
public interface CRUD {

	/**
	 * Crea un nuevo fertilizante en el sistema.
	 *
	 * @param f el objeto {@link Fertilizante} a ser creado.
	 * @return un mensaje que indica el resultado de la operación.
	 */
	String create(Fertilizante f);

	/**
	 * Recupera un fertilizante según su número de serie.
	 *
	 * @param serial el número de serie del fertilizante a buscar.
	 * @return el objeto {@link Fertilizante} correspondiente, o {@code null} si no
	 *         se encuentra.
	 */
	Fertilizante read(int serial);

	/**
	 * Recupera todos los fertilizantes registrados en el sistema.
	 *
	 * @return un arreglo de objetos {@link Fertilizante}.
	 */
	Fertilizante[] readAll();

	/**
	 * Actualiza un fertilizante existente identificado por su número de serie.
	 *
	 * @param serial el número de serie del fertilizante a actualizar.
	 * @param f      el objeto {@link Fertilizante} con los datos actualizados.
	 * @return un mensaje que indica el resultado de la operación.
	 */
	String update(int serial, Fertilizante f);

	/**
	 * Elimina un fertilizante del sistema usando su número de serie.
	 *
	 * @param serial el número de serie del fertilizante a eliminar.
	 * @return un mensaje que indica el resultado de la eliminación.
	 */
	String delete(int serial);

}
