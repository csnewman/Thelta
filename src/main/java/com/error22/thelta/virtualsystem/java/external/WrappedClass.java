package com.error22.thelta.virtualsystem.java.external;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.objectweb.asm.Type;

import com.error22.thelta.virtualsystem.java.ConversionUtils;
import com.error22.thelta.virtualsystem.java.IObjectInstance;
import com.error22.thelta.virtualsystem.java.ir.IType;
import com.error22.thelta.virtualsystem.java.ir.MethodSignature;
import com.error22.thelta.virtualsystem.java.ir.PrimitiveType;

public class WrappedClass {
	private String name;
	private Class<?> wrapped;

	public WrappedClass(Class<?> wrapped) {
		this.wrapped = wrapped;
		name = wrapped.getCanonicalName().replaceAll("\\.", "/");
	}

	public void define(ExternalManager manager) {
		manager.defineExternalClass(name, this::createInstance);

		for (Constructor<?> constructor : wrapped.getConstructors()) {
			Class<?>[] paramTypes = constructor.getParameterTypes();
			IType[] params = new IType[paramTypes.length];

			for (int i = 0; i < paramTypes.length; i++) {
				params[i] = ConversionUtils.convertType(Type.getType(paramTypes[i]));
			}

			manager.defineHook(new MethodSignature(name, "<init>", PrimitiveType.Void, params));
		}

		for (Method method : wrapped.getMethods()) {
			System.out.println(">> " + method.getName());
		}

	}

	private IObjectInstance createInstance() {
		return new WrappedObjectInstance(this);
	}

}
