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
	private HttpClient httpclient = new DefaultHttpClient();
	private String BASE_URL = "http://localhost:8080/apachecxf-jaxrs-helloworld/services/rest/helloworld/";

	@Test
	public void saludar() {
		Assert.assertEquals("Hello World", getResponse(BASE_URL + "saludar"));
	}

	@Test
	public void saludarNombre() {
		Assert.assertEquals("Hello World Lennon", getResponse(BASE_URL
				+ "saludar/Lennon"));
	}
	
	@Test
	public void saludarNombreApellido() {
		Assert.assertEquals("Hello World Lennon Shimokawa", getResponse(BASE_URL
				+ "saludar/Lennon/Shimokawa"));
	}

	private String getResponse(String url) {
		String response = null;
		try {
			HttpGet httpGet = new HttpGet(url);
			HttpResponse httpResponse = httpclient.execute(httpGet);
			HttpEntity entity = httpResponse.getEntity();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					entity.getContent()));
			response = reader.readLine();
		} catch (Exception e) {
			Assert.fail();
		}
		return response;
	}
}
