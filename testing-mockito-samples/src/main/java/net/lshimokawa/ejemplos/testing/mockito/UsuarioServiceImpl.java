package net.lshimokawa.ejemplos.testing.mockito;

public class UsuarioServiceImpl {

	private UsuarioDao usuarioDao;

	public Usuario login(String username, String password) {
		Usuario usuario = usuarioDao.getUsuarioPorUsername(username);
		if (usuario.getPassword().equals(password)) {
			return usuario;
		} else {
			throw new RuntimeException("El usuario y password son incorrectos");
		}
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

}
