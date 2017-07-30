package com.error22.thelta.virtualsystem.java.instructions;

import com.error22.thelta.NotImplementedException;
import com.error22.thelta.virtualsystem.java.JavaThread;
import com.error22.thelta.virtualsystem.java.StackFrame;
import com.error22.thelta.virtualsystem.java.StackObject;
import com.error22.thelta.virtualsystem.java.ir.JavaMethod;
import com.error22.thelta.virtualsystem.java.ir.MethodSignature;

public class InvokeStaticInstruction implements IInstruction {
	private MethodSignature signature;

	public InvokeStaticInstruction(MethodSignature signature) {
		this.signature = signature;
	}

	@Override
	public void execute(StackFrame stackFrame) {
		JavaThread thread = stackFrame.getThread();
		JavaMethod method = thread.getProgram().getMethod(signature);
		int argCount = method.getSignature().getArguments().length;
		StackObject[] args = new StackObject[argCount];
		for (int i = argCount - 1; i >= 0; i--) {
			args[i] = stackFrame.pop();
		}
		thread.callMethod(method, args);
	}

}
