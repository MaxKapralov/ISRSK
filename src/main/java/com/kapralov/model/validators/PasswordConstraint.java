package com.kapralov.model.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = CustomPasswordValidator.class)
@Target(value = {ElementType.METHOD, ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface PasswordConstraint {

	String message() default "Haslo ma byc wieksze niz 6 symboli, zawierac duza i mala litere i znak specjalny";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};
}
