package com.kapralov.model.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.kapralov.model.data.NewUserForm;

public class PasswordsEqualsValidator implements ConstraintValidator<PasswordsEqualsConstraint, NewUserForm>{

	public void initialize(PasswordsEqualsConstraint arg0) {}

	public boolean isValid(NewUserForm user, ConstraintValidatorContext context) {
		if(user.getPassword().equals(user.getPassAgain()))
			return true;
		return false;
	}

}
