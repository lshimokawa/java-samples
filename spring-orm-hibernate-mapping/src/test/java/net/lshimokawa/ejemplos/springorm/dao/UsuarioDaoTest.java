package net.lshimokawa.ejemplos.springorm.dao;

import net.lshimokawa.ejemplos.springorm.model.Usuario;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author lshimokawa
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
@Transactional
public class UsuarioDaoTest {
	private Logger logger = Logger.getLogger(UsuarioDaoTest.class);

	@Autowired
	private UsuarioDao usuarioDao;

	@Test
	public void testFind() {
		Assert.assertEquals("Lennon", usuarioDao.find(1).getNombre());
	}

	@Test
	public void testFindByUsername() {
		Assert.assertEquals("Lennon", usuarioDao.findByUsername("lshimokawa")
				.getNombre());
	}

	@Test
	public void testGetRoles() {
		Usuario usuario = usuarioDao.find(1);
		Assert.assertEquals(2, usuario.getRoles().size());
	}

	@Test
	public void testGetPais() {
		Usuario usuario = usuarioDao.find(1);
		Assert.assertEquals("Perú", usuario.getPais().getNombre());
	}

	@Test
	public void testCrud() {
		Usuario create = new Usuario();
		create.setUsername("nuevo");
		create.setNombre("Usuario creado");
		usuarioDao.save(create);
		Assert.assertEquals("Usuario creado",
				usuarioDao.find(create.getIdUsuario()).getNombre());
		logger.debug("Usuario creado, idUsuario=" + create.getIdUsuario());

		Usuario update = usuarioDao.find(create.getIdUsuario());
		update.setNombre("Usuario modificado");
		usuarioDao.update(update);
		Assert.assertEquals("Usuario modificado",
				usuarioDao.find(create.getIdUsuario()).getNombre());

		Usuario delete = new Usuario();
		delete.setIdUsuario(create.getIdUsuario());
		usuarioDao.delete(usuarioDao.find(create.getIdUsuario()));

		Assert.assertNull(usuarioDao.find(create.getIdUsuario()));
	}
}