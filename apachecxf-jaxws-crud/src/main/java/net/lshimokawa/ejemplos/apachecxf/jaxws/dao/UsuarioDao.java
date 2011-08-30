package net.lshimokawa.ejemplos.apachecxf.jaxws.dao;

import net.lshimokawa.ejemplos.apachecxf.jaxws.model.Usuario;

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
