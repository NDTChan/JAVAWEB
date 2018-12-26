package com.supermart.controllers.admin;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.supermart.models.DonViTinh;
import com.supermart.service.DonViTinhService;
import com.supermart.service.PagingVm;

@Controller
@RequestMapping(value = "admin", method = RequestMethod.GET)
@RestController
public class DonViTinhController {

	@Autowired
	DonViTinhService _service;

	@RequestMapping(value = "donvitinh", method = RequestMethod.GET)
	public ModelAndView getAllPaging(ModelMap model, String currentpage, String searchKey) {
		PagingVm<DonViTinh> result = new PagingVm<DonViTinh>();
		long total = 0;
		int size = 10;
		List<DonViTinh> ls ;
		if(currentpage != null) {
			int page = Integer.parseInt(currentpage);
			if(searchKey!=null) {
				result.setKeySearch(searchKey);
				ls = _service.list(size*page, size, searchKey);
				total =_service.Count(searchKey);
			}
			else {
				ls = _service.list(size*page, size, null);
				total =_service.Count(null);
			}
			result.setData(ls);
			result.setCurrentPage(page);
		}
		else {
			if(searchKey!=null) {
				result.setKeySearch(searchKey);
				ls = _service.list(0, size, searchKey);
				total =_service.Count(searchKey);
			}
			else {
				ls = _service.list(0, size, null);
				total =_service.Count(null);
			}
			result.setData(ls);
			result.setCurrentPage(0);
		}
		
		long totalPage = total/size;
		if(totalPage*size < total) {
			totalPage += 1;
		} 
		result.setTotal(totalPage);
		ModelAndView modelView = new ModelAndView("donvitinh");
		modelView.addObject("result", result);
		return modelView;
	}

	@RequestMapping(value = "donvitinh/add", method = RequestMethod.GET)
	public ModelAndView addDVT() {
		String operation = "add";
		ModelAndView modelView = new ModelAndView("donvitinh/add");
		modelView.addObject("operation", operation);
		modelView.addObject("MaDonViTinh", _service.getNewMaDonVi());
		return modelView;
	}

	@RequestMapping(value = "donvitinh/edit", method = RequestMethod.GET)
	public ModelAndView editDVT(int id) {
		DonViTinh instance = _service.getById(id);
		String operation = "edit";
		ModelAndView modelView = new ModelAndView("donvitinh/edit");
		modelView.addObject("instance", instance);
		modelView.addObject("operation", operation);
		return modelView;
	}

	@RequestMapping(value = "donvitinh/form", method = RequestMethod.GET)
	public ModelAndView addDVTNew(String Operation, int Id, String MaDonViTinh, String TenDonViTinh, String TrangThai) {
		int trangthai = Integer.parseInt(TrangThai);
		DonViTinh instance = new DonViTinh(Id, MaDonViTinh, TenDonViTinh, trangthai);
		try {
			if (Operation.equals("add")) {
				_service.add(instance);
				List<DonViTinh> ls = _service.list();
				ModelAndView modelView = new ModelAndView("redirect:/admin/donvitinh");
				modelView.addObject("list", ls);
				return modelView;
			} else {
				_service.update(Id, MaDonViTinh, TenDonViTinh, trangthai);
				List<DonViTinh> ls = _service.list();
				ModelAndView modelView = new ModelAndView("redirect:/admin/donvitinh");
				modelView.addObject("list", ls);
				return modelView;
			}
		} catch (Exception e) {
			String operation = "add";
			String error = "true";
			if (Operation.equals("add")) {
				operation = "add";
				ModelAndView modelView = new ModelAndView("donvitinh/add");
				modelView.addObject("operation", operation);
				modelView.addObject("error", error);
				return modelView;
			} else {
				ModelAndView modelView = new ModelAndView("donvitinh/edit");
				modelView.addObject("operation", operation);
				modelView.addObject("error", error);
				return modelView;
			}
		}
	}

	@RequestMapping(value = "donvitinh/detail", method = RequestMethod.GET)
	public ModelAndView detail(String id) {
		int Id = Integer.parseInt(id);
		DonViTinh instance = _service.getById(Id);
		ModelAndView modelView = new ModelAndView("donvitinh/detail");
		modelView.addObject("instance", instance);
		return modelView;
	}

	@RequestMapping(value = "donvitinh/deleteItem", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> delete(String id) {
		int Id = Integer.parseInt(id);
		_service.delete(Id);
		return new ResponseEntity<String>("true", HttpStatus.OK);
	}
}
