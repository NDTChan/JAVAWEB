package com.supermart.controllers.admin;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/admin")
public class LayoutsController {
  @RequestMapping(method=RequestMethod.GET)
  public String index(HttpSession session) {
	  return session.getAttribute("username") == null ? "login" : "admin";
  }
  @RequestMapping(value = "/hello",method=RequestMethod.GET)
  public String hello() {
    return "hello";
  }
}
