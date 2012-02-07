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

import net.lshimokawa.ejemplos.bookstore.model.Book;
import net.lshimokawa.ejemplos.bookstore.service.BookService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

@Path("/books")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
public class BookController {
	private static final Logger logger = Logger.getLogger(BookController.class);

	@Autowired
	private BookService bookService;

	private Gson gson = new Gson();

	@GET
	public Response findAll() {
		return Response.ok(gson.toJson(bookService.findAll())).build();
	}

	@Path("/{id}")
	@GET
	public Response find(@PathParam("id") Integer id) {
		Book book = bookService.find(id);
		if (book == null) {
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity("El libro no existe").build();
		}
		return Response.ok(gson.toJson(book)).build();
	}

	@POST
	public Response save(String json) {
		Book book = gson.fromJson(json, Book.class);
		logger.debug(book.getId());
		try {
			bookService.create(book);
			logger.debug(book.getId());
			logger.debug(gson.toJson(bookService.findAll()));
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity("Error al guardar el libro").build();
		}
		return Response.ok(gson.toJson(book)).build();
	}

	@PUT
	public Response update(Book book) {
		bookService.update(book);
		return Response.ok().build();
	}

	@Path("/{id}")
	@DELETE
	public Response delete(@PathParam("id") Integer id) {
		try {
			bookService.delete(id);
		} catch (Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity("Error al eliminar el libro").build();
		}
		return Response.ok().build();
	}
}
