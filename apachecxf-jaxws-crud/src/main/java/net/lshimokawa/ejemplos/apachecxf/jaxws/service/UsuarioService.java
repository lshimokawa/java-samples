package net.lshimokawa.ejemplos.apachecxf.jaxws.service;

import javax.jws.WebParam;
import javax.jws.WebService;

import net.lshimokawa.ejemplos.apachecxf.jaxws.model.Usuario;

/**
 * @author lshimokawa
 */
@WebService
public interface UsuarioService {

	Usuario find(@WebParam(name = "username") String username);

	void save(@WebParam(name = "usuario") Usuario usuario);

	void update(@WebParam(name = "usuario") Usuario usuario);

	void delete(@WebParam(name = "usuario") Usuario usuario);

}