package com.error22.thelta.virtualsystem.java.ir;

import com.error22.thelta.virtualsystem.java.JavaProgram;

public class ObjectType implements IType {
	private String name;

	public ObjectType(String name) {
		this.name = name;
	}

	@Override
	public Object getDefault() {
		return null;
	}

	@Override
	public JavaClass getClass(JavaProgram program) {
		return program.getClass(name);
	}

}
