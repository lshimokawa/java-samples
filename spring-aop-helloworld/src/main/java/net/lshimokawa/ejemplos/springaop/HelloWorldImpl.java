package net.lshimokawa.ejemplos.springaop;

/**
 * 
 * @author lshimokawa
 *
 */
public class HelloWorldImpl implements HelloWorld {

	public String saludar(String nombre) {
		return "Hola " + nombre;
	}

}
