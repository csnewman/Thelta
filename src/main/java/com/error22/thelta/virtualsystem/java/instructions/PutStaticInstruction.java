package com.error22.thelta.virtualsystem.java.instructions;

import com.error22.thelta.NotImplementedException;
import com.error22.thelta.virtualsystem.java.StackFrame;
import com.error22.thelta.virtualsystem.java.StackObject;
import com.error22.thelta.virtualsystem.java.ir.FieldSignature;
import com.error22.thelta.virtualsystem.java.ir.StaticField;

public class PutStaticInstruction implements IInstruction {
	private FieldSignature signature;

	public PutStaticInstruction(FieldSignature signature) {
		this.signature = signature;
	}

	@Override
	public void execute(StackFrame stackFrame) {
		StackObject object = stackFrame.pop();
		StaticField field = stackFrame.getThread().getProgram().getStaticField(signature);
		
		if(!object.getType().equals(field.getSignature().getType())) {
			throw new NotImplementedException();
		}
		
		field.setValue(object.getValue());
	}

}
