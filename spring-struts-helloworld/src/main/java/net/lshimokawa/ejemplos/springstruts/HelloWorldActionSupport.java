package net.lshimokawa.ejemplos.springstruts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

/**
 * @author Lennon Shimokawa
 */
@SuppressWarnings("deprecation")
public class HelloWorldActionSupport extends ActionSupport {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setAttribute("saludo",
				getWebApplicationContext().getBean(HelloWorldService.class)
						.saludar("Lennon"));
		return mapping.findForward("helloWorld");
	}
}