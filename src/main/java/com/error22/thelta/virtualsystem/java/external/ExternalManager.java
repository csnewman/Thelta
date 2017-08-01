package com.error22.thelta.virtualsystem.java.external;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import com.error22.thelta.virtualsystem.java.IObjectInstance;
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

	public void defineExternalClass(String name, Supplier<IObjectInstance> instanceCreator,
			Function<IObjectInstance, Object> unwrapFunction, Function<Object, IObjectInstance> wrapFunction) {
		program.addClass(new ExternalClass(program, name, "java/lang/Object", new String[0], instanceCreator,
				unwrapFunction, wrapFunction));
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
		IMethodHook hook = boundMethodHooks.get(signature);
		if (hook == null)
			throw new RuntimeException("Hook not bound! " + signature.toNiceString());
		hook.execute(stackFrame);
	}

	public JavaProgram getProgram() {
		return program;
	}

}
