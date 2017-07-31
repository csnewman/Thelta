package com.error22.thelta.virtualsystem.java.instructions;

import com.error22.thelta.NotImplementedException;
import com.error22.thelta.virtualsystem.java.JavaProgram;
import com.error22.thelta.virtualsystem.java.JavaThread;
import com.error22.thelta.virtualsystem.java.StackFrame;
import com.error22.thelta.virtualsystem.java.StackObject;
import com.error22.thelta.virtualsystem.java.ir.JavaClass;
import com.error22.thelta.virtualsystem.java.ir.JavaMethod;
import com.error22.thelta.virtualsystem.java.ir.MethodSignature;

public class InvokeSpecialInstruction implements IInstruction {
	private MethodSignature signature;

	public InvokeSpecialInstruction(MethodSignature signature) {
		this.signature = signature;
	}

	@Override
	public void execute(StackFrame stackFrame) {
		JavaThread thread = stackFrame.getThread();
		JavaProgram program = thread.getProgram();
		JavaMethod method = program.getMethod(signature);

		StackObject[] args = new StackObject[method.getSignature().getArguments().length + 1];
		for (int i = args.length - 1; i >= 1; i--) {
			args[i] = stackFrame.pop();
		}
		StackObject object = stackFrame.pop();
		args[0] = object;

		JavaClass clazz = object.getType().getClass(program);
		boolean specialResolve = clazz.isParent(method.getSignature().getClazz())
				&& !method.getSignature().isInitializer();

		JavaMethod resolved = null;
		if (specialResolve)
			throw new NotImplementedException();
		else
			resolved = method;

		thread.callMethod(resolved, args);
	}

}
