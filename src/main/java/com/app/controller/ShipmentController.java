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

import com.app.model.Shipment;
import com.app.service.IShipmentService;
import com.app.util.ShipmentUtil;
import com.app.validator.ShipmentValidator;

/**
 * @author Munisekhar Gunapati
 */
@Controller
public class ShipmentController {
	
	@Autowired
	private IShipmentService service;
	@Autowired
	private ShipmentUtil util;
	@Autowired
	private ShipmentValidator validator;
	
	@GetMapping(value={"/regShipment","/insertShipment","/updateShipment"})
	public String showRegistration(ModelMap map)
	{
		map.addAttribute("shipment", new Shipment());
		map.addAttribute("shipmentModes",util.getShipmentModes());
		map.addAttribute("shipmentGrades",util.getShipmentGrades());
		return "ShipmentRegister";
	}
	@PostMapping("/insertShipment")
	public String insertShipment(@ModelAttribute @Valid Shipment shipment,BindingResult errors,ModelMap map){
		validator.validate(shipment, errors);
		if(errors.hasErrors()){
			map.addAttribute("shipment",shipment);
		}
		else{
		long shipmentId=service.saveShipment(shipment);
		map.addAttribute("message", "Shipment (" + shipmentId + ") Created ");
		map.addAttribute("shipment", new Shipment());
		}
		map.addAttribute("shipmentModes",util.getShipmentModes());
		map.addAttribute("shipmentGrades",util.getShipmentGrades());
		return "ShipmentRegister";
	}
	
	@GetMapping("/getAllShipments")
	public String getShipment(@ModelAttribute Shipment shipment,ModelMap map){
		List<Shipment> shipmentList=service.getAll();
		map.addAttribute("shipments",shipmentList);
		return "ShipmentData";
	}
	@GetMapping("/deleteShipment")
	public String deleteShipment(@RequestParam long shipmentId){
		service.deleteShipmentById(shipmentId);
		return "redirect:getAllShipments";
	}
	@GetMapping("/editShipment")
	public String editShipment(@RequestParam long shipmentId,ModelMap map){
		Shipment s=service.getShipmentById(shipmentId);
		map.addAttribute("shipment", s);
		map.addAttribute("shipmentModes",util.getShipmentModes());
		map.addAttribute("shipmentGrades",util.getShipmentGrades());
		return "ShipmentDataEdit";
	}
	
	@PostMapping("/updateShipment")
	public String updateShipment(@ModelAttribute @Valid Shipment shipment,BindingResult errors,ModelMap map){
		validator.validate(shipment, errors);
		String page=null;
		if(errors.hasErrors()){
		map.addAttribute("shipment", shipment);
		map.addAttribute("shipmentModes", util.getShipmentModes());
		map.addAttribute("shipmentGrades", util.getShipmentGrades());
		page="ShipmentDataEdit";
		}else{
			service.updateShipment(shipment);
			page="redirect:getAllShipments";
		}
		return page;
		
	}
}
