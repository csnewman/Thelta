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

}
