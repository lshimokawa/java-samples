package net.lshimokawa.ejemplos.apachecxf.jaxrs.web;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import net.lshimokawa.ejemplos.book.model.Book;
import net.lshimokawa.ejemplos.book.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;

@Path("/books")
public class BookRestController {

	@Autowired
	private BookService bookService;

	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> findAll() {
		return bookService.findAll();
	}

	@Path("/{isbn}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Book find(@PathParam("isbn") String isbn) {
		return bookService.find(isbn);
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public void save(Book book) {
		bookService.save(book);
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@PUT
	public void update(Book usuario) {
		bookService.update(usuario);
	}

	@Path("/{isbn}")
	@Consumes(MediaType.TEXT_PLAIN)
	@DELETE
	public void delete(Book usuario) {
		bookService.delete(usuario);
	}
}
