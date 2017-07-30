package com.error22.thelta.virtualsystem.java.instructions;

import com.error22.thelta.NotImplementedException;
import com.error22.thelta.virtualsystem.java.StackFrame;
import com.error22.thelta.virtualsystem.java.StackObject;
import com.error22.thelta.virtualsystem.java.ir.PrimitiveType;

public class ReturnInstruction implements IInstruction {
	private PrimitiveType type;

	public ReturnInstruction(PrimitiveType type) {
		this.type = type;
	}

	@Override
	public void execute(StackFrame stackFrame) {
		StackObject result = null;
		if(!type.equals(type.Void))
			result = stackFrame.pop();
		stackFrame.exit(result);
	}

}
