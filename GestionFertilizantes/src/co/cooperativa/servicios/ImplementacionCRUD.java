package co.cooperativa.servicios;

import co.cooperativa.modelo.Fertilizante;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//Clase ImplemetacionCRUD:
public class ImplementacionCRUD implements CRUD, OperacionArchivo {

	// Atributos
	private Fertilizante[] fertilizantes;
	private int size;

	public ImplementacionCRUD(int capacidadInicial) {
		fertilizantes = new Fertilizante[capacidadInicial];
		size = 0;
	}

	/**
	 * Expande el arreglo de fertilizantes al doble de su tamaño actual cuando ya no
	 * hay espacio disponible para nuevas inserciones.
	 */
	private void expandArray() {
		Fertilizante[] nuevoArray = new Fertilizante[fertilizantes.length * 2];
		for (int i = 0; i < fertilizantes.length; i++) {
			nuevoArray[i] = fertilizantes[i];
		}
		fertilizantes = nuevoArray;
	}

	// Crear un nuevo fertilizante:
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

	// Leer un fertilizante específico:
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

	// Actualizar:
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
	public void setPulseras(Fertilizante[] fertilizantesDes) {
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
