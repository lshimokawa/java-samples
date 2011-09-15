package net.lshimokawa.ejemplos.apachecxf.jaxrs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import junit.framework.Assert;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

/**
 * 
 * @author lshimokawa
 * 
 */
public class HelloWorldIntegrationTest {

	@Test
	public void test() throws Exception {
		HttpClient httpclient = new DefaultHttpClient();
		final String nombre = "Lennon";
		HttpGet httpget = new HttpGet(
				"http://localhost:8080/apachecxf-jaxrs-helloworld/services/rest/helloworld/saludar/"
						+ nombre);
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				entity.getContent()));
		Assert.assertEquals("Hello World Lennon",
				reader.readLine());
	}
}
