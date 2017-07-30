package com.error22.thelta.virtualsystem.java.ir;

import java.util.ArrayList;
import java.util.List;

public class JavaClass {
	private List<JavaMethod> methods;
	
	public JavaClass() {
		methods = new ArrayList<JavaMethod>();
	}
	
	public void addMethod(JavaMethod method) {
		methods.add(method);
	}
	
}
