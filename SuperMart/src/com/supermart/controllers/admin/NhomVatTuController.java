package com.supermart.controllers.admin;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.supermart.models.NhomVatTu;
import com.supermart.service.NhomVatTuService;
import com.supermart.service.PagingVm;

@Controller
@RequestMapping(value = "admin", method = RequestMethod.GET)
@RestController
public class NhomVatTuController {
	@Autowired
	NhomVatTuService _service;

	@RequestMapping(value = "nhomvattu", method = RequestMethod.GET)
	public ModelAndView getAllPaging(ModelMap model, String currentpage, String searchKey) {
		PagingVm<NhomVatTu> result = new PagingVm<NhomVatTu>();
		long total = 0;
		int size = 10;
		List<NhomVatTu> ls ;
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
		ModelAndView modelView = new ModelAndView("nhomvattu");
		modelView.addObject("result", result);
		return modelView;
	}
	
	@RequestMapping(value="nhomvattu/add", method = RequestMethod.GET)
	public ModelAndView addLVT() {
		String operation = "add";
		ModelAndView modelView = new ModelAndView("nhomvattu/add");
		modelView.addObject("operation", operation);
		modelView.addObject("MaNhomVatTu", _service.getNewMaNhomVatTu());
		return modelView;
	}

	@RequestMapping(value = "nhomvattu/edit", method = RequestMethod.GET)
	public ModelAndView editDVT(int id) {
		NhomVatTu instance = _service.getById(id);
		String operation = "edit";
		ModelAndView modelView = new ModelAndView("nhomvattu/edit");
		modelView.addObject("instance", instance);
		modelView.addObject("operation", operation);
		return modelView;
	}

	@RequestMapping(value = "nhomvattu/form", method = RequestMethod.GET)
	public ModelAndView addLVTNew(String Operation, int Id, String MaNhomVatTu, String TenNhomVatTu, String TrangThai, String MaLoaiVatTu) {
		int trangthai = Integer.parseInt(TrangThai);
		NhomVatTu instance = new NhomVatTu(Id, MaNhomVatTu, TenNhomVatTu, trangthai, MaLoaiVatTu);
		try {
			if (Operation.equals("add")) {
				_service.add(instance);
				List<NhomVatTu> ls = _service.list();
				ModelAndView modelView = new ModelAndView("redirect:/admin/nhomvattu");
				modelView.addObject("list", ls);
				return modelView;
			} else {
				_service.update(Id, MaNhomVatTu, TenNhomVatTu, trangthai, MaLoaiVatTu);
				List<NhomVatTu> ls = _service.list();
				ModelAndView modelView = new ModelAndView("redirect:/admin/nhomvattu");
				modelView.addObject("list", ls);
				return modelView;
			}
		} catch (Exception e) {
			String operation = "add";
			String error = "true";
			if (Operation.equals("add")) {
				operation = "add";
				ModelAndView modelView = new ModelAndView("nhomvattu/add");
				modelView.addObject("operation", operation);
				modelView.addObject("error", error);
				return modelView;
			} else {
				ModelAndView modelView = new ModelAndView("nhomvattu/edit");
				modelView.addObject("operation", operation);
				modelView.addObject("error", error);
				return modelView;
			}
		}
	}

	@RequestMapping(value = "nhomvattu/detail", method = RequestMethod.GET)
	public ModelAndView detail(String id) {
		int Id = Integer.parseInt(id);
		NhomVatTu instance = _service.getById(Id);
		ModelAndView modelView = new ModelAndView("nhomvattu/detail");
		modelView.addObject("instance", instance);
		return modelView;
	}

	@RequestMapping(value = "nhomvattu/deleteItem", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> delete(String id) {
		int Id = Integer.parseInt(id);
		_service.delete(Id);
		return new ResponseEntity<String>("true", HttpStatus.OK);
	}
}
