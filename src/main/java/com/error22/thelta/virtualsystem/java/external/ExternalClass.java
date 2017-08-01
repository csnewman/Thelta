package com.error22.thelta.virtualsystem.java.external;

import java.util.function.Function;
import java.util.function.Supplier;

import com.error22.thelta.virtualsystem.java.IObjectInstance;
import com.error22.thelta.virtualsystem.java.JavaProgram;
import com.error22.thelta.virtualsystem.java.ir.JavaClass;

public class ExternalClass extends JavaClass {
	private Supplier<IObjectInstance> instanceCreator;
	private Function<IObjectInstance, Object> unwrapFunction;
	private Function<Object, IObjectInstance> wrapFunction;

	public ExternalClass(JavaProgram program, String name, String superName, String[] interfaces,
			Supplier<IObjectInstance> instanceCreator, Function<IObjectInstance, Object> unwrapFunction,
			Function<Object, IObjectInstance> wrapFunction) {
		super(program, name, superName, interfaces);
		this.instanceCreator = instanceCreator;
		this.unwrapFunction = unwrapFunction;
		this.wrapFunction = wrapFunction;
	}

	@Override
	public IObjectInstance createInstance() {
		return instanceCreator.get();
	}

	@Override
	public Object wrap(Object value) {
		return wrapFunction.apply(value);
	}

	@Override
	public Object unwrap(Object value) {
		return unwrapFunction.apply((IObjectInstance) value);
	}

}
