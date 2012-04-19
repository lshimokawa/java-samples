package net.lshimokawa.ejemplos.apachecxf.jaxws;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import net.lshimokawa.ejemplos.bookstore.model.Book;
import net.lshimokawa.ejemplos.bookstore.service.BookService;

/**
 * Implementaci—n del Web Service, hace uso del BookService.
 * 
 * @author lshimokawa
 * 
 */
@WebService(endpointInterface = "net.lshimokawa.ejemplos.apachecxf.jaxws.BookWebService")
public class BookWebServiceImpl implements BookWebService {

	/**
	 * Bean configurado por Spring, est‡ en el proyecto apachecxf-jdbc-crud
	 * configurado en el pom.xml
	 */
	@Autowired
	private BookService bookService;

	@Override
	public Book find(Integer id) {
		return bookService.find(id);
	}

	@Override
	public List<Book> findAll() {
		return bookService.findAll();
	}

	@Override
	public void create(Book book) {
		bookService.create(book);
	}

	@Override
	public void update(Book book) {
		bookService.update(book);
	}

	@Override
	public void delete(Integer id) {
		bookService.delete(id);
	}
}
