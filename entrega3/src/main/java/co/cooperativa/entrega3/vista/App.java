package co.cooperativa.entrega3.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

//Clase App:

/**
 * Esta clase representa la aplicación JavaFX que inicia la interfaz gráfica de
 * usuario (GUI) para gestionar fertilizantes. Extiende de la clase
 * {@link Application} para integrar JavaFX en la aplicación.
 * <p>
 * El método {@link #start(Stage)} configura la escena principal, cargando el
 * archivo FXML correspondiente y mostrando la ventana. Además, proporciona
 * métodos estáticos para cambiar el contenido de la interfaz en ejecución, como
 * {@link #setRoot(String)}.
 * </p>
 */
public class App extends Application {

	private static Scene scene;

	/**
	 * Inicia la aplicación configurando la escena inicial y mostrando la ventana.
	 * 
	 * @param stage el escenario principal de la aplicación
	 * @throws IOException si ocurre un error al cargar el archivo FXML
	 */
	@Override
	public void start(Stage stage) throws IOException {
		scene = new Scene(loadFXML("AppFertilizantes"), 640, 480);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Cambia la raíz de la escena actual a un nuevo archivo FXML.
	 * 
	 * @param fxml el nombre del archivo FXML que se cargará
	 * @throws IOException si ocurre un error al cargar el archivo FXML
	 */
	static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	/**
	 * Carga un archivo FXML y lo convierte en un objeto {@link Parent} que puede
	 * ser usado en la escena.
	 * 
	 * @param fxml el nombre del archivo FXML a cargar
	 * @return el nodo raíz del archivo FXML cargado
	 * @throws IOException si ocurre un error al cargar el archivo FXML
	 */
	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	/**
	 * Método principal para iniciar la aplicación JavaFX.
	 * 
	 * @param args los argumentos de la línea de comandos
	 */
	public static void main(String[] args) {
		launch();
	}

}