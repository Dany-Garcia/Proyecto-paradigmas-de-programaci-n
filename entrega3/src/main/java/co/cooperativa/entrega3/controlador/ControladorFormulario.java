package co.cooperativa.entrega3.controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import co.cooperativa.entrega3.modelo.Fertilizante;
import co.cooperativa.entrega3.modelo.Cliente;
import co.cooperativa.entrega3.modelo.RegistroTrazabilidad;
import co.cooperativa.entrega3.modelo.Proveedor;
import co.cooperativa.entrega3.modelo.ProveedorNacional;
import co.cooperativa.entrega3.modelo.ProveedorInternacional;
import co.cooperativa.entrega3.modelo.ProveedorCertificado;
import co.cooperativa.entrega3.servicios.ImplementacionCRUD;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

//Clase ControladorFormulario:

/**
 * ControladorFormulario es una clase controladora encargada de gestionar la
 * lógica de la interfaz gráfica del formulario principal para el manejo de
 * fertilizantes en una cooperativa agrícola.
 * 
 * Se encarga de realizar operaciones CRUD (crear, leer, actualizar y eliminar)
 * sobre objetos de tipo {@link Fertilizante}, además de gestionar la selección
 * de proveedores (nacionales, internacionales o certificado), así como
 * registros de trazabilidad y cliente.
 * 
 * Implementa la interfaz {@link javafx.fxml.Initializable} para inicializar los
 * componentes de la interfaz luego de que el FXML ha sido cargado.
 * 
 * Controla eventos de botones, ComboBoxes, CheckBoxes y otros elementos
 * visuales. Utiliza {@link ImplementacionCRUD} como backend para las
 * operaciones persistentes.
 * 
 * Campos principales manejados:
 * <ul>
 * <li>Botones de CRUD y serialización</li>
 * <li>ComboBoxes para selección de proveedor y certificado</li>
 * <li>Campos de texto para entrada de datos</li>
 * <li>CheckBoxes para selección de registros de trazabilidad</li>
 * <li>TableView para visualización de objetos fertilizante creados</li>
 * </ul>
 * 
 * Métodos principales:
 * <ul>
 * <li>{@code initialize}: Configura la interfaz al iniciar.</li>
 * <li>{@code create}: Crea un nuevo fertilizante.</li>
 * <li>{@code read}: Busca y muestra un fertilizante por su serial.</li>
 * <li>{@code update}: Actualiza un fertilizante existente.</li>
 * <li>{@code delete}: Elimina un fertilizante existente.</li>
 * <li>{@code onTipoProveedorSeleccionado}: Controla la lógica de tipo de
 * proveedor.</li>
 * <li>{@code onCertificadoSeleccionado}: Controla la lógica de proveedor
 * certificado.</li>
 * </ul>
 * 
 * @author Daniel Garcia
 * @since  21/05/2025
 * 
 */
public class ControladorFormulario implements Initializable{

	/** Botón para eliminar un fertilizante. */
	@FXML
	private Button btDelete;

	/** Botón para crear un nuevo fertilizante. */
	@FXML
	private Button bttCreate;

	/** Botón para deserializar los datos almacenados. */
	@FXML
	private Button bttDeserealizar;

	/** Botón para leer un fertilizante por su serial. */
	@FXML
	private Button bttRead;

	/** Botón para serializar los datos de fertilizantes. */
	@FXML
	private Button bttSerializar;

	/** Botón para actualizar un fertilizante existente. */
	@FXML
	private Button bttUpdate;

	/** Checkbox para indicar si se incluye un cliente. */
	@FXML
	private CheckBox chkboxCliente;

	/** Checkbox para seleccionar registro de trazabilidad de tipo interna. */
	@FXML
	private CheckBox chkboxInterna;

	/** Checkbox para seleccionar registro de trazabilidad de tipo prospectiva. */
	@FXML
	private CheckBox chkboxProspectiva;

	/** Checkbox para seleccionar registro de trazabilidad de tipo retrospectiva. */
	@FXML
	private CheckBox chkboxRetrospectiva;

	/**
	 * Columna que muestra el número de serial único del fertilizante en la tabla.
	 */
	@FXML
	private TableColumn<Fertilizante, String> column1;

	/**
	 * Columna que muestra el nombre del fertilizante en la tabla.
	 */
	@FXML
	private TableColumn<Fertilizante, String> column2;

	/**
	 * Columna que muestra el tipo de fertilizante.
	 */
	@FXML
	private TableColumn<Fertilizante, String> column3;

