package net.lshimokawa.ejemplos.apachecxf.jaxws;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 
 * @author lshimokawa
 * 
 */
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HelloWorld helloWorld;

	@Override
	public void init() throws ServletException {
		this.helloWorld = WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServletContext()).getBean(
						"helloWorld", HelloWorld.class);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message", helloWorld.saludar("Lennon"));
		request.getRequestDispatcher("/WEB-INF/jsp/helloWorld.jsp").forward(
				request, response);
	}
}
