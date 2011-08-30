package net.lshimokawa.ejemplos.springjdbc.dao;

import net.lshimokawa.ejemplos.springjdbc.dao.UsuarioDao;
import net.lshimokawa.ejemplos.springjdbc.model.Usuario;

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
		Assert.assertEquals("Lennon", usuarioDao.find("lshimokawa").getNombre());
	}

	@Test
	public void testCrud() {
		Usuario create = new Usuario();
		create.setUsername("nuevo");
		create.setNombre("Usuario creado");
		usuarioDao.save(create);
		Assert.assertEquals("Usuario creado",
				usuarioDao.find(create.getUsername()).getNombre());
		logger.debug("Usuario creado");

		Usuario update = usuarioDao.find(create.getUsername());
		update.setNombre("Usuario modificado");
		usuarioDao.update(update);
		Assert.assertEquals("Usuario modificado",
				usuarioDao.find(create.getUsername()).getNombre());

		Usuario delete = new Usuario();
		delete.setUsername(create.getUsername());
		usuarioDao.delete(usuarioDao.find(create.getUsername()));

		Assert.assertNull(usuarioDao.find(create.getUsername()));
	}
}
