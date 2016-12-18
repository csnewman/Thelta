package com.error22.thelta.pipeline;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface StageMethod {

	String stage();

	Pass pass();

	boolean client() default false;

	boolean server() default false;

}
