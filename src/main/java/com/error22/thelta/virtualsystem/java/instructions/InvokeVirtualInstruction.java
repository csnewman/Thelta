package com.error22.thelta.virtualsystem.java.instructions;

import com.error22.thelta.NotImplementedException;
import com.error22.thelta.virtualsystem.java.StackFrame;
import com.error22.thelta.virtualsystem.java.ir.MethodSignature;

public class InvokeVirtualInstruction implements IInstruction {
	private MethodSignature signature;

	public InvokeVirtualInstruction(MethodSignature signature) {
		this.signature = signature;
	}

	@Override
	public void execute(StackFrame stackFrame) {
		throw new NotImplementedException();
	}
}
