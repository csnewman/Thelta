package com.error22.thelta.virtualsystem.java.external;

import com.error22.thelta.virtualsystem.java.IObjectInstance;

class WrappedObjectInstance implements IObjectInstance {
	private WrappedClass clazz;

	public WrappedObjectInstance(WrappedClass clazz) {
		this.clazz = clazz;
	}

}