	/**
	 * Columna que muestra el precio unitario del fertilizante.
	 */
	@FXML
	private TableColumn<Fertilizante, String> column4;

	/**
	 * Columna que muestra la fecha de adquisición del fertilizante.
	 */
	@FXML
	private TableColumn<Fertilizante, String> column5;

	/**
	 * Columna que muestra la cantidad disponible del fertilizante.
	 */
	@FXML
	private TableColumn<Fertilizante, String> column6;

	/**
	 * Columna que muestra la información del cliente asociado al fertilizante.
	 */
	@FXML
	private TableColumn<Fertilizante, String> column7;

	/**
	 * Columna que muestra la información del proveedor asociado al fertilizante.
	 */
	@FXML
	private TableColumn<Fertilizante, String> column8;

	/**
	 * Columna que muestra los registros de trazabilidad del fertilizante
	 * (Retrospectiva, Interna, Prospectiva.).
	 */
	@FXML
	private TableColumn<Fertilizante, String> column9;

	/** Tabla que muestra los fertilizantes registrados. */
	@FXML
	private TableView<Fertilizante> tblView;

	/** ComboBox para seleccionar el tipo de proveedor. */
	@FXML
	private ComboBox<String> comboProveedor;

	/**
	 * ComboBox para seleccionar si el proveedor internacional tiene certificación.
	 */
	@FXML
	private ComboBox<String> comboCertificado;

	/** Etiqueta que muestra la cantidad disponible del fertilizante. */
	@FXML
	private Label lblCntDisponible;

	/** Etiqueta que muestra la fecha de adquisición del fertilizante. */
	@FXML
	private Label lblFechaAdquisicion;

	/** Etiqueta que muestra el nombre del fertilizante. */
	@FXML
	private Label lblNombre;

	/** Etiqueta que muestra el precio del fertilizante. */
	@FXML
	private Label lblPrecio;

	/** Etiqueta que muestra el proveedor del fertilizante. */
	@FXML
	private Label lblProveedor;

	/** Etiqueta que muestra el registro de trazabilidad del fertilizante. */
	@FXML
	private Label lblRgtTrazabilidad;

	/** Etiqueta que muestra el número de serie del fertilizante. */
	@FXML
	private Label lblSerial;

	/** Etiqueta que muestra el tipo de fertilizante. */
	@FXML
	private Label lblTipo;

	/** Campo de texto para buscar fertilizantes por número de serie. */
	@FXML
	private TextField txtBuscador;

	/** Campo de texto para ingresar la cantidad disponible. */
	@FXML
	private TextField txtCntDisponible;

	/** Campo de texto para ingresar la fecha de adquisición. */
	@FXML
	private TextField txtFechaAdquisicion;

	/** Campo de texto para ingresar el nombre del fertilizante. */
	@FXML
	private TextField txtNombre;

	/** Campo de texto para ingresar el precio del fertilizante. */
	@FXML
	private TextField txtPrecio;

	/** Campo de texto para ingresar el número de serie. */
	@FXML
	private TextField txtSerial;

	/** Campo de texto para ingresar el tipo de fertilizante. */
	@FXML
	private TextField txtTipo;

	/**
	 * Lista observable que contiene los fertilizantes registrados. Se utiliza para
	 * actualizar dinámicamente la vista de la tabla en la interfaz gráfica.
	 */
	ObservableList<Fertilizante> fertilizantes;

	/**
	 * Instancia del servicio de operaciones CRUD utilizadas para gestionar los
	 * fertilizantes. Esta instancia puede ser usada para realizar operaciones
	 * básicas sobre los datos.
	 */
	ImplementacionCRUD ic;

	/**
	 * Instancia de la implementación de operaciones CRUD con un parámetro de
	 * configuración inicial (0). Se utiliza para realizar operaciones como crear,
	 * leer, actualizar o eliminar fertilizantes.
	 */
	private ImplementacionCRUD operacion = new ImplementacionCRUD(0);

	/**
	 * Variable que guarda el tipo de proveedor elegido por el usuario a través de
	 * la interfaz gráfica.
	 * 
	 * Puede representar un proveedor nacional o internacional sin certificación.
	 */
	private Proveedor proveedorSeleccionado;

	/**
	 * Variable que guarda el proveedor internacional con certificación si es
	 * elegido por el usuario en la interfaz gráfica.
	 * 
	 * Se utiliza cuando el usuario selecciona la opción de proveedor certificado.
	 */
	private ProveedorCertificado certificadoSeleccionado;

