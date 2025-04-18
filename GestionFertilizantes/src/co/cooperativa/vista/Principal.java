package co.cooperativa.vista;

import java.util.Arrays;
import java.util.Scanner;
import co.cooperativa.modelo.*;
import co.cooperativa.servicios.ImplementacionCRUD;

//Clase Principal (main).

public class Principal {
	public static void main(String[] args) {

		// Objetos por defecto:
		Cliente cliente = new Cliente("1022552191", "Antonio Reyes", "3401234578", false, true);
		RegistroTrazabilidad registroTrazabilidad = new RegistroTrazabilidad("RF. 21", "29/02/2025", "Canal Mensual");
		Proveedor proveedor = new Proveedor(321, "New Millenium", "7098765", "\"Isla Fantasía, Pacífico colombiano");
		ProveedorInternacional proveedorInternacional = new ProveedorInternacional(456, " Fertilizer Storage – Francia",
				"7023310", "Rue des Champs 42, 21110 Genlis, France", "FR-FERT-2025A");
		ProveedorNacional proveedorNacional = new ProveedorNacional(789, "La Llanura S.A.S.", "310 456 7890",
				"Km 2 Vía Villavicencio - Puerto López", "901.456.789-5");
		ProveedorCertificado proveedorCertificado = new ProveedorCertificado(0, "AgroFert Global S.A", "1145678901",
				"Calle de la Agricultura 1025", "AR-FERT-2025B", 123, "Cámara Argentina de Exportadores (CAE)");
		Fertilizante fertilizante = new Fertilizante(1000, "Fertilizante Foliar", "Transparente", 111.100, "11/04/2025",
				47.5, cliente, proveedor, new RegistroTrazabilidad[] { registroTrazabilidad });

		
		Scanner sc = new Scanner(System.in);
		// Ruta y archivo / Configuración inicial
		String path = "";
		String file = "TextBinary.txt";

		// Crear el CRUD con capacidad inicial de 5
		ImplementacionCRUD crud = new ImplementacionCRUD(5); // Arreglo inicial de tamaño 5

		// Crear algunos fertilizantes por defecto
		Fertilizante f1 = new Fertilizante(1001, "Fertilizante Orgánico", "Verde", 70.600, "11/11/2025", 45.5, cliente,
				proveedor, new RegistroTrazabilidad[] { registroTrazabilidad });
		Fertilizante f2 = new Fertilizante(1002, "Fertilizante Mineral", "Blanco", 75.8000, "30/04/2025", 50.0, cliente,
				proveedor, new RegistroTrazabilidad[] { registroTrazabilidad });
		Fertilizante f3 = new Fertilizante(1003, "Compost", "Café", 77.500, "07/07/2025", 50.5, cliente, proveedor,
				new RegistroTrazabilidad[] { registroTrazabilidad });
		Fertilizante f4 = new Fertilizante(1004, "Humus de Lombriz", "Negro", 65.300, "03/07/2025", 48.0, cliente,
				proveedor, new RegistroTrazabilidad[] { registroTrazabilidad });
		Fertilizante f5 = new Fertilizante(1005, "Fertilizante Líquido", "Azul", 80.250, "28/11/2025", 52.5, cliente,
				proveedor, new RegistroTrazabilidad[] { registroTrazabilidad });

		System.out.println(crud.create(f1));
		System.out.println(crud.create(f2));
		System.out.println(crud.create(f3));
		System.out.println(crud.create(f4));
		System.out.println(crud.create(f5));

		int opcion;

		do {
			System.out.println("\n--- MENÚ FERTILIZANTES ---");
			System.out.println("1. Crear Fertilizante");
			System.out.println("2. Ver Todos");
			System.out.println("3. Actualizar Fertilizante");
			System.out.println("4. Eliminar Fertilizante");
			System.out.println("5. Buscar por Serial");
			System.out.println("6. Guardar en Archivo");
			System.out.println("7. Cargar desde Archivo");
			System.out.println("8. Salir");
			System.out.print("Seleccione una opción: ");
			opcion = sc.nextInt();
			sc.nextLine(); // Limpiar buffer

			switch (opcion) {
			case 1:
				System.out.print("Serial (int): ");
				int serial = sc.nextInt();
				sc.nextLine();
				System.out.print("Nombre(String: ");
				String nombre = sc.nextLine();
				System.out.print("tipo (String): ");
				String tipo = sc.nextLine();
				System.out.print("Precio (double): ");
				double precio = sc.nextDouble();
				sc.nextLine();

				Fertilizante nuevo = new Fertilizante(serial, nombre, tipo, precio, "20/06/2025", 20.5, cliente,
						proveedor, new RegistroTrazabilidad[] { registroTrazabilidad });

				System.out.println(crud.create(nuevo));
				break;

			case 2:
				Fertilizante[] fertilizantes = crud.readAll();
				System.out.println("--- FERTILIZANTES REGISTRADOS ---");

				for (Fertilizante f : fertilizantes) {
					if (f != null) {
						System.out.println(f);
					}
				}
				break;

			case 3:
				System.out.print("Ingrese el serial del fertilizante a actualizar: ");
				int serialAct = sc.nextInt();
				sc.nextLine();
				Fertilizante fertilizanteActual = crud.read(serialAct);
				if (fertilizanteActual != null) {
					System.out.print("Nuevo Nombre: ");
					String nuevoNombre = sc.nextLine();
					System.out.print("Nuevo tipo: ");
					String nuevoTipo = sc.nextLine();
					System.out.print("Nuevo Precio: ");
					double nuevoPrecio = sc.nextDouble();
					sc.nextLine();

					Fertilizante actualizado = new Fertilizante(serialAct, nuevoNombre, nuevoTipo, nuevoPrecio,
							"20/06/2025", 20.5, cliente, proveedor,
							new RegistroTrazabilidad[] { registroTrazabilidad });

					System.out.println(crud.update(serialAct, actualizado));
				} else {
					System.out.println("Fertilizante no encontrada.");
				}
				break;

			case 4:
				System.out.print("Ingrese el serial del fertilizante a eliminar: ");
				int serialDel = sc.nextInt();
				System.out.println(crud.delete(serialDel));
				break;

			case 5:
				System.out.print("Ingrese el serial a buscar: ");
				int serialBuscar = sc.nextInt();
				sc.nextLine();
				Fertilizante buscado = crud.read(serialBuscar);
				if (buscado != null) {
					System.out.println("Fertilizante encontrado: " + buscado);
				} else {
					System.out.println("No se encontró un fertilizante con ese serial.");
				}
				break;

			case 6:
				System.out.println("Antes de guardar archivo:");
				System.out.println(Arrays.toString(crud.readAll()));

				// Almacena en archivo solo las pulseras no nulas
				String resultado = crud.serializar(crud.readAll(), path, file);

				System.out.println("Guardando pulseras en archivo...");
				System.out.println(resultado);
				break;

			case 7:
				System.out.println("Leyendo pulseras desde archivo...");
				Fertilizante[] fertilizantesDes = crud.deserializar(path, file);

				crud.setPulseras(fertilizantesDes); // actualizamos estructura
				System.out.println("Fertilizantes cargados exitosamente.");

				System.out.println("Pulseras leídas: " + Arrays.toString(fertilizantesDes));

				break;

			case 8:
				System.out.println("¡Hasta luego!");
				break;

			default:
				System.out.println("Opción no válida. Intente de nuevo.");
			}

		} while (opcion != 8);

		sc.close();
	}

}
