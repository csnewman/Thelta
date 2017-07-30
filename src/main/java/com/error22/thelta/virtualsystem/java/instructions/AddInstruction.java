package com.error22.thelta.virtualsystem.java.instructions;

import com.error22.thelta.NotImplementedException;
import com.error22.thelta.virtualsystem.java.StackFrame;
import com.error22.thelta.virtualsystem.java.StackObject;
import com.error22.thelta.virtualsystem.java.ir.PrimitiveType;

public class AddInstruction implements IInstruction {
	private PrimitiveType type;

	public AddInstruction(PrimitiveType type) {
		this.type = type;
	}

	@Override
	public void execute(StackFrame stackFrame) {
		StackObject rhs = stackFrame.pop();
		StackObject lhs = stackFrame.pop();

		if (!rhs.getType().equals(lhs.getType()))
			throw new NotImplementedException();

		if (lhs.getType().equals(PrimitiveType.Int))
			stackFrame.push(new StackObject(PrimitiveType.Int, (int) lhs.getValue() + (int) rhs.getValue()));
		else
			throw new NotImplementedException();
	}

}
