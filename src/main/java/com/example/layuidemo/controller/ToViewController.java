package com.example.layuidemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/toview")
public class ToViewController {

	@RequestMapping(value = "/{viewName}")
	@GetMapping
	public ModelAndView toView(@PathVariable("viewName") String viewName) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(viewName + "/" + viewName);
		modelAndView.addObject("viewName", viewName);
		return modelAndView;
	}
}