	/**
	 * Método invocado automáticamente al inicializar la interfaz de usuario
	 * controlada por JavaFX.
	 * 
	 * Inicializa la lista observable de fertilizantes y crea una nueva instancia de
	 * {@code ImplementacionCRUD} con capacidad para almacenar hasta 10 elementos.
	 * 
	 * También llena el ComboBox {@code comboProveedor} con las opciones "Nacional"
	 * e "Internacional", y el ComboBox {@code comboCertificado} con la opción
	 * "Certificado". Finalmente, establece que el ComboBox de certificado esté
	 * oculto al inicio.
	 * 
	 * @param location  La URL usada para resolver rutas relativas al archivo raíz
	 *                  del FXML (puede ser null).
	 * @param resources Los recursos localizados para internacionalización (puede
	 *                  ser null).
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		fertilizantes = FXCollections.observableArrayList();

		ic = new ImplementacionCRUD(10);

		// Llenar el ComboBox "comboCertificado"
		comboProveedor.getItems().addAll("Nacional", "Internacional");

		// Llenar el ComboBox "comboFormatoDigital"
		comboCertificado.getItems().addAll("Certificado");

		// Ocultar comboFormatoDigital inicialmente
		comboCertificado.setVisible(false);

	}

	/**
	 * Maneja la acción cuando se selecciona un tipo de proveedor. Si es
	 * "Internacional", se muestra el combo de certificado. Si es "Nacional", se
	 * asigna un proveedor nacional por defecto.
	 *
	 * @param event Evento del tipo de proveedor seleccionado.
	 */
	@FXML
	void onTipoProveedorSeleccionado(ActionEvent event) {
		String seleccion = comboProveedor.getValue();
		boolean esInternacional = "Internacional".equals(seleccion);

		comboCertificado.setVisible(esInternacional);

		if (!esInternacional) {
			// Si elige Nacional, instanciar directamente
			proveedorSeleccionado = new ProveedorNacional(101, "Agroinsumos del Norte S.A.", "0987654321",
					"Av. Libertad 123, Quito", "1792837465001");
		}
	}

	/**
	 * Maneja la acción cuando se selecciona un tipo de certificado en el ComboBox correspondiente.
	 * Crea un proveedor certificado con valores predeterminados si se selecciona la opción.
	 *
	 * @param event Evento del certificado seleccionado.
	 */
	@FXML
	void onCertificadoSeleccionado(ActionEvent event) {
		String certificado = comboCertificado.getValue();

		if ("Certificado".equals(certificado)) {
			proveedorSeleccionado = new ProveedorCertificado(202, "Exportaciones Andinas S.A.", "0991234567",
					"Calle Bolívar 456, Guayaquil", "EXP-ECU-00987", 550123, "Agencia Ecuatoriana de Certificación");
		} else {
			proveedorSeleccionado = null;
		}
	}

	// OPERACIONES CRUD:

	/**
	 * Crea un nuevo objeto de tipo Fertilizante a partir de los datos ingresados en
	 * los campos del formulario. Incluye validación de cliente, selección de
	 * proveedor y registros de trazabilidad.
	 *
	 * @param event Evento de acción generado al presionar el botón de creación.
	 */
	@FXML
	void create(ActionEvent event) {

		Cliente clienteSeleccionado = null;

		if (chkboxCliente.isSelected()) {
			clienteSeleccionado = new Cliente("1104567890", "María Fernanda Paredes", "marifer.paredes@gmail.com", true, // minorista
					false // mayorista
			);
		} else {
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText("Debes seleccionar cliente para continuar.");
			a.show();
			return; // Detiene la creación
		}

		List<RegistroTrazabilidad> listaRegistros = new ArrayList<>();

		if (chkboxRetrospectiva.isSelected()) {
			listaRegistros.add(new RegistroTrazabilidad("(RtRETROSPECTIVA) Lote-001-A", "2025-05-15",
					"Recepción de materia prima desde su lugar de origen"));
		}
		if (chkboxInterna.isSelected()) {
			listaRegistros.add(new RegistroTrazabilidad("(RtINTERNA) Lote-001-B", "2025-05-16",
					"Transformación del fertilizante, control de temperatura y humedad registrado."));
		}
		if (chkboxProspectiva.isSelected()) {
			listaRegistros.add(new RegistroTrazabilidad("(RtPROSPECTIVA) Lote-001-A", "2025-05-17",
					"Despacho de los fertilizantes terminados a Distribuidora Centro S.A. con guía de remisión #GR123456."));
		}

		// Convertir la lista a arreglo
		RegistroTrazabilidad[] registrosSeleccionados = listaRegistros.toArray(new RegistroTrazabilidad[0]);

		Alert a = new Alert(AlertType.CONFIRMATION);
		 try {
			 Fertilizante f = new Fertilizante(
					    Integer.parseInt(txtSerial.getText()),
					    txtNombre.getText(),
					    txtTipo.getText(),
					    Double.parseDouble(txtPrecio.getText()),
					    txtFechaAdquisicion.getText(),
					    Double.parseDouble(txtCntDisponible.getText()),
					    clienteSeleccionado,  
					    proveedorSeleccionado,
					    registrosSeleccionados);
					   		    
			// Determinar qué certificado usar
		        Proveedor proveedor = null;

		        if (proveedorSeleccionado!= null) {
		        	proveedor = certificadoSeleccionado;
		        } else if (certificadoSeleccionado != null) {
		        	proveedor = certificadoSeleccionado;
		        }
		
		        // Agregar a la lista y tabla
		        fertilizantes.add(f);
		        a.setContentText(ic.create(f)); // Lógica de persistencia
		        a.show();

		        loadTable();
		        clear();

		    } catch (Exception e) {
		        a.setAlertType(AlertType.WARNING);
		        a.setContentText("Error: " + e.getMessage());
		        a.show();
		    }	
		
	}

