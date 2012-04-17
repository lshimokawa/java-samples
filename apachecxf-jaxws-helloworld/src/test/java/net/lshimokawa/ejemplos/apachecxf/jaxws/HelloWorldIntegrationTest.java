package net.lshimokawa.ejemplos.apachecxf.jaxws;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test de integración del Web Service, requiere que el Web Service esté
 * levantado.
 * 
 * @author lshimokawa
 */
@ContextConfiguration("/applicationContext-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloWorldIntegrationTest {

	/**
	 * Interface del Web Service a probar. La implementación es el proxy de
	 * Apache CXF que se inyecta mediante Spring. La configuración se encuentra
	 * en el applicationContext-test.xml
	 */
	@Autowired
	private HelloWorld helloWorld;

	/**
	 * Test de integración, este test prueba el Web Service desplegado.
	 */
	@Test
	public void testSaludar() {
		Assert.assertEquals("Hola Lennon", helloWorld.saludar("Lennon"));
	}
}
