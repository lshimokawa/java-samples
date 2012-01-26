package net.lshimokawa.ejemplos.apachecxf.jaxws;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @author lshimokawa
 */
@WebService
public interface HelloWorld {

	public String saludar(@WebParam(name = "nombre") String nombre);

}