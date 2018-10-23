package com.supermart.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/admin")
public class LayoutsController {
  @RequestMapping(method=RequestMethod.GET)
  public String index() {
    return "admin";
  }
  @RequestMapping(value = "/hello",method=RequestMethod.GET)
  public String hello() {
    return "hello";
  }
}
