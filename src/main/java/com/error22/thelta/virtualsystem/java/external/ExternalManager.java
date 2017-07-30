package com.error22.thelta.virtualsystem.java.external;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.error22.thelta.virtualsystem.java.JavaProgram;
import com.error22.thelta.virtualsystem.java.StackFrame;
import com.error22.thelta.virtualsystem.java.instructions.ExternalHookInstruction;
import com.error22.thelta.virtualsystem.java.ir.JavaClass;
import com.error22.thelta.virtualsystem.java.ir.JavaMethod;
import com.error22.thelta.virtualsystem.java.ir.MethodSignature;

public class ExternalManager {
	private JavaProgram program;
	private Map<MethodSignature, IMethodHook> boundMethodHooks;

	public ExternalManager(JavaProgram program) {
		this.program = program;
		boundMethodHooks = new HashMap<MethodSignature, IMethodHook>();
	}

	public void defineExternalClass(String name) {
		program.addClass(new JavaClass(name, "java/lang/Object", new String[0]));
	}

	public void defineHook(MethodSignature signature) {
		JavaMethod method = new JavaMethod(signature);
		method.addInstruction(new ExternalHookInstruction(signature));
		program.getClass(signature.getClazz()).addMethod(method);
	}

	public void bindHook(MethodSignature signature, IMethodHook hook) {
		boundMethodHooks.put(signature, hook);
	}

	public void executeHook(MethodSignature signature, StackFrame stackFrame) {
		boundMethodHooks.get(signature).execute(stackFrame);
	}

}
