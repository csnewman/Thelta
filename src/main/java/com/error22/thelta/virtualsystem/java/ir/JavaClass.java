package com.error22.thelta.virtualsystem.java.ir;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaClass {
	private String name;
	private String superName;
	private String[] interfaces;
	private Map<MethodSignature, JavaMethod> methods;
	private Map<FieldSignature, StaticField> staticFields;

	public JavaClass(String name, String superName, String[] interfaces) {
		this.name = name;
		this.superName = superName;
		this.interfaces = interfaces;
		methods = new HashMap<MethodSignature, JavaMethod>();
		staticFields = new HashMap<FieldSignature, StaticField>();
	}

	public void addStaticField(StaticField field) {
		staticFields.put(field.getSignature(), field);
	}

	public StaticField getStaticField(FieldSignature signature) {
		return staticFields.get(signature);
	}

	public void addMethod(JavaMethod method) {
		methods.put(method.getSignature(), method);
	}

	public JavaMethod getMethod(MethodSignature signature) {
		return methods.get(signature);
	}

	public String getName() {
		return name;
	}

}
