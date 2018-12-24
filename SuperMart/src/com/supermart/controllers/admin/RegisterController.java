package com.supermart.controllers.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.supermart.models.User;
import com.supermart.service.RegisterService;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	public RegisterService registerService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpSession session) {
		return "register";
	}

	@RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("user") User user) {
		boolean error = false;
		if (!registerService.checkExistUser(user)) {
			registerService.register(user);
			return new ModelAndView("login");
		} else {
			error = true;
			ModelAndView mav = new ModelAndView("register");
			mav.addObject("error", error);
			return mav;
		}
	}
}
