package net.lshimokawa.ejemplos.apachecxf.jaxws.service.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import net.lshimokawa.ejemplos.apachecxf.jaxws.dao.UsuarioDao;
import net.lshimokawa.ejemplos.apachecxf.jaxws.model.Usuario;
import net.lshimokawa.ejemplos.apachecxf.jaxws.service.UsuarioService;

/**
 * @author lshimokawa
 */
@WebService(endpointInterface = "net.lshimokawa.ejemplos.apachecxf.jaxws.service.UsuarioService")
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
