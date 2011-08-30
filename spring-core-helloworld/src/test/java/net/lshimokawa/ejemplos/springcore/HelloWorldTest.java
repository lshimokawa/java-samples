package net.lshimokawa.ejemplos.springcore;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * @author lshimokawa
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
public class HelloWorldTest {

	@Autowired
	private HelloWorld helloWorld;

	@Test
	public void testSaludar() {
		Assert.assertEquals("Hola Lennon", helloWorld.saludar("Lennon"));
	}
}