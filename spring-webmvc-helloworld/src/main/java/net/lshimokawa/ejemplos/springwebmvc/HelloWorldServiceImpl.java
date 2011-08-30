package net.lshimokawa.ejemplos.springwebmvc;

import org.springframework.stereotype.Service;

/**
 * 
 * @author lshimokawa
 * 
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService {

	@Override
	public String saludar(String nombre) {
		return "Hola " + nombre;
	}
}
