package net.lshimokawa.ejemplos.apachecxf.jaxrs.web;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import net.lshimokawa.ejemplos.book.model.Book;
import net.lshimokawa.ejemplos.book.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;

@Path("/books")
@Produces("application/json")
@Consumes("application/json")
public class BookController {

	@Autowired
	private BookService bookService;

	@Path("/")
	@GET
	public List<Book> findAll() {
		return bookService.findAll();
	}

	@Path("/{isbn}")
	@GET
	public Book find(@PathParam("isbn") String isbn) {
		return bookService.find(isbn);
	}

	public void save(Book book) {
		bookService.save(book);
	}

	public void update(Book usuario) {
		bookService.update(usuario);
	}

	public void delete(Book usuario) {
		bookService.delete(usuario);
	}

}
