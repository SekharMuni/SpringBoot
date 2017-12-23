/**
 * 
 */
package com.app.webservice;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Shipment;
import com.app.service.IShipmentService;
import com.app.validator.ShipmentValidator;

/**
 * @author Munisekhar Gunapati
 *
 */
@RestController
public class ShipmentRestController {
	@Autowired
	private IShipmentService service;
	@Autowired
	private ShipmentValidator validator;
	
	public String showShipment(){
		return null;
		
	}
	@PostMapping("/rest/saveShipment")
	public ResponseEntity<?> saveShipment(@RequestBody @Valid Shipment shipment,BindingResult errors){
		validator.validate(shipment, errors);
		if(errors.hasErrors()){
			return ResponseEntity.badRequest().body(errors.getAllErrors());
		}else{
			
		long id=service.saveShipment(shipment);
		return ResponseEntity.ok("Shipment is Save("+id+") Successfully");
		}
	}
	@PostMapping("/rest/updateShipment")
	public ResponseEntity<?> updateShipment(@RequestBody @Valid Shipment shipment,BindingResult errors){
		validator.validate(shipment, errors);
		if(errors.hasErrors())
		{
			return ResponseEntity.badRequest().body(errors.getAllErrors());
		}else if(shipment.getShipmentId()<=0){
			return ResponseEntity.badRequest().body("ShipmentId Must Be Positive Value");
		}else{
			service.updateShipment(shipment);
			return ResponseEntity.ok("Shipment Data Is Updated");
		}
	}
	@GetMapping("rest/deleteShipment/{shipmentId}")
	public String deleteShipmentById(@PathVariable long shipmentId){
		String page=null;
		try {
			service.deleteShipmentById(shipmentId);
			page="Record Deleted By Id:"+shipmentId;
		} catch (Exception e) {
			page="Records doesn't Exist";
		}
		return page;
	}
	@GetMapping("rest/getAllShipments")
	public ResponseEntity<?> getAall(){
		List<Shipment> shipmentList=service.getAll();
		if(shipmentList!=null && shipmentList.size()>0)
			return ResponseEntity.ok(shipmentList);
		else
			return ResponseEntity.ok("NO Record Are Exist");
		
	}
	@GetMapping("rest/getShipment/{shipmentId}")
	public ResponseEntity<?> getShipmentById(@PathVariable long shipmentId){
		Shipment shipment=service.getShipmentById(shipmentId);
		if(shipment!=null)
			return ResponseEntity.ok(shipment);
		else
			return ResponseEntity.ok("No Data Found");
		
	}
}
