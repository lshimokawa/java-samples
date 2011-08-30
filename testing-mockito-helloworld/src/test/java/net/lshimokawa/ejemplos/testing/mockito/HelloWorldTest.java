package net.lshimokawa.ejemplos.testing.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

/**
 * 
 * @author lshimokawa
 * 
 */
public class HelloWorldTest {

	@Test
	public void testStubMethodCall() {
		HelloWorld mock = mock(HelloWorld.class);
		when(mock.saludar("Lennon")).thenReturn("Hola Lennon");
		assertEquals("Hola Lennon", mock.saludar("Lennon"));
	}

	@Test
	public void testVerifyInteraction() {
		HelloWorld mock = mock(HelloWorld.class);
		mock.saludar("Lennon");
		verify(mock).saludar("Lennon");
	}

}
