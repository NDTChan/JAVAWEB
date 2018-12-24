package com.supermart.controllers.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.sun.jmx.snmp.Timestamp;
import com.supermart.models.VatTu;
import com.supermart.service.PagingVm;
import com.supermart.service.VatTuService;
import org.springframework.http.HttpHeaders;

@Controller
@RequestMapping(value = "admin")
@RestController
public class VatTuController {

	@Autowired
	VatTuService _service;
	@Autowired
	ServletContext servletContext;

	@RequestMapping(value = "vattu", method = RequestMethod.GET)
	public ModelAndView getAllPaging(ModelMap model, String currentpage, String searchKey) {
		PagingVm<VatTu> result = new PagingVm<VatTu>();
		System.out.println(searchKey);
		long total = 0;
		int size = 10;
		List<VatTu> ls;
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
		ModelAndView modelView = new ModelAndView("vattu");
		modelView.addObject("result", result);
		return modelView;
	}

	@RequestMapping(value = "vattu/add", method = RequestMethod.GET)
	public ModelAndView addDVT() {
		String operation = "add";
		ModelAndView modelView = new ModelAndView("vattu/add", "vattu", new VatTu());
		modelView.addObject("operation", operation);
		return modelView;
	}

	@RequestMapping(value = "vattu/addAction", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public String submit(@ModelAttribute("vattu") VatTu vattu) throws IOException {
		try {
			_service.add(vattu);
		}catch(Exception ex) {
			System.out.println( ex.getMessage());
		}
		return "vattu";
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
	
	@RequestMapping(value = "vattu/BlurMaVatTu/{MaVatTu}", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public ResponseEntity<String> BlurMaVatTu(@PathVariable String MaVatTu) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		Gson gson = new Gson();
		String jsonObject = gson.toJson(_service.GetDataByMaVatTu(MaVatTu));
		return new ResponseEntity<String>(jsonObject, responseHeaders, HttpStatus.OK);
	}

	@RequestMapping(value = "vattu/GetInfoMerchandiseByCode/{MaVatTu}", method = RequestMethod.GET, produces = "application/json; charset=utf8")
	@ResponseBody
	public ResponseEntity<String> GetInfoMerchandiseByCode(@PathVariable String MaVatTu) {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/json; charset=utf-8");
		Gson gson = new Gson();
		String jsonObject = gson.toJson(_service.GetInfoMerchandiseByCode(MaVatTu));
		return new ResponseEntity<String>(jsonObject, responseHeaders, HttpStatus.OK);
	}


	@RequestMapping(value = "vattu/uploadFile", method = RequestMethod.POST)
	public ResponseEntity<String> uploadFile(@RequestParam("mavattu") String mavattu,
			@RequestParam("image") MultipartFile file) throws IOException {
		String nameImage = "";
		if (!file.getOriginalFilename().isEmpty()) {
			try {
				Date date = new Date();
				Timestamp ts = new Timestamp(date.getTime());
				byte[] bytes = file.getBytes();
				String rootPath = servletContext.getRealPath("/Upload/" + mavattu);
				File dir = new File(rootPath);
				if (!dir.exists())
					dir.mkdirs();
				nameImage = mavattu +"_"+ ts.getSysUpTime() + ".jpg";
				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + "/" + nameImage);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
			} catch (Exception ex) {
				return new ResponseEntity<>("Invalid file.", HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<>("Invalid file.", HttpStatus.BAD_REQUEST);
		}
		String result = mavattu+"/"+nameImage;
		return new ResponseEntity<String>(result, HttpStatus.OK);

	}
}
