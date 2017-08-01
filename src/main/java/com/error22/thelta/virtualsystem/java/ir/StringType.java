package com.error22.thelta.virtualsystem.java.ir;

import com.error22.thelta.NotImplementedException;
import com.error22.thelta.virtualsystem.java.JavaProgram;

public class StringType implements IType {
	public static final StringType INSTANCE = new StringType();

	@Override
	public Object getDefault() {
		return null;
	}

	@Override
	public JavaClass getClass(JavaProgram program) {
		throw new NotImplementedException();
	}

	@Override
	public Object wrap(JavaProgram program, Object value) {
		return value;
	}

	@Override
	public Object unwrap(JavaProgram program, Object value) {
		return value;
	}

}
