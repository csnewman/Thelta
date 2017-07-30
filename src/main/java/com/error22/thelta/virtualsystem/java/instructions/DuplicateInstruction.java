package com.error22.thelta.virtualsystem.java.instructions;

import com.error22.thelta.NotImplementedException;
import com.error22.thelta.virtualsystem.java.StackFrame;
import com.error22.thelta.virtualsystem.java.StackObject;

public class DuplicateInstruction implements IInstruction {

	@Override
	public void execute(StackFrame stackFrame) {
		StackObject obj = stackFrame.pop();
		stackFrame.push(obj);
		stackFrame.push(obj);
	}

}
