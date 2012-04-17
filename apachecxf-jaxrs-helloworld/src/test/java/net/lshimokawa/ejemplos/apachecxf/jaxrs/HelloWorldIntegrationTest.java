package net.lshimokawa.ejemplos.apachecxf.jaxrs;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Test de integraci—n del Web Service RESTful. Utiliza el RestTemplate de
 * Spring.
 * 
 * @author lshimokawa
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
public class HelloWorldIntegrationTest {
	/**
	 * URL base del Web Service RESTful
	 */
	private String BASE_URL = "http://localhost:8080/apachecxf-jaxrs-helloworld/services/rest/helloworld/";

	/**
	 * Bean configurado por Spring. Con el RestTemplate se pueden probar
	 * servicios RESTful.
	 */
	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void testSaludar() {
		// getForObject hace un request GET a la URL, el segundo par‡metro es el
		// tipo de dato de retorno
		Assert.assertEquals("Hello World",
				restTemplate.getForObject(BASE_URL + "saludar", String.class));
	}

	@Test
	public void testSaludarNombre() {
		Assert.assertEquals("Hello World Lennon", restTemplate.getForObject(
				BASE_URL + "saludar/Lennon", String.class));
	}

	@Test
	public void testSaludarNombreApellido() {
		Assert.assertEquals("Hello World Lennon Shimokawa", restTemplate
				.getForObject(BASE_URL + "saludar/Lennon/Shimokawa",
						String.class));
	}

}
