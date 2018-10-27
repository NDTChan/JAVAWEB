package com.supermart.controllers.admin;

import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.supermart.service.AuthService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private AuthService authenticateService; // This will auto-inject the authentication service into the controller.
	private static Logger log = Logger.getLogger(LoginController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String index(HttpSession session) {
		return session.getAttribute("username") == null ? "login" : "admin";
	}

	// Checks if the user credentials are valid or not.
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public ModelAndView validateUsr(@RequestParam("username") String username,
			@RequestParam("password") String password, HttpSession session) {
		String msg = "";
		boolean isValid = authenticateService.findUser(username, password);
		log.info("Is user valid?= " + isValid);
		msg = isValid ? "Welcome " + username + "!" : "Invalid credentials";
		if (isValid) {
			session.setAttribute("username", username);
			return new ModelAndView("admin", "output", msg);
		} else {
			boolean error = true;
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("error", error);
			return mav;
		}
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		return "redirect:../login";
	}
}
