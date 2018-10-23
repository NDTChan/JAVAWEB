package com.supermart.controllers.admin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.supermart.models.DonViTinh;
import com.supermart.service.DonViTinhService;

@Controller
public class DonViTinhController {
	
	@Autowired
	DonViTinhService _service;

//	@RequestMapping(value="admin/deleteEmp", method=RequestMethod.GET)
//	public ModelAndView deleteEmployee(String id)
//	{
//		int idEmp=Integer.parseInt(id);
//		_service.delete(idEmp);
//		return new ModelAndView("redirect:/admin/listEmp");
//	}
	
//	@RequestMapping(value="admin/deleteCom", method=RequestMethod.GET)
//	public ModelAndView deleteCompany(String id)
//	{
//		int comid=Integer.parseInt(id);
//		Company com=companyDao.getById(comid);
//		if(com!=null)
//		{
//			Set<Employee> ls=com.getLsEmp(); 
//			_service.delete();
//			companyDao.delete(com);
//		}
//		return new ModelAndView("redirect:/admin/listEmp");
//	}
	
	@RequestMapping(value="admin/donvitinh", method=RequestMethod.GET)
	
	public ModelAndView getAllEmployeeAdmin(ModelMap model)
	{
		List<DonViTinh> ls=_service.list();
		System.out.println(ls);
		ModelAndView modelView=new ModelAndView("donvitinh/index");
		modelView.addObject("list",ls);
		return modelView;
	}
	
//	@RequestMapping(value="admin/addEmp", method=RequestMethod.POST)
//	public ModelAndView addEmployee(String name, String email, String companyid)
//	{
//		int comid=Integer.parseInt(companyid);
//		Company com=companyDao.getById(comid);
//		if(com!=null)
//		{
//			Employee emp=new Employee();
//			emp.setName(name);
//			emp.setEmail(email);
//			emp.setCompany(com);
//			_service.add(emp);
//		}
//		
//		ModelAndView modelView=new ModelAndView("redirect:/admin/listEmp");
//
//		return modelView; test
//	}
//	
//	
	
}
