package com.error22.thelta.virtualsystem.java.instructions;

import com.error22.thelta.virtualsystem.java.ir.PrimitiveType;

public class LoadConstantInstruction implements IInstruction{
	private PrimitiveType type;
	private Object value;

	public LoadConstantInstruction(PrimitiveType type, Object value) {
		this.type = type;
		this.value = value;
	}

}