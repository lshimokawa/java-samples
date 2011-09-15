package net.lshimokawa.ejemplos.apachecxf.jaxrs.service;

import javax.jws.WebParam;

import net.lshimokawa.ejemplos.apachecxf.jaxrs.model.Usuario;

/**
 * @author lshimokawa
 */
public interface UsuarioService {

	Usuario find(@WebParam(name = "username") String username);

	void save(@WebParam(name = "usuario") Usuario usuario);

	void update(@WebParam(name = "usuario") Usuario usuario);

	void delete(@WebParam(name = "usuario") Usuario usuario);

}