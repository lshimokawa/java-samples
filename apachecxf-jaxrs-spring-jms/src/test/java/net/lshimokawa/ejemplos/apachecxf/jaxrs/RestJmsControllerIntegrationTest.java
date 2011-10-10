package net.lshimokawa.ejemplos.apachecxf.jaxrs;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@ContextConfiguration("/applicationContext-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RestJmsControllerIntegrationTest {
	/**
	 * URL del servicio RESTful, reemplaza tu apellido
	 */
	private String URL = "http://localhost:8080/apachecxf-jaxrs-spring-jms/rest/jms";

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Para probar el servicio usamos POST, el mensaje pasa como text/plain y es
	 * enviado a la cola configurada. Si todo estuvo bien retorna Status 200 y
	 * "Mensaje enviado" como respuesta en text/plain.
	 */
	@Test
	public void testRestJmsPost() {
		ResponseEntity<String> response = restTemplate.postForEntity(URL,
				"Lennon Shimokawa", String.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertEquals("Mensaje enviado", response.getBody());
	}
}