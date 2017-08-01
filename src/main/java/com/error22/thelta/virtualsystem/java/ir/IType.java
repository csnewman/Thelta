package com.error22.thelta.virtualsystem.java.ir;

import com.error22.thelta.virtualsystem.java.JavaProgram;

public interface IType {

	Object getDefault();
	
	JavaClass getClass(JavaProgram program);

	Object wrap(JavaProgram program, Object value);

	Object unwrap(JavaProgram program, Object value);
	
}