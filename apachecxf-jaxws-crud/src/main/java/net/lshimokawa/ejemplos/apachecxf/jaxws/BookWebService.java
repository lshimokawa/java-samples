package net.lshimokawa.ejemplos.apachecxf.jaxws;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import net.lshimokawa.ejemplos.bookstore.model.Book;

/**
 * Web Service SOAP, expone métodos CRUD.
 * 
 * @author lshimokawa
 * 
 */
@WebService
public interface BookWebService {

	Book find(@WebParam(name = "id") Integer id);

	List<Book> findAll();

	void create(@WebParam(name = "book") Book book);

	void update(@WebParam(name = "book") Book book);

	void delete(@WebParam(name = "id") Integer id);
}
