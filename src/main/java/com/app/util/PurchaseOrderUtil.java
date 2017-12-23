package com.app.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.app.model.Item;
import com.app.service.IItemService;
import com.app.service.IShipmentService;
import com.app.service.IWhUserTypeService;

/**
 * @author Munisekhar Gunapati
 */
@Component
public class PurchaseOrderUtil {
	@Autowired
	private IShipmentService service;
	@Autowired
	private IWhUserTypeService wservice;
	@Autowired
	private IItemService itemService;
	public List<String> getQualityChecks(){
		List<String> qList=new ArrayList<String>();
		qList.add("Required");
		qList.add("Not Required");
		return qList;
	}
	public void getAllDynamics(ModelMap map) {
		map.addAttribute("qualityChecks", getQualityChecks());
		map.addAttribute("shipmentModes", service.findByShmnt("YES"));
		map.addAttribute("vendors", wservice.findByUserType("Vendor"));
	}
	public List<Item> getVendorItems(long vendorId){
		return itemService.findItemsByVendor(vendorId);
		
		
	}
}
