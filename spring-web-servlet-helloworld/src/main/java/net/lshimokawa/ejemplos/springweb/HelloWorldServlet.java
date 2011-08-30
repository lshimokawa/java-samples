package net.lshimokawa.ejemplos.springweb;

import java.io.IOException;
import java.io.PrintWriter;

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
	private HelloWorldBean helloWorldBean;

	@Override
	public void init() throws ServletException {
		this.helloWorldBean = WebApplicationContextUtils
				.getRequiredWebApplicationContext(getServletContext()).getBean(
						"helloWorldBean", HelloWorldBean.class);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		try {
			writer.println(helloWorldBean.getSaludo());
		} finally {
			writer.close();
		}
	}
}
