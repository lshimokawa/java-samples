package net.lshimokawa.ejemplos.springaop;

/**
 * 
 * @author lshimokawa
 *
 */
public class HelloWorldAspect {

	public void interceptar(String saludo) {
		System.out.println("Interceptado " + saludo);
	}
}
