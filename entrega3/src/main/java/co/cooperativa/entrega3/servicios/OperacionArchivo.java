package co.cooperativa.entrega3.servicios;

import co.cooperativa.entrega3.modelo.Fertilizante;

//Interface OperacionArchivo:

/**
 * Interfaz que define operaciones para la manipulación de archivos relacionados
 * con objetos de tipo {@link Fertilizante}, permitiendo su serialización y
 * deserialización.
 */
public interface OperacionArchivo {

	/**
	 * Serializa un arreglo de objetos {@link Fertilizante} y lo guarda en un
	 * archivo.
	 *
	 * @param fertilizantes el arreglo de fertilizantes a serializar.
	 * @param path          la ruta del directorio donde se almacenará el archivo.
	 * @param name          el nombre del archivo.
	 * @return un mensaje que indica el resultado de la operación de serialización.
	 */
	public String serializar(Fertilizante[] fertilizantes, String path, String name);

	/**
	 * Deserializa un archivo que contiene un arreglo de objetos
	 * {@link Fertilizante}.
	 *
	 * @param path la ruta del directorio donde se encuentra el archivo.
	 * @param name el nombre del archivo.
	 * @return el arreglo de objetos {@link Fertilizante} deserializado desde el
	 *         archivo.
	 */
	public Fertilizante[] deserializar(String path, String name);
}
