package com.error22.thelta.virtualsystem.java.instructions;

import com.error22.thelta.NotImplementedException;
import com.error22.thelta.virtualsystem.java.StackFrame;
import com.error22.thelta.virtualsystem.java.StackObject;
import com.error22.thelta.virtualsystem.java.ir.IType;

public class NewInstruction implements IInstruction {
	private IType type;

	public NewInstruction(IType type) {
		this.type = type;
	}

	@Override
	public void execute(StackFrame stackFrame) {
		stackFrame.push(new StackObject(type, type.getClass(stackFrame.getThread().getProgram()).createInstance()));
	}

}
