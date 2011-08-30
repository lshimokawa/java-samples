package net.lshimokawa.ejemplos.apachecxf.jaxws.service;

import javax.jws.WebService;

import net.lshimokawa.ejemplos.apachecxf.jaxws.model.Usuario;

/**
 * @author lshimokawa
 */
@WebService
public interface UsuarioService {

	Usuario find(String username);

	void save(Usuario usuario);

	void update(Usuario usuario);

	void delete(Usuario usuario);

}