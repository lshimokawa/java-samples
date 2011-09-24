package net.lshimokawa.ejemplos.apachecxf.jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Ejemplo de Web Service REST
 * 
 * @author lshimokawa
 * 
 */
@Path("/helloworld")
@Produces("text/plain")
@Consumes("text/plain")
public class HelloWorld {

	@GET
	@Path("/saludar")
	public String saludar() {
		return "Hello World";
	}

	@GET
	@Path("/saludar/{nombre}")
	public String saludar(@PathParam("nombre") String nombre) {
		return "Hello World " + nombre;
	}

	@GET
	@Path("/saludar/{nombre}/{apellido}")
	public String saludar(@PathParam("nombre") String nombre,
			@PathParam("apellido") String apellido) {
		return "Hello World " + nombre + " " + apellido;
	}
}