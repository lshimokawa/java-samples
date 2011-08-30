package net.lshimokawa.ejemplos.testing.mockito;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author lshimokawa
 * 
 */
public class UsuarioServiceTest {
	private UsuarioServiceImpl usuarioService;

	@Before
	public void setUp() {
		UsuarioDao usuarioDao = mock(UsuarioDao.class);
		Usuario usuario = new Usuario();
		usuario.setUsername("admin");
		usuario.setPassword("1234");
		when(usuarioDao.getUsuarioPorUsername("admin")).thenReturn(usuario);
		usuarioService = new UsuarioServiceImpl();
		usuarioService.setUsuarioDao(usuarioDao);
	}

	@Test
	public void debeRetornarElUsuarioCuandoLoginCorrecto() {
		assertNotNull(usuarioService.login("admin", "1234"));
	}

	@Test
	public void debeLanzarRuntimeExceptionCuandoLoginIncorrecto() {
		try {
			usuarioService.login("admin", "xxxx");
			fail();
		} catch (RuntimeException e) {
			assertEquals("El usuario y password son incorrectos",
					e.getMessage());
		}
	}
}
