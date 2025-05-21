module co.cooperativa.entrega3 {
	requires javafx.controls;
	requires javafx.fxml;

	opens co.cooperativa.entrega3.vista to javafx.fxml;
	opens co.cooperativa.entrega3.controlador to javafx.fxml;

	exports co.cooperativa.entrega3.vista;
	exports co.cooperativa.entrega3.controlador;

}
