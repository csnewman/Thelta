package com.error22.thelta.virtualsystem.java.ir;

import com.error22.thelta.NotImplementedException;
import com.error22.thelta.virtualsystem.java.JavaProgram;

public enum PrimitiveType implements IType {
	Void,
	Int,
	Long,
	Float,
	Double,
	Object;

	@Override
	public Object getDefault() {
		switch (this) {
		case Int:
			return (int) 0;
		case Long:
			return (long) 0;
		case Float:
			return (float) 0;
		case Double:
			return (double) 0;
		default:
			throw new NotImplementedException();
		}
	}

	@Override
	public JavaClass getClass(JavaProgram program) {
		throw new NotImplementedException();
	}
}