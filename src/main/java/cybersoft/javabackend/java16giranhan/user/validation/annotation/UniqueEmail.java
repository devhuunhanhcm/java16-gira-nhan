package cybersoft.javabackend.java16giranhan.user.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.java16giranhan.user.validation.validator.UniqueEmailValidator;

@Constraint(validatedBy = UniqueEmailValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueEmail {
	String message() default "Email adready exists!!";
	
	Class<?>[]  groups() default {};
	Class<? extends Payload>[] payload() default {};
}
