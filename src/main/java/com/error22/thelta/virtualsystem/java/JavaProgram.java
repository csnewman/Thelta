package com.error22.thelta.virtualsystem.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.error22.thelta.virtualsystem.java.external.ExternalManager;
import com.error22.thelta.virtualsystem.java.ir.FieldSignature;
import com.error22.thelta.virtualsystem.java.ir.JavaClass;
import com.error22.thelta.virtualsystem.java.ir.JavaMethod;
import com.error22.thelta.virtualsystem.java.ir.MethodSignature;
import com.error22.thelta.virtualsystem.java.ir.StaticField;

public class JavaProgram {
	private ExternalManager externalManager;
	private Map<String, JavaClass> classes;

	public JavaProgram() {
		classes = new HashMap<String, JavaClass>();
		externalManager = new ExternalManager(this);
	}

	public void addClass(JavaClass clazz) {
		classes.put(clazz.getName(), clazz);
	}

	public JavaClass getClass(String name) {
		JavaClass clazz = classes.get(name);
		if(clazz == null)
			throw new IllegalArgumentException("Class not found! " + name);
		return clazz;
	}

	public JavaMethod getMethod(MethodSignature signature) {
		JavaMethod method = getClass(signature.getClazz()).getMethod(signature);
		if (method == null)
			throw new IllegalArgumentException("Method not found! " + signature.toNiceString());
		return method;
	}

	public StaticField getStaticField(FieldSignature signature) {
		StaticField field = getClass(signature.getClazz()).getStaticField(signature);
		if (field == null)
			throw new IllegalArgumentException("Static field not found! " + signature.getName());
		return field;
	}

	public ExternalManager getExternalManager() {
		return externalManager;
	}

}
