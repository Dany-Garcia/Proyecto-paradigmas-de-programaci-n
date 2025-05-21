package co.cooperativa.entrega3.servicios;

import co.cooperativa.entrega3.modelo.Fertilizante;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//Clase ImplemetacionCRUD:

/**
 * Clase que implementa las interfaces {@link CRUD} y {@link OperacionArchivo}
 * para gestionar operaciones CRUD y de persistencia sobre objetos de tipo
 * {@link Fertilizante}.
 * <p>
 * Internamente utiliza un arreglo dinámico para almacenar los fertilizantes, y
 * proporciona funciones para serializar y deserializar dichos datos desde/hacia
 * archivos.
 */
public class ImplementacionCRUD implements CRUD, OperacionArchivo {

	// Atributos

	/**
	 * Arreglo de fertilizantes almacenados.
	 */
	private Fertilizante[] fertilizantes;

	/**
	 * Cantidad actual de fertilizantes almacenados (no incluye espacios
	 * {@code null}).
	 */
	private int size;

	/**
	 * Constructor que inicializa el arreglo de fertilizantes con una capacidad
	 * inicial.
	 *
	 * @param capacidadInicial capacidad inicial del arreglo de fertilizantes.
	 */
	public ImplementacionCRUD(int capacidadInicial) {
		fertilizantes = new Fertilizante[capacidadInicial];
		size = 0;
	}

	/**
	 * Expande el arreglo de fertilizantes duplicando su tamaño cuando ya no hay
	 * suficiente espacio para insertar nuevos elementos.
	 * <p>
	 * Este método crea un nuevo arreglo con el doble de capacidad del arreglo
	 * original, copia los elementos del arreglo antiguo al nuevo, y luego asigna el
	 * nuevo arreglo al atributo {@code fertilizantes}.
	 * </p>
	 */
	private void expandArray() {
		Fertilizante[] nuevoArray = new Fertilizante[fertilizantes.length * 2];
		for (int i = 0; i < fertilizantes.length; i++) {
			nuevoArray[i] = fertilizantes[i];
		}
		fertilizantes = nuevoArray;
	}

	// Crear un nuevo fertilizante:

	/**
	 * Agrega un nuevo fertilizante al arreglo.
	 *
	 * @param f el fertilizante a agregar.
	 * @return mensaje indicando el resultado de la operación.
	 */
	@Override
	public String create(Fertilizante f) {
		for (int i = 0; i < fertilizantes.length; i++) {
			if (fertilizantes[i] == null) {
				fertilizantes[i] = f;
				size++;
				return "Fertilizante agregado exitosamente."; // << Solo se ejecuta cuando realmente se inserta
			}
		}
		expandArray();
		fertilizantes[size] = f;
		size++;
		return "Fertilizante agregado exitosamente. El arreglo fue expandido.";
	}

	// Leer un fertilizante específico por su serial:

	/**
	 * Busca y devuelve un fertilizante por su número de serie.
	 *
	 * @param serial número de serie del fertilizante.
	 * @return el fertilizante correspondiente, o {@code null} si no se encuentra.
	 */
	@Override
	public Fertilizante read(int serial) {
		for (int i = 0; i < fertilizantes.length; i++) {
			if (fertilizantes[i] != null && fertilizantes[i].getSerial() == (serial)) {
				return fertilizantes[i];
			}
		}
		return null;
	}

	// Leer todos los fertilizantes:

	/**
	 * Devuelve todos los fertilizantes actualmente almacenados (sin elementos
	 * {@code null}).
	 *
	 * @return un arreglo de fertilizantes existentes.
	 */
	@Override
	public Fertilizante[] readAll() {
		int contador = 0;
		for (int i = 0; i < fertilizantes.length; i++) {
			if (fertilizantes[i] != null) {
				contador++;
			}
		}
		Fertilizante[] resultado = new Fertilizante[contador];
		int j = 0;

		for (int i = 0; i < fertilizantes.length; i++) {
			if (fertilizantes[i] != null) {
				resultado[j] = fertilizantes[i];
				j++;
			}
		}
		return resultado;
	}

	// Actualizar un fertilizante por su serial:

	/**
	 * Reemplaza un fertilizante existente por uno nuevo, identificado por su número
	 * de serie.
	 *
	 * @param serial número de serie del fertilizante a reemplazar.
	 * @param f      nuevo objeto fertilizante.
	 * @return mensaje indicando el resultado de la operación.
	 */
	@Override
	public String update(int serial, Fertilizante f) {
		for (int i = 0; i < fertilizantes.length; i++) {
			if (fertilizantes[i] != null && fertilizantes[i].getSerial() == (serial)) {
				fertilizantes[i] = f;
				return "Fertilizante actualizado exitosamente.";
			}
		}
		return "El fertilizante con serial " + serial + " no ha sido encontrado.";
	}

	// Eliminar un fertilizante por su serial:

	/**
	 * Elimina un fertilizante identificado por su número de serie.
	 *
	 * @param serial número de serie del fertilizante.
	 * @return mensaje indicando el resultado de la operación.
	 */
	@Override
	public String delete(int serial) {
		for (int i = 0; i < fertilizantes.length; i++) {
			if (fertilizantes[i] != null && fertilizantes[i].getSerial() == (serial)) {
				fertilizantes[i] = null;
				size--;
				return "Fertilizante eliminado exitosamente.";
			}
		}
		return "Fertilizante con serial " + serial + " no ha sido encontrado.";
	}

	// Serializar:

	/**
	 * Serializa un arreglo de fertilizantes y lo guarda en un archivo.
	 *
	 * @param fertilizantes el arreglo de fertilizantes a guardar.
	 * @param path          ruta donde se ubicará el archivo.
	 * @param name          nombre del archivo.
	 * @return mensaje indicando el resultado de la operación.
	 */
	@Override
	public String serializar(Fertilizante[] fertilizantes, String path, String name) {
		try {
			FileOutputStream fos = new FileOutputStream(path + name);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(fertilizantes);

			oos.close();
			fos.close();
			return "Archivo guardado exitosamente.";
		} catch (IOException ioe) {
			return "Error al guardar archivo: " + ioe.getMessage();
		}
	}

	// Deserializar:

	/**
	 * Lee un archivo y deserializa su contenido a un arreglo de fertilizantes.
	 *
	 * @param path ruta del archivo.
	 * @param name nombre del archivo.
	 * @return arreglo de fertilizantes deserializado.
	 */
	@Override
	public Fertilizante[] deserializar(String path, String name) {
		Fertilizante[] f = null;
		try {
			FileInputStream fis = new FileInputStream(path + name);
			ObjectInputStream ois = new ObjectInputStream(fis);
			f = (Fertilizante[]) ois.readObject();
			ois.close();
			fis.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
		return f;
	}

	/**
	 * Establece un nuevo arreglo de fertilizantes y actualiza el tamaño.
	 * 
	 * @param fertilizantesDes Nuevo arreglo a establecer.
	 */
	public void setFertilizantes(Fertilizante[] fertilizantesDes) {
		this.fertilizantes = fertilizantesDes;

		int contador = 0;
		for (Fertilizante f : fertilizantesDes) {
			if (f != null) {
				contador++;
			}
		}
		this.size = contador;
	}

}
