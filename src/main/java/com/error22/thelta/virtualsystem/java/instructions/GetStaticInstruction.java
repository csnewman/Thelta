package com.error22.thelta.virtualsystem.java.instructions;

import com.error22.thelta.NotImplementedException;
import com.error22.thelta.virtualsystem.java.StackFrame;
import com.error22.thelta.virtualsystem.java.StackObject;
import com.error22.thelta.virtualsystem.java.ir.FieldSignature;
import com.error22.thelta.virtualsystem.java.ir.StaticField;

public class GetStaticInstruction implements IInstruction {
	private FieldSignature signature;

	public GetStaticInstruction(FieldSignature signature) {
		this.signature = signature;
	}

	@Override
	public void execute(StackFrame stackFrame) {
		StaticField field = stackFrame.getThread().getProgram().getStaticField(signature);
		stackFrame.push(new StackObject(field.getSignature().getType(), field.getValue()));
	}

}
