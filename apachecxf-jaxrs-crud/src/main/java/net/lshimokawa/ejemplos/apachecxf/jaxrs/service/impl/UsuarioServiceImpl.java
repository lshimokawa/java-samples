package net.lshimokawa.ejemplos.apachecxf.jaxrs.service.impl;

import net.lshimokawa.ejemplos.apachecxf.jaxrs.dao.UsuarioDao;
import net.lshimokawa.ejemplos.apachecxf.jaxrs.model.Usuario;
import net.lshimokawa.ejemplos.apachecxf.jaxrs.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lshimokawa
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioDao usuarioDao;

	public Usuario find(String username) {
		return usuarioDao.find(username);
	}

	public void save(Usuario usuario) {
		usuarioDao.save(usuario);
	}

	public void update(Usuario usuario) {
		usuarioDao.update(usuario);
	}

	public void delete(Usuario usuario) {
		usuarioDao.delete(usuario);
	}

}
