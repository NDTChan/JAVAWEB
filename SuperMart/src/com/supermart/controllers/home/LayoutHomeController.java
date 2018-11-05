package com.supermart.controllers.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.supermart.service.HomeComonService;
import com.supermart.service.VatTuVm;

@Controller
@RequestMapping(value="home", method = RequestMethod.GET)
public class LayoutHomeController {
	
	@Autowired
	HomeComonService _service;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "home";
	}
	
	@RequestMapping(value="viewNewMerchansedise", method = RequestMethod.GET)
	public ModelAndView viewNewMerchansedise(int first, int max) {
		List<VatTuVm.Dto> vattu = _service.GetListMerchansediseNew(first, max);
		System.out.println(vattu);
		ModelAndView modelView = new ModelAndView("viewNewMerchansedise");
		modelView.addObject("lstVatTu", vattu);
		return modelView;
	}
}
