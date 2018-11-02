package com.supermart.controllers.admin;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/admin")
public class LayoutsController {
	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpSession session, Model model) {
		System.out.println(session.getAttribute("username"));
		if (session.getAttribute("username") == null) {
			return "login";
		} else {
			model.addAttribute("username", session.getAttribute("username"));
			return "admin";
		}
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}
}