	/**
	 * Busca un fertilizante por su número de serial ingresado en el campo de
	 * búsqueda. Si se encuentra, muestra su información y lo selecciona en la
	 * tabla.
	 *
	 * @param event Evento de acción generado al presionar el botón de búsqueda.
	 */
	@FXML
	void read(ActionEvent event) {
		 try {
		        // Obtener el serial desde el campo de texto
		        int serial = Integer.parseInt(txtBuscador.getText());

		        // Buscar el fertilizante
		        Fertilizante encontrado = ic.read(serial);

		        if (encontrado != null) {
		            // Llenar los campos con la información del fertilizante encontrado
		            txtSerial.setText(String.valueOf(encontrado.getSerial()));
		            txtNombre.setText(encontrado.getNombre());
		            txtTipo.setText(encontrado.getTipo());
		            txtPrecio.setText(String.valueOf(encontrado.getPrecio()));
		            txtFechaAdquisicion.setText(encontrado.getFechaAdquisicion());
		            txtCntDisponible.setText(String.valueOf(encontrado.getCantidadDisponible()));

		            // Seleccionar el fertilizante en la TableView
		            if (fertilizantes.contains(encontrado)) {
		                tblView.getSelectionModel().select(encontrado);
		                tblView.scrollTo(encontrado);
		            }

		            // Mostrar alerta con información adicional
		            String mensaje = "Cliente: " + (encontrado.getCliente() != null
		                    ? encontrado.getCliente().toString()
		                    : "N/A") +
		                    "\nProveedor: " + (encontrado.getProveedor() != null
		                    ? encontrado.getProveedor().toString()
		                    : "N/A") +
		                    "\nRegistros: " + (encontrado.getRegistroTrazabilidad() != null &&
		                                      encontrado.getRegistroTrazabilidad().length > 0
		                    ? Arrays.toString(encontrado.getRegistroTrazabilidad())
		                    : "Sin registros de trazabilidad");

		            Alert alert = new Alert(Alert.AlertType.INFORMATION);
		            alert.setTitle("Fertilizante encontrado");
		            alert.setHeaderText("Información específica del fertilizante");
		            alert.setContentText(mensaje);
		            alert.showAndWait();

		        } else {
		            Alert alert = new Alert(Alert.AlertType.WARNING);
		            alert.setContentText("No se encontró un fertilizante con ese serial.");
		            alert.show();
		        }

		    } catch (NumberFormatException e) {
		        Alert alert = new Alert(Alert.AlertType.ERROR);
		        alert.setContentText("Ingresa un número válido en el campo de búsqueda.");
		        alert.show();
		    }
		}

