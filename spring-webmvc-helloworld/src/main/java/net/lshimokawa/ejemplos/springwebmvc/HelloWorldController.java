package net.lshimokawa.ejemplos.springwebmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author lshimokawa
 * 
 */
@Controller
public class HelloWorldController {
	@Autowired
	private HelloWorldService helloWorldService;

	@RequestMapping("/HelloWorld.htm")
	public ModelAndView helloWorld() {
		return new ModelAndView("helloWorld", "message",
				helloWorldService.saludar("Lennon"));
	}

}