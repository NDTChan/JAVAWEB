package com.supermart.controllers.admin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.supermart.models.VatTuChungTu;
import com.supermart.service.PagingVm;
import com.supermart.service.XuatBanService;
import com.supermart.service.XuatBanVm;

@Controller
@RequestMapping(value = "admin")
@RestController
public class XuatBanController {
	@Autowired
	XuatBanService _service;

	@RequestMapping(value = "xuatban", method = RequestMethod.GET)
	public ModelAndView getAllPaging(ModelMap model, String currentpage, String searchKey) {
		PagingVm<VatTuChungTu> result = new PagingVm<VatTuChungTu>();
		long total = 0;
		int size = 2;
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
		ModelAndView modelView = new ModelAndView("xuatban");
		modelView.addObject("result", result);
		return modelView;
	}

	@RequestMapping(value = "xuatban/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView modelView = new ModelAndView("xuatban/add");
		return modelView;
	}

	@RequestMapping(value = "xuatban/BuildCode", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> BuildCode() {
		return new ResponseEntity<String>("\"" + _service.GetNewCode() + "\"", HttpStatus.OK);
	}

	@RequestMapping(value = "xuatban/Post", method = RequestMethod.POST, consumes = "application/json", produces = "application/json", headers = "Accept=application/json")
	public @ResponseBody ResponseEntity<String> Post(@RequestBody String param) {
		Gson gson = new Gson();
		XuatBanVm data = gson.fromJson(param, XuatBanVm.class);
		String jsonObject = gson.toJson(_service.InsertData(data));
		return new ResponseEntity<String>(jsonObject, HttpStatus.OK);
	}
}
