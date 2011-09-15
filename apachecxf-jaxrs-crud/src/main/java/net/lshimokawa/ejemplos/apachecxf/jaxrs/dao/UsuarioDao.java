package net.lshimokawa.ejemplos.apachecxf.jaxrs.dao;

import net.lshimokawa.ejemplos.apachecxf.jaxrs.model.Usuario;

/**
 * 
 * @author lshimokawa
 *
 */
public interface UsuarioDao {

	Usuario find(String username);

	void save(Usuario usuario);

	void update(Usuario usuario);

	void delete(Usuario usuario);
	
}
