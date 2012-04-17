package net.lshimokawa.ejemplos.apachecxf.jaxrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Implementación del Web Service RESTful, utiliza las anotaciones de JAX-RS. La
 * configuración de Apache CXF se encuentra en WEB-INF/applicationContext.xml
 * 
 * Todas las configuraciones a nivel de clase aplican para todos los métodos. A
 * nivel de cada método se puede personalizar.
 * 
 * Path: configura la ruta base del recurso RESTful Consumes: MIME type que
 * consume el servicio Produces: MIME type que produce el servicio
 * 
 * @author lshimokawa
 * 
 */
@Path("/helloworld")
@Consumes("text/plain")
@Produces("text/plain")
public class HelloWorld {

	/**
	 * Responde a peticiones GET, el Path se concatena al Path base
	 * 
	 * @return
	 */
	@GET
	@Path("/saludar")
	public String saludar() {
		return "Hello World";
	}

	/**
	 * Ejemplo con paso de parámetros por la URL, las variables se identifican
	 * entre {} Con @PathParam se mapean los parámetros
	 * 
	 * @param nombre
	 * @return
	 */
	@GET
	@Path("/saludar/{nombre}")
	public String saludar(@PathParam("nombre") String nombre) {
		return "Hello World " + nombre;
	}

	/**
	 * Ejemplo con paso de varios parámetros por la URL.
	 * 
	 * @param nombre
	 * @param apellido
	 * @return
	 */
	@GET
	@Path("/saludar/{nombre}/{apellido}")
	public String saludar(@PathParam("nombre") String nombre,
			@PathParam("apellido") String apellido) {
		return "Hello World " + nombre + " " + apellido;
	}
}