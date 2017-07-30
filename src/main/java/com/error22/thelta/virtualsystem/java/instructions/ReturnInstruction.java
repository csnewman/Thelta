package com.error22.thelta.virtualsystem.java.instructions;

import com.error22.thelta.virtualsystem.java.ir.PrimitiveType;

public class ReturnInstruction implements IInstruction {
	private PrimitiveType type;

	public ReturnInstruction(PrimitiveType type) {
		this.type = type;
	}

}
