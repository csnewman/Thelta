package com.error22.thelta.virtualsystem.java.external;

import com.error22.thelta.virtualsystem.java.IObjectInstance;
import com.error22.thelta.virtualsystem.java.JavaProgram;

public class WrappedClass {
	private String name;
	private Class<?> wrapped;

	public WrappedClass(Class<?> wrapped) {
		this.wrapped = wrapped;
		name = wrapped.getCanonicalName().replaceAll("\\.", "/");
	}

	public void define(ExternalManager manager) {
		manager.defineExternalClass(name, this::createInstance);

	}

	private IObjectInstance createInstance() {
		return new WrappedObjectInstance(this);
	}

}
