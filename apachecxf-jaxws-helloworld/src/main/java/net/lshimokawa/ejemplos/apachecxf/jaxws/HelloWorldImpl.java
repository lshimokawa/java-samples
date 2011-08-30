package net.lshimokawa.ejemplos.apachecxf.jaxws;

import javax.jws.WebService;

/**
 * @author lshimokawa
 */
@WebService(endpointInterface = "net.lshimokawa.ejemplos.apachecxf.jaxws.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	public String saludar(String nombre) {
		return "Hola " + nombre;
	}
	
}
