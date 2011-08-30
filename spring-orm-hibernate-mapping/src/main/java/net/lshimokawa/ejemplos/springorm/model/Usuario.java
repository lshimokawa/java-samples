package net.lshimokawa.ejemplos.springorm.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author lshimokawa
 *
 */
public class Usuario {
	private Integer idUsuario;
	private String username;
	private String password;
	private String nombre;
	private Pais pais;
	private Set<Rol> roles = new HashSet<Rol>(0);

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

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

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

}
