package com.supermart.controllers.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="home",method = RequestMethod.GET)
public class LayoutHomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "home";
	}
}
