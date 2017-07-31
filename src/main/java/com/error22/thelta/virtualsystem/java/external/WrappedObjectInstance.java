package com.error22.thelta.virtualsystem.java.external;

import com.error22.thelta.virtualsystem.java.IObjectInstance;

class WrappedObjectInstance implements IObjectInstance {
	private WrappedClass clazz;
	private Object instance;

	public WrappedObjectInstance(WrappedClass clazz) {
		this.clazz = clazz;
	}

	public Object getInstance() {
		return instance;
	}

	public void setInstance(Object instance) {
		this.instance = instance;
	}

}