package net.lshimokawa.ejemplos.springwebmvc;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author lshimokawa
 * 
 */
@Controller
@RequestMapping("/validator")
public class ValidatorTestController {
	private Logger logger = Logger.getLogger(ValidatorTestController.class);

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("form", "validatorTestBean",
				new ValidatorTestBean());
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid ValidatorTestBean bean, BindingResult result) {
		if (result.hasErrors()) {
			logger.debug("Se encontraron errores de validacion");
		}
		return "form";

	}

}