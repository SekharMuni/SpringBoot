package com.app.webservice;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.validator.UomValidator;

@RestController
public class UomReSTController {
	
	@Autowired
	private IUomService service;
	
	@Autowired
	private UomValidator validator;
	
	/**
	 * Insert the data into database table 
	 * @param uom
	 * @return
	 */
	@PostMapping("/rest/saveUom")
	public ResponseEntity<?> saveUom(@RequestBody @Valid Uom uom,BindingResult errors){
		validator.validate(uom, errors);
		if(errors.hasErrors()){
			return ResponseEntity.badRequest().body(errors.getAllErrors());
		}else{
			Long uomId=service.save(uom);
			return ResponseEntity.ok("Uom ("+uomId+")saved successfully");
		}
	}
	@PostMapping("/rest/updateUom")
	public ResponseEntity<?> updateUom(@RequestBody @Valid Uom uom,BindingResult errors){
		validator.validate(uom, errors);
		if(errors.hasErrors()){
			return ResponseEntity.badRequest().body(errors.getAllErrors());
		}else if(uom.getUomId()<=0){
			return ResponseEntity.badRequest().body("Uom Id Must Be Positive Value");
		}else{
			service.update(uom);
			return ResponseEntity.ok("Uom Data is Updated");
		}
	}
	/**
	 * Delete 
	 * @param uomId
	 * @return
	 */
	@GetMapping("/rest/deleteUom/{uomId}")
	public String deleteUom(@PathVariable long uomId){
		String message=null;
		try{
			service.deleteById(uomId);
			message="Record deleted Id:"+uomId;
		}catch(EmptyResultDataAccessException e){
			message="Record not Exist";
		}
		return message;
	}
	@GetMapping("/rest/getUom/{uomId}")
	public ResponseEntity<?> getUomById(@PathVariable long uomId){
		Uom uom=service.getOneById(uomId);
		if(uom!=null)
			return ResponseEntity.ok(uom);
		else
			return ResponseEntity.ok("No DATA Found");
		}	
	@GetMapping("/rest/getAllUoms")
	public ResponseEntity<?> getAll(){
		List<Uom> uomList=service.getAll();
		if(uomList!=null & uomList.size()>0)
			return ResponseEntity.ok(uomList);
		else
			return ResponseEntity.ok("NO DATA Exist");
	}
}