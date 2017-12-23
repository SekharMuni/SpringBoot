package com.app.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.app.service.IOrderMethodService;
import com.app.service.IUomService;
import com.app.service.IWhUserTypeService;

/**
 * @author Munisekhar Gunapati
 */
@Component
public class ItemUtil {
	
	@Autowired
	private IWhUserTypeService whService;
	
	@Autowired
	private IOrderMethodService omService;
	
	@Autowired
	private IUomService service;

	
	public List<String> getBaseCurrencys(){
		List<String> list=new ArrayList<String>();
		list.add("INR");
		list.add("USD");
		list.add("AUS");
		list.add("ERU");
		return list;
	}
	public void getAllDynamics(ModelMap map){
		map.addAttribute("BaseCurrency",getBaseCurrencys());
		map.addAttribute("itemUoms",service.getAll());
		map.addAttribute("itemSaleMode",omService.findByOrderMode("Sale"));  
		map.addAttribute("itempurchaceMode",omService.findByOrderMode("Purchase"));
		map.addAttribute("itemUserVendorList",whService.findByUserType("Vendor"));
		map.addAttribute("itemUserCustomerList",whService.findByUserType("Customer"));
	}

}
