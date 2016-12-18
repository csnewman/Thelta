package com.error22.thelta.pipeline;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ ANNOTATION_TYPE, FIELD })
public @interface Stage {

	String name();

	String[] before() default {};

	String[] after() default {};

}
