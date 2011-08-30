package net.lshimokawa.ejemplos.springorm.dao;

import net.lshimokawa.ejemplos.springorm.model.Usuario;

public interface UsuarioDao {

	Usuario find(Integer idUsuario);

	Usuario findByUsername(String username);

	void save(Usuario usuario);

	void update(Usuario usuario);

	void delete(Usuario usuario);

}
