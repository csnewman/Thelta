package com.error22.thelta.virtualsystem.java.external;

import java.util.function.Supplier;

import com.error22.thelta.virtualsystem.java.IObjectInstance;
import com.error22.thelta.virtualsystem.java.ir.JavaClass;

public class ExternalClass extends JavaClass {
	private Supplier<IObjectInstance> instanceCreator;

	public ExternalClass(String name, String superName, String[] interfaces,
			Supplier<IObjectInstance> instanceCreator) {
		super(name, superName, interfaces);
		this.instanceCreator = instanceCreator;
	}

	@Override
	public IObjectInstance createInstance() {
		return instanceCreator.get();
	}

}
