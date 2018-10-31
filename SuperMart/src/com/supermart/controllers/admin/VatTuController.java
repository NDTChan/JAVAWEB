package com.supermart.controllers.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.supermart.models.VatTu;
import com.supermart.service.VatTuService;

@Controller
@RequestMapping(value = "admin")
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
		ModelAndView modelView = new ModelAndView("vattu/add", "vattu", new VatTu());
		modelView.addObject("operation", operation);
		return modelView;
	}
	
	@RequestMapping(value = "vattu/addAction", method = RequestMethod.POST)
    public String submit( @ModelAttribute("vattu")VatTu vattu) throws IOException{
        System.out.println(vattu.getTenVatTu());
        _service.add(vattu);
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
	
	@RequestMapping(value="vattu/uploadFile",
            method=RequestMethod.POST)
	public ResponseEntity<String> createRole(@RequestParam("name") String name,@RequestParam("image") MultipartFile image){
	// your code goes hereys
		System.out.println(image);
		if(image != null) {
			try {
				byte[] bytes = image.getBytes();
				String rootPath = System.getProperty("user.dir") + "/Upload";
				String rootPathEx = System.getProperty("java.class.path") + "/Upload";
				
				
				System.out.println(rootPathEx);
				File dir  = new File(rootPath + File.separator);
				if(!dir.exists()) {
					dir.mkdirs();
				}
				
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				System.out.println("Server File Location="
						+ serverFile.getAbsolutePath());

				return new ResponseEntity<String>(serverFile.getAbsolutePath(), HttpStatus.OK);
			}catch(Exception e) {
				System.out.println(e);
				return new ResponseEntity<String>("Đéo tìm thấy file", HttpStatus.NOT_FOUND);
			}
		}else {
			return new ResponseEntity<String>("Đéo tìm thấy file", HttpStatus.NOT_FOUND);
		}
		
	}
}
