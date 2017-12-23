package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.app.model.Shipment;
import com.app.util.ShipmentUtil;

/**
 * @author Munisekhar Gunapati
 */
@Component
public class ShipmentValidator implements Validator {
	@Autowired
	private ShipmentUtil util;
	@Override
	public boolean supports(Class<?> clazz) {
		return Shipment.class.equals(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		Shipment shipment=(Shipment)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"description","","Enter Description");
		
		if(!util.getShipmentModes().contains(shipment.getShipmentMode())){
			errors.rejectValue("shipmentMode","","ShipmentMode Must be One Of:"+util.getShipmentModes());
		}
		if(!Pattern.compile("[A-Z]{4,8}").matcher(shipment.getShipmentCode()).matches()){
			errors.rejectValue("shipmentCode","","Enter must be in 4-8 Captil latter");
		}
		if(shipment.getShmnt()!=null && !"YES".equals(shipment.getShmnt())){
			errors.rejectValue("shmnt","","Enable must YES or No Input");
		}
		if(shipment.getShipmentGrade()==null){
			errors.rejectValue("shipmentGrade","","Select any one Shipment Grade");
		}else if(!util.getShipmentGrades().contains(shipment.getShipmentGrade())){
			errors.rejectValue("shipmentGrade","","Select Grade must be one of:"+util.getShipmentGrades());
		}
	}
}
