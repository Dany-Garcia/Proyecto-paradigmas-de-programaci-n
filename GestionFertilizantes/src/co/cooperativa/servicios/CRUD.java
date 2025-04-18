package co.cooperativa.servicios;

import co.cooperativa.modelo.Fertilizante;

//Interface CRUD:

public interface CRUD {

	String create(Fertilizante f);

	Fertilizante read(int serial);

	Fertilizante[] readAll();

	String update(int serial, Fertilizante f);

	String delete(int serial);

}
