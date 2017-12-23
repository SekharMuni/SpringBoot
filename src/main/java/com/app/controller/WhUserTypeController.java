package com.app.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.util.WhUserTypeUtil;
import com.app.validator.WhUserTypeValidator;

/**
 * @author Munisekhar Gunapati
 */
@Controller
public class WhUserTypeController {
	@Autowired
	private IWhUserTypeService service;
	@Autowired
	private WhUserTypeValidator validator;
	@Autowired
	private WhUserTypeUtil util;
	
	
	@GetMapping("/regWhUserType")
	public String showWhUserType(ModelMap map){
		map.addAttribute("whUserType",new WhUserType());
		util.getAllWhUserTypes(map);
		return "WhUserTypeRegister";
	}
	@PostMapping("insertWhUserType")
	public String InsertWhUserType(@ModelAttribute @Valid WhUserType whUserType,BindingResult errors,ModelMap map){
		validator.validate(whUserType, errors);
		if(errors.hasErrors()){
			util.getAllWhUserTypes(map);
			return "WhUserTypeRegister";
		}else{
			util.getAllWhUserTypes(map);
			long id=service.saveWhUserType(whUserType);
			map.addAttribute("message","WhUserType Saved("+id+") Successfully");
			return "WhUserTypeRegister";
		}	
	}
	@GetMapping("/editWhUserType")
	public String editWhUserType(@RequestParam long whUserTypeId,ModelMap map){
		WhUserType w=service.getOneWhUserTypeId(whUserTypeId);
		map.addAttribute("whUserType",w);
		util.getAllWhUserTypes(map);
		return "WhUserTypeEdit";
	}
	
	@PostMapping("/updateWhUserType")
	public String updateWhUserType(@ModelAttribute @Valid WhUserType whUserType,BindingResult errors,ModelMap map){
		validator.validate(whUserType, errors);
		if(errors.hasErrors()){
			util.getAllWhUserTypes(map);
			return "WhUserTypeEdit";
		}else{
		service.updateWhUserType(whUserType);
		map.addAttribute("whUserTypes",new WhUserType());
		return "redirect:getAllWhUserType";
		}
	}
	@GetMapping("/deleteWhUserType")
	public String deleteWhUserType(@RequestParam long whUserTypeId){
		service.deleteWhUserType(whUserTypeId);
		return "redirect:getAllWhUserType";
	}
	@GetMapping("/getAllWhUserType")
	public String showAllWhUserType(@ModelAttribute WhUserType whUserType,ModelMap map){
		List<WhUserType> whUserTypeList=service.getAll();
		map.addAttribute("whUserTypes", whUserTypeList);
		return "WhUserTypeData";
	}
	}

