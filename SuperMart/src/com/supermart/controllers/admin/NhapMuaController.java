package com.supermart.controllers.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.supermart.models.VatTuChungTu;
import com.supermart.service.NhaCungCapService;
import com.supermart.service.NhapMuaService;
import com.supermart.service.PagingVm;

@Controller
@RequestMapping(value = "admin")
@RestController
public class NhapMuaController {
	@Autowired
	NhapMuaService _service;
	@Autowired
	NhaCungCapService _serviceNhaCungCap;

	@RequestMapping(value = "nhapmua", method = RequestMethod.GET)
	public ModelAndView getAllPaging(ModelMap model, String currentpage, String searchKey) {
		PagingVm<VatTuChungTu> result = new PagingVm<VatTuChungTu>();
		long total = 0;
		int size =10;
		List<VatTuChungTu> ls;
		if (currentpage != null) {
			int page = Integer.parseInt(currentpage);
			if (searchKey != null) {
				result.setKeySearch(searchKey);
				ls = _service.list(size * page, size, searchKey);
				total = _service.Count(searchKey);
			} else {
				ls = _service.list(size * page, size, null);
				total = _service.Count(null);
			}
			result.setData(ls);
			result.setCurrentPage(page);
		} else {
			if (searchKey != null) {
				result.setKeySearch(searchKey);
				ls = _service.list(0, size, searchKey);
				total = _service.Count(searchKey);
			} else {
				ls = _service.list(0, size, null);
				total = _service.Count(null);
			}
			result.setData(ls);
			result.setCurrentPage(0);
		}

		long totalPage = total / size;
		if (totalPage * size < total) {
			totalPage += 1;
		}
		result.setTotal(totalPage);
		ModelAndView modelView = new ModelAndView("nhapmua");
		modelView.addObject("result", result);
		return modelView;
	}
	
	@RequestMapping(value = "nhapmua/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView modelView = new ModelAndView("nhapmua/add");
		ObjectMapper mapper = new ObjectMapper();
		String json = "";
		try {
			json = mapper.writeValueAsString( _serviceNhaCungCap.list());
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelView.addObject("lstNhaCungCap", json);
		return modelView;
	}

	
	@RequestMapping(value = "nhapmua/BuildCode", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> BuildCode() throws Exception {
		return new ResponseEntity<String>("\"" + _service.getNewMaChungTu() + "\"", HttpStatus.OK);
	}
}
