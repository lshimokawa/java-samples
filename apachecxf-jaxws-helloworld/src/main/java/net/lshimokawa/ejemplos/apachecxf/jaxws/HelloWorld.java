package net.lshimokawa.ejemplos.apachecxf.jaxws;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Interface del WebService SOAP. Utiliza las anotaciones de JAX-WS. La
 * configuraci—n de Apache CXF se encuentra en el applicationContext.xml dentro
 * del WEB-INF.
 * 
 * @author lshimokawa
 */
@WebService
public interface HelloWorld {

	/**
	 * Operaci—n del Web Service
	 * 
	 * @param nombre
	 * @return String con un saludo
	 */
	public String saludar(@WebParam(name = "nombre") String nombre);

}