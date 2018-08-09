package com.example.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView visitHome() {
		
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView visitDefault() {
		int i = 0;

		ModelAndView model = null;

		if (i == 0)
			model = new ModelAndView("redirect:/employee");
		else
			model = new ModelAndView("index");

		return model;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView visitAdmin() {
		ModelAndView model = new ModelAndView("admin");
		model.addObject("title", "Admministrator Control Panel");
		model.addObject("message", "This page demonstrates how to use Spring.");

		return model;
	}
	@RequestMapping(value = "/kiran", method = RequestMethod.GET)
	public ModelAndView visitKiran() {
		ModelAndView model = new ModelAndView("kiran");
		model.addObject("title", "Kiran K Webpage");
		model.addObject("message", "Hello");

		return model;
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public ModelAndView visitSubmit(@RequestParam("studentName") String name,
			@RequestParam("studentHobby") String hobby) {
		ModelAndView model = new ModelAndView("submit");
		model.addObject("name", name);
		model.addObject("hobby", hobby);

		return model;
	}

	@RequestMapping(value = "/welcome/{userName}", method = RequestMethod.GET)
	public ModelAndView visitWelcome(@PathVariable("userName") String name) {

		ModelAndView model = new ModelAndView("welcome");
		model.addObject("title", "Hello " + name);

		return model;
	}

}