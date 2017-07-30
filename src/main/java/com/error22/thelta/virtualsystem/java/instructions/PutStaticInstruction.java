package com.error22.thelta.virtualsystem.java.instructions;

import com.error22.thelta.NotImplementedException;
import com.error22.thelta.virtualsystem.java.StackFrame;
import com.error22.thelta.virtualsystem.java.ir.FieldSignature;

public class PutStaticInstruction implements IInstruction {
	private FieldSignature signature;

	public PutStaticInstruction(FieldSignature signature) {
		this.signature = signature;
	}

	@Override
	public void execute(StackFrame stackFrame) {
		throw new NotImplementedException();
	}

}
