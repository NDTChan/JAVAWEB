package com.supermart.controllers.admin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.supermart.models.LoaiVatTu;
import com.supermart.service.LoaiVatTuService;



@Controller
@RequestMapping(value = "admin", method = RequestMethod.GET)
@RestController
public class LoaiVatTuController {
	@Autowired
	LoaiVatTuService _service;

	@RequestMapping(value = "loaivattu", method = RequestMethod.GET)
	public ModelAndView getAll(ModelMap model) {
		List<LoaiVatTu> ls = _service.list();
		ModelAndView modelView = new ModelAndView("loaivattu");
		modelView.addObject("list", ls);
		return modelView;
	}
	
	@RequestMapping(value="loaivattu/add", method = RequestMethod.GET)
	public ModelAndView addLVT() {
		String operation = "add";
		ModelAndView modelView = new ModelAndView("loaivattu/add");
		modelView.addObject("operation", operation);
		return modelView;
	}

	@RequestMapping(value = "loaivattu/edit", method = RequestMethod.GET)
	public ModelAndView editDVT(int id) {
		LoaiVatTu instance = _service.getById(id);
		String operation = "edit";
		ModelAndView modelView = new ModelAndView("loaivattu/edit");
		modelView.addObject("instance", instance);
		modelView.addObject("operation", operation);
		return modelView;
	}

	@RequestMapping(value = "loaivattu/form", method = RequestMethod.GET)
	public ModelAndView addLVTNew(String Operation, int Id, String MaLoaiVatTu, String TenLoaiVatTu, String TrangThai) {
		int trangthai = Integer.parseInt(TrangThai);
		LoaiVatTu instance = new LoaiVatTu(Id, MaLoaiVatTu, TenLoaiVatTu, trangthai);
		try {
			if (Operation.equals("add")) {
				_service.add(instance);
				List<LoaiVatTu> ls = _service.list();
				ModelAndView modelView = new ModelAndView("redirect:/admin/loaivattu");
				modelView.addObject("list", ls);
				return modelView;
			} else {
				_service.update(Id, MaLoaiVatTu, TenLoaiVatTu, trangthai);
				List<LoaiVatTu> ls = _service.list();
				ModelAndView modelView = new ModelAndView("redirect:/admin/loaivattu");
				modelView.addObject("list", ls);
				return modelView;
			}
		} catch (Exception e) {
			String operation = "add";
			String error = "true";
			if (Operation.equals("add")) {
				operation = "add";
				ModelAndView modelView = new ModelAndView("loaivattu/add");
				modelView.addObject("operation", operation);
				modelView.addObject("error", error);
				return modelView;
			} else {
				ModelAndView modelView = new ModelAndView("loaivattu/edit");
				modelView.addObject("operation", operation);
				modelView.addObject("error", error);
				return modelView;
			}
		}
	}

	@RequestMapping(value = "loaivattu/detail", method = RequestMethod.GET)
	public ModelAndView detail(String id) {
		int Id = Integer.parseInt(id);
		LoaiVatTu instance = _service.getById(Id);
		ModelAndView modelView = new ModelAndView("loaivattu/detail");
		modelView.addObject("instance", instance);
		return modelView;
	}

	@RequestMapping(value = "loaivattu/deleteItem", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> delete(String id) {
		int Id = Integer.parseInt(id);
		_service.delete(Id);
		return new ResponseEntity<String>("true", HttpStatus.OK);
	}
}
