package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.app.model.WhUserType;
import com.app.util.WhUserTypeUtil;

/**
 * @author Munisekhar Gunapati
 */
@Component
public class WhUserTypeValidator implements Validator {
	@Autowired
	private WhUserTypeUtil util;

	@Override
	public boolean supports(Class<?> clazz) {
		return WhUserType.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		WhUserType whUserType=(WhUserType)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"whUserCode","","Enter WhUserCode");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"whUserFor","","Enter WhUserFor");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"whUserMail","","Enter Email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"whUserContact","","Enter Contact");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,"whUserIdOther","","Enter Other Contact");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"whUserIdNumber","","Enter UserIdNumber");
		
		if(!util.getWhUserIdTypes().contains(whUserType.getWhUserIdType())){
			errors.rejectValue("whUserIdType","","UserIdType Must be Select any of:"+util.getWhUserIdTypes());
		}
		if(!util.getWhUserTypes().contains(whUserType.getUserType())){
			errors.rejectValue("userType","","UserType Must Select Any one Of:"+util.getWhUserTypes());
		}
		if(!Pattern.compile("[1-9]{4,9}").matcher(whUserType.getWhUserCode()).matches()){
			errors.rejectValue("whUserCode","","whUserCode Must Numbers Only");
		}
		if(!Pattern.compile("[0-9]{4,9}").matcher(whUserType.getWhUserContact()).matches()){
			errors.rejectValue("whUserContact","","WhUserContact Must Numbers Only");
		}
		if(!Pattern.compile("[0-9]{4,9}").matcher(whUserType.getWhUserIdNumber()).matches()){
			errors.rejectValue("whUserIdNumber","","whUserIdNumber Must Numbers Only");
		}
	}
}
