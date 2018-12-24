package com.supermart.controllers.admin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.supermart.models.NhaCungCap;
import com.supermart.service.NhaCungCapService;
import com.supermart.service.PagingVm;



@Controller
@RequestMapping(value = "admin", method = RequestMethod.GET)
@RestController
public class NhaCungCapController {
	@Autowired
	NhaCungCapService _service;

	@RequestMapping(value = "nhacungcap", method = RequestMethod.GET)
	public ModelAndView getAllPaging(ModelMap model, String currentpage, String searchKey) {
		PagingVm<NhaCungCap> result = new PagingVm<NhaCungCap>();
		System.out.println(searchKey);
		long total = 0;
		int size = 10;
		List<NhaCungCap> ls ;
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
		ModelAndView modelView = new ModelAndView("nhacungcap");
		modelView.addObject("result", result);
		return modelView;
	}
	
	@RequestMapping(value="nhacungcap/add", method = RequestMethod.GET)
	public ModelAndView addNCC() {
		String operation = "add";
		ModelAndView modelView = new ModelAndView("nhacungcap/add");
		modelView.addObject("operation", operation);
		return modelView;
	}

	@RequestMapping(value = "nhacungcap/edit", method = RequestMethod.GET)
	public ModelAndView editNCC(int id) {
		NhaCungCap instance = _service.getById(id);
		String operation = "edit";
		ModelAndView modelView = new ModelAndView("nhacungcap/edit");
		modelView.addObject("instance", instance);
		modelView.addObject("operation", operation);
		return modelView;
	}

	@RequestMapping(value = "nhacungcap/form", method = RequestMethod.GET)
	public ModelAndView addNCCNew(String Operation, int Id, String MaNhaCungCap, String TenNhaCungCap,String DiaChi,String DienThoai,String Email,int TrangThai) {		
		NhaCungCap instance = new NhaCungCap(Id, MaNhaCungCap, TenNhaCungCap, DiaChi,DienThoai,Email,TrangThai);
		try {
			if (Operation.equals("add")) {
				_service.add(instance);
				List<NhaCungCap> ls = _service.list();
				ModelAndView modelView = new ModelAndView("redirect:/admin/nhacungcap");
				modelView.addObject("list", ls);
				return modelView;
			} else {
				_service.update(Id, MaNhaCungCap, TenNhaCungCap, DiaChi,DienThoai,Email,TrangThai);
				List<NhaCungCap> ls = _service.list();
				ModelAndView modelView = new ModelAndView("redirect:/admin/nhacungcap");
				modelView.addObject("list", ls);
				return modelView;
			}
		} catch (Exception e) {
			String operation = "add";
			String error = "true";
			if (Operation.equals("add")) {
				operation = "add";
				ModelAndView modelView = new ModelAndView("nhacungcap/add");
				modelView.addObject("operation", operation);
				modelView.addObject("error", error);
				return modelView;
			} else {
				ModelAndView modelView = new ModelAndView("nhacungcap/edit");
				modelView.addObject("operation", operation);
				modelView.addObject("error", error);
				return modelView;
			}
		}
	}

	@RequestMapping(value = "nhacungcap/detail", method = RequestMethod.GET)
	public ModelAndView detail(String id) {
		int Id = Integer.parseInt(id);
		NhaCungCap instance = _service.getById(Id);
		ModelAndView modelView = new ModelAndView("nhacungcap/detail");
		modelView.addObject("instance", instance);
		return modelView;
	}

	@RequestMapping(value = "nhacungcap/deleteItem", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> delete(String id) {
		int Id = Integer.parseInt(id);
		_service.delete(Id);
		return new ResponseEntity<String>("true", HttpStatus.OK);
	}
}
