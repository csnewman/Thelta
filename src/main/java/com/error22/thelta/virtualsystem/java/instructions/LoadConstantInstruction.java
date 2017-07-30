package com.error22.thelta.virtualsystem.java.instructions;

import com.error22.thelta.NotImplementedException;
import com.error22.thelta.virtualsystem.java.StackFrame;
import com.error22.thelta.virtualsystem.java.ir.PrimitiveType;

public class LoadConstantInstruction implements IInstruction{
	private PrimitiveType type;
	private Object value;

	public LoadConstantInstruction(PrimitiveType type, Object value) {
		this.type = type;
		this.value = value;
	}

	@Override
	public void execute(StackFrame stackFrame) {
		throw new NotImplementedException();
	}

}