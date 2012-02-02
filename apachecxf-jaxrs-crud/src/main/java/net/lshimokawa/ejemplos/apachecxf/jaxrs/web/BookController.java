package net.lshimokawa.ejemplos.apachecxf.jaxrs.web;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import net.lshimokawa.ejemplos.book.model.Book;
import net.lshimokawa.ejemplos.book.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

@Path("/books")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
public class BookController {

	@Autowired
	private BookService bookService;

	private Gson gson = new Gson();

	@GET
	public Response findAll() {
		return Response.ok(gson.toJson(bookService.findAll())).build();
	}

	@Path("/{isbn}")
	@GET
	public Response find(@PathParam("isbn") String isbn) {
		Book book = bookService.find(isbn);
		if (book == null) {
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity("El libro no existe").build();
		}
		return Response.ok(gson.toJson(book)).build();
	}

	@POST
	public Response save(String json) {
		try {
			bookService.save(gson.fromJson(json, Book.class));
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity("Error al guardar el libro").build();
		}
		return Response.ok().build();
	}

	@PUT
	public Response update(Book book) {
		bookService.update(book);
		return Response.ok().build();
	}

	@Path("/{isbn}")
	@DELETE
	public Response delete(String isbn) {
		try {
			bookService.delete(isbn);
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity("Error al eliminar el libro").build();
		}
		return Response.ok().build();
	}
}
