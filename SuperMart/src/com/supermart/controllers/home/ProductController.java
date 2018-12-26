package com.supermart.controllers.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.supermart.models.VatTu;
import com.supermart.service.VatTuService;

@Controller
@RequestMapping(value="sanpham")
public class ProductController {
	
	@Autowired
	VatTuService _service;
	
	@RequestMapping(value="/{mahang}", method=RequestMethod.GET)
	public ModelAndView productDetail(@PathVariable(value="mahang") String mahang) {
		VatTu data = _service.GetDataByMaVatTu(mahang);
		ModelAndView modelView = new ModelAndView("product_Detail");
		modelView.addObject("instance", data);
		return modelView;
	}
}
	