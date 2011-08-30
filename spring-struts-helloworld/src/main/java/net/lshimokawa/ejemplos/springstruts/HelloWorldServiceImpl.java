package net.lshimokawa.ejemplos.springstruts;

public class HelloWorldServiceImpl implements HelloWorldService {

	@Override
	public String saludar(String nombre) {
		return "Hola " + nombre;
	}
}
