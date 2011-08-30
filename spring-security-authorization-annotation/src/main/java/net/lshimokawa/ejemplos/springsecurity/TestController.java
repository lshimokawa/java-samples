package net.lshimokawa.ejemplos.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@Autowired
	private TestService testService;

	@RequestMapping("/bienvenida.htm")
	public ModelAndView bienvenida() {
		User u = (User) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal();
		return new ModelAndView("bienvenida", "username", u.getUsername());
	}

	@RequestMapping("/test-admin.htm")
	public String testAdmin() {
		testService.testAdmin();
		return "testAdmin";
	}

	@RequestMapping("/test-user.htm")
	public String testUser() {
		testService.testUser();
		return "testUser";
	}
}