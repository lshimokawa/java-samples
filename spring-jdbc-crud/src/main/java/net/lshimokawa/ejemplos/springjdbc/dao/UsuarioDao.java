package net.lshimokawa.ejemplos.springjdbc.dao;

import net.lshimokawa.ejemplos.springjdbc.model.Usuario;

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
