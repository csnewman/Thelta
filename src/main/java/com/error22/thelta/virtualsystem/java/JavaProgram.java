package com.error22.thelta.virtualsystem.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.error22.thelta.virtualsystem.java.ir.JavaClass;
import com.error22.thelta.virtualsystem.java.ir.JavaMethod;
import com.error22.thelta.virtualsystem.java.ir.MethodSignature;

public class JavaProgram {
	private Map<String, JavaClass> classes;

	public JavaProgram() {
		classes = new HashMap<String, JavaClass>();
	}

	public void addClass(JavaClass clazz) {
		classes.put(clazz.getName(), clazz);
	}
	
	public JavaClass getClass(String name) {
		return classes.get(name);
	}
	
	public JavaMethod getMethod(MethodSignature signature) {
		return getClass(signature.getClazz()).getMethod(signature);
	}

}
