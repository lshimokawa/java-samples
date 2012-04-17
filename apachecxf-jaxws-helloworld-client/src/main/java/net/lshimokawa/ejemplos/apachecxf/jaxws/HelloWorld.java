package net.lshimokawa.ejemplos.apachecxf.jaxws;

import javax.jws.WebService;

/**
 * Copia de la interface del Web Service.
 * 
 * @author lshimokawa
 *
 */
@WebService
public interface HelloWorld {

	public String saludar(String nombre);

}