package net.lshimokawa.ejemplos.apachecxf.jaxws;

import junit.framework.Assert;

import net.lshimokawa.ejemplos.apachecxf.jaxws.service.UsuarioService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lshimokawa
 */
@ContextConfiguration("/applicationContext-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloWorldIntegrationTest {

	@Autowired
	private UsuarioService usuarioService;

	@Test
	public void testSaludar() {
		Assert.assertEquals("Hola Lennon", usuarioService.find("Lennon"));
	}
}
