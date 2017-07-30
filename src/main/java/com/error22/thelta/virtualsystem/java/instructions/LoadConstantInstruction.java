package com.error22.thelta.virtualsystem.java.instructions;

import com.error22.thelta.NotImplementedException;
import com.error22.thelta.virtualsystem.java.StackFrame;
import com.error22.thelta.virtualsystem.java.StackObject;
import com.error22.thelta.virtualsystem.java.ir.IType;
import com.error22.thelta.virtualsystem.java.ir.PrimitiveType;

public class LoadConstantInstruction implements IInstruction{
	private IType type;
	private Object value;

	public LoadConstantInstruction(IType type, Object value) {
		this.type = type;
		this.value = value;
	}

	@Override
	public void execute(StackFrame stackFrame) {
		stackFrame.push(new StackObject(type, value));
	}

}