		/**
		 * Actualiza la información de un fertilizante seleccionado en la tabla con los
		 * datos del formulario. Se conserva el serial y se permite modificar los demás
		 * campos, cliente, proveedor y registros.
		 *
		 * @param event Evento de acción generado al presionar el botón de
		 *              actualización.
		 */
		@FXML
		void update(ActionEvent event) {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmar actualización");
		alert.setHeaderText(null);

		try {
			Fertilizante seleccionado = tblView.getSelectionModel().getSelectedItem();

			if (seleccionado == null) {
				throw new Exception("No se ha seleccionado ningún elemento.");
			}

			// Cliente: usar el existente si no se ha marcado un nuevo cierre
			Cliente clienteSeleccionado = null;
			if (chkboxCliente.isSelected()) {
				clienteSeleccionado = new Cliente("1104567890", "María Fernanda Paredes", "marifer.paredes@gmail.com", true, // minorista
						false // mayorista
						);
			} else {
			    // Usar el cierre existente del objeto seleccionado
				clienteSeleccionado = seleccionado.getCliente();
			}
		
			// Accesorios seleccionados

			List<RegistroTrazabilidad> listaRegistros = new ArrayList<>();

			if (chkboxRetrospectiva.isSelected()) {
				listaRegistros.add(new RegistroTrazabilidad("(RtRETROSPECTIVA) Lote-001-A", "2025-05-15",
						"Recepción de materia prima desde su lugar de origen"));
			}
			if (chkboxInterna.isSelected()) {
				listaRegistros.add(new RegistroTrazabilidad("(RtINTERNA) Lote-001-B", "2025-05-16",
						"Transformación del fertilizante, control de temperatura y humedad registrado."));
			}
			if (chkboxProspectiva.isSelected()) {
				listaRegistros.add(new RegistroTrazabilidad("(RtPROSPECTIVA) Lote-001-A", "2025-05-17",
						"Despacho de los fertilizantes terminados a Distribuidora Centro S.A. con guía de remisión #GR123456."));
			}
			
			RegistroTrazabilidad[] registrosSeleccionados = listaRegistros.toArray(new RegistroTrazabilidad[0]);	
			
			// Determinar el Proveedor (Nacional, Internacional o Certificado)
			

			Proveedor proveedor = null;
	        if (proveedorSeleccionado!= null) {
	        	proveedor = certificadoSeleccionado;	
	        } else if (certificadoSeleccionado != null) {
	        	proveedor = certificadoSeleccionado;
	        }
	        
	     // Crear nuevo objeto con mismo serial que el seleccionado
			Fertilizante actualizado = new Fertilizante ( 
					
					seleccionado.getSerial(), // Mismo serial para identificar
				    txtNombre.getText(),
				    txtTipo.getText(),
				    Double.parseDouble(txtPrecio.getText()),
				    txtFechaAdquisicion.getText(),
				    Double.parseDouble(txtCntDisponible.getText()),
				    clienteSeleccionado,  
				    proveedorSeleccionado,
				    registrosSeleccionados);
			
			// Actualizar en la lista observable
			int indice = fertilizantes.indexOf(seleccionado);
			fertilizantes.set(indice, actualizado);

			// Lógica de persistencia
			alert.setContentText(ic.update(seleccionado.getSerial(), actualizado));

			loadTable();
			clear();

		} catch (Exception e) {
			alert.setAlertType(AlertType.WARNING);
			alert.setContentText(
					"Error al actualizar: asegúrate de seleccionar un registro y llenar todos los campos correctamente.");
		}

		alert.show();

	}
		
