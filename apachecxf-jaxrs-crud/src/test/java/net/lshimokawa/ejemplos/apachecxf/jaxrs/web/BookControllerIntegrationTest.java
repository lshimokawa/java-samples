package net.lshimokawa.ejemplos.apachecxf.jaxrs.web;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
public class BookControllerIntegrationTest {

	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void test() {
		String result = restTemplate.getForObject(
				"http://localhost:8080/apachecxf-jaxrs-crud/services/books/",
				String.class);
		Assert.assertNotNull(result);
	}
}
