package net.lshimokawa.ejemplos.apachecxf.jaxrs.web;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
public class BookControllerIntegrationTest {
	private Logger logger = Logger
			.getLogger(BookControllerIntegrationTest.class);

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void testGetBook() {
		String response = restTemplate
				.getForObject(
						"http://localhost:8080/apachecxf-jaxrs-crud/services/books/{isbn}",
						String.class, "0201699699");
		logger.debug("testGetBook: " + response);
		Assert.assertNotNull(response);
	}

	@Test
	public void testPost() {
		// TODO
	}
}