	/**
	 * Elimina un fertilizante seleccionado de la tabla y la lista observable.
	 * Solicita confirmación del usuario antes de eliminar.
	 *
	 * @param event Evento de acción generado al presionar el botón de eliminar.
	 */
	@FXML
	void delete(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmar eliminación");
		alert.setHeaderText(null);
		alert.setContentText("¿Deseas eliminar el registro seleccionado?");

		try {
			Fertilizante seleccionada = tblView.getSelectionModel().getSelectedItem();

			if (seleccionada == null) {
				throw new Exception("No se ha seleccionado ningún elemento.");
			}

			Optional<ButtonType> resultado = alert.showAndWait();
			if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
				// Eliminar del CRUD
				ic.delete(seleccionada.getSerial());

				// Eliminar de la lista observable
				fertilizantes.remove(seleccionada);

				// Actualizar la tabla
				loadTable();
			}

		} catch (Exception e) {
			Alert alertaError = new Alert(AlertType.WARNING);
			alertaError.setTitle("Error");
			alertaError.setHeaderText(null);
			alertaError.setContentText("Debe seleccionar un fertilizante para eliminar.");
			alertaError.show();
		}

	}

	// OPERACIONES ARCHIVO:

	/**
	 * Método invocado al presionar el botón correspondiente en la interfaz gráfica
	 * para serializar los datos actuales de fertilizantes.
	 * 
	 * Serializa todos los objetos de tipo Fertilizante obtenidos a través de
	 * {@code ic.readAll()} y los guarda en un archivo binario llamado
	 * "binaryfile.bin".
	 * 
	 * Muestra un mensaje informativo con el resultado del proceso de serialización.
	 * 
	 * @param event el evento de acción que activa el método, típicamente un clic en
	 *              un botón.
	 */
	@FXML
	void serializar(ActionEvent event) {
		Alert a = new Alert(AlertType.INFORMATION);
		a.setContentText(ic.serializar(ic.readAll(), "", "binaryfile.bin"));
		a.show();

	}

	/**
	 * Método invocado al presionar el botón correspondiente en la interfaz gráfica
	 * para deserializar datos desde un archivo binario.
	 * 
	 * Carga (deserializa) los objetos de tipo Fertilizante previamente guardados en
	 * el archivo "binaryfile.bin" y actualiza la lista observable
	 * {@code fertilizantes} con los nuevos datos. Luego actualiza la tabla mostrada
	 * en la interfaz.
	 * 
	 * En caso de error al abrir o leer el archivo, se muestra un mensaje de
	 * advertencia con la descripción del error.
	 * 
	 * @param event el evento de acción que activa el método, típicamente un clic en
	 *              un botón.
	 */
	@FXML
	void deserializar(ActionEvent event) {
		Alert a = new Alert(AlertType.WARNING);
		try {
			ic.setFertilizantes(ic.deserializar("", "binaryfile.bin"));
			fertilizantes.clear();

			for (Fertilizante fertilizante : ic.readAll()) {
				if (fertilizante != null)
					fertilizantes.add(fertilizante);
			}

			loadTable();
		} catch (Exception e) {
			a.setContentText("Error open file " + e.getMessage());
			a.show();
		}

	}
	
	/**
	 * Carga y establece las propiedades de cada columna de la tabla {@code tblView}
	 * utilizando las propiedades del objeto {@code Fertilizante}.
	 * 
	 * Cada columna está asociada a un atributo específico del objeto, incluyendo:
	 * serial, nombre, tipo, precio, fecha de adquisición, cantidad disponible,
	 * cliente, proveedor y registros de trazabilidad.
	 * 
	 * Los datos son envueltos en {@code SimpleStringProperty} para que puedan ser
	 * mostrados correctamente en la tabla de JavaFX.
	 * 
	 * Finalmente, se vincula la lista observable {@code fertilizantes} como fuente
	 * de datos para la tabla.
	 */
	private void loadTable() {
		column1.setCellValueFactory(cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getSerial())));
		column2.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNombre()));
		column3.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getTipo()));
		column4.setCellValueFactory(cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getPrecio())));
		column5.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getFechaAdquisicion()));
		column6.setCellValueFactory(
				cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getCantidadDisponible())));
		column7.setCellValueFactory(cell -> new SimpleStringProperty(
				cell.getValue().getCliente() != null ? cell.getValue().getCliente().toString() : "N/A"));
		column8.setCellValueFactory(cell -> new SimpleStringProperty(
				cell.getValue().getProveedor() != null ? cell.getValue().getProveedor().toString() : "N/A"));
		column9.setCellValueFactory(cell -> {
			RegistroTrazabilidad[] acc = cell.getValue().getRegistroTrazabilidad();
			String str = (acc != null && acc.length > 0)
					? String.join(", ", Arrays.stream(acc).map(RegistroTrazabilidad::toString).toArray(String[]::new))
					: "Sin registros de trazabilidad";
			return new SimpleStringProperty(str);
		});
		tblView.setItems(fertilizantes);
	}
	
	/**
	 * Limpia todos los campos de entrada del formulario, incluyendo los textos y
	 * los estados de las casillas de verificación relacionadas con el cliente,
	 * proveedor y registros de trazabilidad.
	 * 
	 * También reinicia la variable {@code proveedorSeleccionado} a {@code null}
	 * para evitar que se conserve el proveedor previamente seleccionado.
	 */
	private void clear() {

		txtSerial.clear();
		txtNombre.clear();
		txtTipo.clear();
		txtPrecio.clear();
		txtFechaAdquisicion.clear();
		txtCntDisponible.clear();
		chkboxCliente.setSelected(false);
		chkboxRetrospectiva.setSelected(false);
		chkboxInterna.setSelected(false);
		chkboxProspectiva.setSelected(false);
		// También reinicia proveedorSeleccionado si es necesario
		proveedorSeleccionado = null;
	}
}
