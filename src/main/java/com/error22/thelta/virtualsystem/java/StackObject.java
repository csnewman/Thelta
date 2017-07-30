package com.error22.thelta.virtualsystem.java;

import com.error22.thelta.virtualsystem.java.ir.IType;

public class StackObject {
	private IType type;
	private Object value;

	public StackObject(IType type, Object value) {
		this.type = type;
		this.value = value;
	}

	public IType getType() {
		return type;
	}

	public Object getValue() {
		return value;
	}

}
