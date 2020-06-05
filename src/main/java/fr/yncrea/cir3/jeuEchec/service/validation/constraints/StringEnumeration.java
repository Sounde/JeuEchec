package fr.yncrea.cir3.jeuEchec.service.validation.constraints;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



@Documented
@Constraint(validatedBy = StringEnumerationValidator.class)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface StringEnumeration {
	String message() default "{fr.yncrea.cir3.chess.service.validation.constraint.StringEnumeration.message}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	Class<? extends Enum<?>> enumClass();
}
