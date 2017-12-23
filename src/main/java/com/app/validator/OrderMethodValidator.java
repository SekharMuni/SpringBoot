package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.app.model.OrderMethod;
import com.app.util.OrderMethodUtil;
@Component
public class OrderMethodValidator implements Validator {
	@Autowired
	private OrderMethodUtil util;

	@Override
	public boolean supports(Class<?> c) {
		return OrderMethod.class.equals(c);
	}

	@Override
	public void validate(Object target, Errors errors) {
		OrderMethod orderMethod=(OrderMethod)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"description","","Enter Description");
		
		if(!util.getOrderModes().contains(orderMethod.getOrderMode())){
			errors.rejectValue("orderMode","","OrderMethod Mode Must one of:"+util.getOrderModes());
		}
		if(!util.getOrderAccepts().contains(orderMethod.getOrderAccept())){
			errors.rejectValue("orderAccept","","OrderAccet Must one of:"+util.getOrderAccepts());
		}
		if(!util.getOrderMethods().contains(orderMethod.getOrderMtd())){
			errors.rejectValue("orderMtd","","orderMtd Must one of:"+util.getOrderMethods());
		}
		if(!Pattern.compile("[A-Z]{4,8}").matcher(orderMethod.getOrderCode()).matches()){
			errors.rejectValue("orderCode","","Enter OrderCode Must 4-8 Captal Letters");
		}
	}
}
