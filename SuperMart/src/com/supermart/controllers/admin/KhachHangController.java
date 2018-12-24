package com.supermart.controllers.admin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.supermart.models.KhachHang;
import com.supermart.service.KhachHangService;
import com.supermart.service.PagingVm;

@Controller
@RequestMapping(value = "admin")
@RestController
public class KhachHangController {
	
	@Autowired
	KhachHangService _service;
	
	@RequestMapping(value = "khachhang", method = RequestMethod.GET)
	public ModelAndView getAllPaging(ModelMap model, String currentpage, String searchKey) {
		PagingVm<KhachHang> result = new PagingVm<KhachHang>();
		System.out.println(searchKey);
		long total = 0;
		int size = 10;
		List<KhachHang> ls ;
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
		ModelAndView modelView = new ModelAndView("khachhang");
		modelView.addObject("result", result);
		return modelView;
	}

	@RequestMapping(value = "khachhang/add", method = RequestMethod.GET)
	public ModelAndView addKH() {
		String operation = "add";
		ModelAndView modelView = new ModelAndView("khachhang/add");
		modelView.addObject("operation", operation);
		return modelView;
	}
	
	@RequestMapping(value = "khachhang/edit", method = RequestMethod.GET)
	public ModelAndView editKH(int id) {
		KhachHang instance = _service.getById(id);
		String operation = "edit";
		ModelAndView modelView = new ModelAndView("khachhang/edit");
		modelView.addObject("instance", instance);
		modelView.addObject("operation", operation);
		return modelView;
	}
	
	@RequestMapping(value = "khachhang/form", method = RequestMethod.GET)
	public ModelAndView addKHNew(String Operation, int Id, String MaKhachHang, String TenKhachHang, String DiaChi, String SoDienThoai, String Email) {
		KhachHang instance = new KhachHang(Id, MaKhachHang, TenKhachHang, DiaChi, SoDienThoai, Email);
		try {
			if (Operation.equals("add")) {
				_service.add(instance);
				List<KhachHang> ls = _service.list();
				ModelAndView modelView = new ModelAndView("redirect:/admin/khachhang");
				modelView.addObject("list", ls);
				return modelView;
			} else {
				_service.update(Id, MaKhachHang, TenKhachHang, DiaChi, SoDienThoai, Email);
				List<KhachHang> ls = _service.list();
				ModelAndView modelView = new ModelAndView("redirect:/admin/khachhang");
				modelView.addObject("list", ls);
				return modelView;
			}
		} catch (Exception e) {
			String operation = "add";
			String error = "true";
			if (Operation.equals("add")) {
				operation = "add";
				ModelAndView modelView = new ModelAndView("khachhang/add");
				modelView.addObject("operation", operation);
				modelView.addObject("error", error);
				return modelView;
			} else {
				ModelAndView modelView = new ModelAndView("khachhang/edit");
				modelView.addObject("operation", operation);
				modelView.addObject("error", error);
				return modelView;
			}
		}
	}
	@RequestMapping(value = "khachhang/deleteItem", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> delete(String id) {
		int Id = Integer.parseInt(id);
		_service.delete(Id);
		return new ResponseEntity<String>("true", HttpStatus.OK);
	}

}
