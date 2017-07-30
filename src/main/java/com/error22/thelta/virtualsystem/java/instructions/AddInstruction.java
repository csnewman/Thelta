package com.error22.thelta.virtualsystem.java.instructions;

import com.error22.thelta.NotImplementedException;
import com.error22.thelta.virtualsystem.java.StackFrame;
import com.error22.thelta.virtualsystem.java.ir.PrimitiveType;

public class AddInstruction implements IInstruction {
	private PrimitiveType type;

	public AddInstruction(PrimitiveType type) {
		this.type = type;
	}

	@Override
	public void execute(StackFrame stackFrame) {
		throw new NotImplementedException();
	}

}
