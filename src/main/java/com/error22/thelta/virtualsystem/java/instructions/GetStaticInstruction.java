package com.error22.thelta.virtualsystem.java.instructions;

import com.error22.thelta.NotImplementedException;
import com.error22.thelta.virtualsystem.java.StackFrame;
import com.error22.thelta.virtualsystem.java.ir.FieldSignature;

public class GetStaticInstruction implements IInstruction {
	private FieldSignature signature;

	public GetStaticInstruction(FieldSignature signature) {
		this.signature = signature;
	}

	@Override
	public void execute(StackFrame stackFrame) {
		throw new NotImplementedException();
	}

}
