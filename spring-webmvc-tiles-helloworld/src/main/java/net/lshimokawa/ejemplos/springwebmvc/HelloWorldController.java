package net.lshimokawa.ejemplos.springwebmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author lshimokawa
 *
 */
@Controller
public class HelloWorldController {

	@RequestMapping("/HelloWorld.htm")
	public String helloWorld() {
		return "helloWorld";
	}

}