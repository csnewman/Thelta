package com.error22.thelta.virtualsystem.java.ir;

import java.util.ArrayList;
import java.util.List;

public class JavaClass {
	private String name;
	private String superName;
	private String[] interfaces;
	private List<JavaMethod> methods;

	public JavaClass(String name, String superName, String[] interfaces) {
		this.name = name;
		this.superName = superName;
		this.interfaces = interfaces;
		methods = new ArrayList<JavaMethod>();
	}

	public void addMethod(JavaMethod method) {
		methods.add(method);
	}

	public String getName() {
		return name;
	}

}
