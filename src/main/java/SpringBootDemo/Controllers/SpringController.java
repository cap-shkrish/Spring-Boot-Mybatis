package SpringBootDemo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringController {

	@GetMapping(value = "/index")
	public ModelAndView visitHome() {
		
		return new ModelAndView("index");
	}

	@GetMapping(value = "/")
	public ModelAndView visitDefault() {
		int i = 0;

		ModelAndView model = null;

		if (i == 0)
			model = new ModelAndView("redirect:/employee");
		else
			model = new ModelAndView("index");

		return model;
	}

	@GetMapping(value = "/admin")
	public ModelAndView visitAdmin() {
		ModelAndView model = new ModelAndView("admin");
		model.addObject("title", "Admministrator Control Panel");
		model.addObject("message", "This page demonstrates how to use Spring.");

		return model;
	}

	@GetMapping(value = "/submit")
	public ModelAndView visitSubmit(@RequestParam("studentName") String name,
			@RequestParam("studentHobby") String hobby) {
		ModelAndView model = new ModelAndView("submit");
		model.addObject("name", name);
		model.addObject("hobby", hobby);

		return model;
	}

	@GetMapping(value = "/welcome/{userName}")
	public ModelAndView visitWelcome(@PathVariable("userName") String name) {

		ModelAndView model = new ModelAndView("welcome");
		model.addObject("title", "Hello " + name);

		return model;
	}

}