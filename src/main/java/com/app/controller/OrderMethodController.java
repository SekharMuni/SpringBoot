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

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.util.OrderMethodUtil;
import com.app.validator.OrderMethodValidator;

/**
 * @author Munisekhar Gunapati
 */
@Controller
public class OrderMethodController {
	@Autowired
	private IOrderMethodService service;
	@Autowired
	private OrderMethodUtil util;
	@Autowired
	private OrderMethodValidator validator;
	
	@GetMapping("/regOrderMethod")
	public String showOrderMethod(ModelMap map){
		map.addAttribute("orderMethod", new OrderMethod());
		util.getAllOrderMethods(map);
		return "OrderMethodRegister";
	}
	@PostMapping("/insertOrderMethod")
	public String saveOrderMethod(@ModelAttribute @Valid OrderMethod orderMethod,BindingResult errors,ModelMap map ){
		validator.validate(orderMethod, errors);
		if(errors.hasErrors()){
			util.getAllOrderMethods(map);
			return "OrderMethodRegister";
		}else{
			long id=service.saveOrderMethod(orderMethod);
			util.getAllOrderMethods(map);
			map.addAttribute("message","OrdeMetod are Saved("+id+")Successfully");
			return "OrderMethodRegister";
		}
	}
	@GetMapping("/editOrderMethod")
	public String editOrderMethod(@RequestParam long orderMethodId,ModelMap map){
		OrderMethod o=service.getOneOrderMethod(orderMethodId);
		map.addAttribute("orderMethod", o);
		//map.addAttribute("orderMethod", new OrderMethod());
		util.getAllOrderMethods(map);
		return "OrderMethodEdit";
	}
	@PostMapping("/updateOrderMethod")
	public String updateOrderMethod(@ModelAttribute @Valid OrderMethod orderMethod,BindingResult errors,ModelMap map){
		validator.validate(orderMethod, errors);
		if(errors.hasErrors()){
			util.getAllOrderMethods(map);
			return "OrderMethodEdit";
		}
		service.updateOrderMethod(orderMethod);
		map.addAttribute("orderMethod", orderMethod);
		util.getAllOrderMethods(map);
		return "redirect:getAllOrderMethods";
	}
	@GetMapping("/deleteOrderMethod")
	public String deleteOrderMethod(@RequestParam long orderMethodId){
		service.deleteOrderMethodbyId(orderMethodId);
		return "redirect:getAllOrderMethods";
	}
	@GetMapping("/getAllOrderMethods")
	public String getAllOrderMethod(@ModelAttribute OrderMethod OrderMethod,ModelMap map)
	{
		List<OrderMethod> orderMethodList=service.getall();
		map.addAttribute("orderMethods",orderMethodList);
		return "OrderMethodData";
	}
}
