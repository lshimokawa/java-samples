package net.lshimokawa.ejemplos.testing.jwebunit;

import net.sourceforge.jwebunit.junit.WebTestCase;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.webapp.WebAppContext;

/**
 * 
 * @author lshimokawa
 * 
 */
public class HelloWorldWebIntegrationTest extends WebTestCase {

	private org.mortbay.jetty.Server server;

	protected void setUp() throws Exception {
		server = new Server(0);
		server.addHandler(new WebAppContext("src/main/webapp",
				"/testing-jwebunit-helloworld"));
		server.start();

		// getLocalPort returns the port that was actually assigned
		int actualPort = server.getConnectors()[0].getLocalPort();
		getTestContext().setBaseUrl(
				"http://localhost:" + actualPort
						+ "/testing-jwebunit-helloworld");
	}

	public void testIndex() {
		beginAt("/index.html");
		assertTextPresent("Hello World");
	}

}