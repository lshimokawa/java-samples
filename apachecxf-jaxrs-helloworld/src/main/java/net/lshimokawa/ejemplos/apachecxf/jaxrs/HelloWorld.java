package net.lshimokawa.ejemplos.apachecxf.jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

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
	private Logger logger = Logger.getLogger(HelloWorld.class);

	@Path("/saludar")
	@GET
	public String saludar() {
		logger.debug("/saludar");
		return "Hello World";
	}

	@GET
	@Path("/saludar/{nombre}")
	public String saludar(@PathParam("nombre") String nombre) {
		logger.debug("/saludar/" + nombre);
		return "Hello World " + nombre;
	}
}