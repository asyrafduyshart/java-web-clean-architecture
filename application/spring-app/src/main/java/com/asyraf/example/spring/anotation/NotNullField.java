package com.asyraf.example.spring.anotation;

import org.springframework.http.HttpMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author <a href="http://github.com/asyrafduyshart">Asyraf Duyshart</a>
 * @date 5/26/2019
 * @since JDK1.8
 */
@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNullField {

	String message() default "{javax.validation.constraints.NotNull.message}";
	HttpMethod[] method() default HttpMethod.GET; // For resource access.
}
