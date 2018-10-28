package com.supermart.controllers.admin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.supermart.models.VatTu;
import com.supermart.service.VatTuService;
import com.supermart.service.VatTuVm;

@Controller
@RequestMapping(value = "admin", method = RequestMethod.GET)
@RestController
public class VatTuController {

	@Autowired
	VatTuService _service;

	@RequestMapping(value = "vattu", method = RequestMethod.GET)
	public ModelAndView getAll(ModelMap model) {
		List<VatTu> ls = _service.list();
		ModelAndView modelView = new ModelAndView("vattu");
		modelView.addObject("list", ls);
		return modelView;
	}

	@RequestMapping(value = "vattu/add", method = RequestMethod.GET)
	public ModelAndView addDVT() {
		String operation = "add";
		ModelAndView modelView = new ModelAndView("vattu/add");
		modelView.addObject("operation", operation);
		return modelView;
	}
	
	@RequestMapping(value = "/addVatTu", method = RequestMethod.POST)
    public String submit(@ModelAttribute("vattu")VatTu vattu, 
      BindingResult result, VatTuVm.Dto model) {
        if (result.hasErrors()) {
            return "error";
        }
//        model.addAttribute("name", employee.getName());
//        model.addAttribute("contactNumber", employee.getContactNumber());
//        model.addAttribute("id", employee.getId());
        return "vattuView";
    }

	@RequestMapping(value = "vattu/edit", method = RequestMethod.GET)
	public ModelAndView editDVT(int id) {
		VatTu instance = _service.getById(id);
		String operation = "edit";
		ModelAndView modelView = new ModelAndView("vattu/edit");
		modelView.addObject("instance", instance);
		modelView.addObject("operation", operation);
		return modelView;
	}

	@RequestMapping(value = "vattu/detail", method = RequestMethod.GET)
	public ModelAndView detail(String id) {
		int Id = Integer.parseInt(id);
		VatTu instance = _service.getById(Id);
		ModelAndView modelView = new ModelAndView("vattu/detail");
		modelView.addObject("instance", instance);
		return modelView;
	}

	@RequestMapping(value = "vattu/deleteItem", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> delete(String id) {
		int Id = Integer.parseInt(id);
		_service.delete(Id);
		return new ResponseEntity<String>("true", HttpStatus.OK);
	}
}
