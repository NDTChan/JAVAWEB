package com.supermart.controllers.admin;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.supermart.service.AuthService;

@Controller
@RequestMapping("/user")
public class LoginController {
	@Autowired
	private AuthService authenticateService; // This will auto-inject the authentication service into the controller.
	private static Logger log = Logger.getLogger(LoginController.class);

	// Checks if the user credentials are valid or not.
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public ModelAndView validateUsr(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		String msg = "";
		boolean isValid = authenticateService.findUser(username, password);
		log.info("Is user valid?= " + isValid);
		msg = isValid ? "Welcome " + username + "!" : "Invalid credentials";
		return new ModelAndView("result", "output", msg);
	}

}
