package com.error22.thelta.virtualsystem.java.instructions;

import com.error22.thelta.virtualsystem.java.ir.IType;

public class LoadLocalInstruction implements IInstruction {
	private IType type;
	private int index;

	public LoadLocalInstruction(IType type, int index) {
		this.type = type;
		this.index = index;
	}

}
