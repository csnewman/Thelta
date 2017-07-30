package com.error22.thelta.virtualsystem.java.ir;

public interface IType {

	Object getDefault();
	
	@Override
	boolean equals(Object obj);
	
	@Override
	int hashCode();
	
}