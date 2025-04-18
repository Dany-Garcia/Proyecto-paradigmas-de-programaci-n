package co.cooperativa.servicios;

import co.cooperativa.modelo.Fertilizante;

//Interface OperacionArchivo:

public interface OperacionArchivo {

	public String serializar(Fertilizante[] fertilizantes, String path, String name);

	public Fertilizante[] deserializar(String path, String name);
}
