package net.lshimokawa.ejemplos.springcore;

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
