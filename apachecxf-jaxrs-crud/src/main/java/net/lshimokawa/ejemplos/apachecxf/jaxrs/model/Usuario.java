package net.lshimokawa.ejemplos.apachecxf.jaxrs.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author lshimokawa
 * 
 */
@XmlRootElement
public class Usuario {
	private String username;
	private String password;
	private String nombre;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
