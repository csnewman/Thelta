package com.error22.thelta.virtualsystem.java.external;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.objectweb.asm.Type;

import com.error22.thelta.NotImplementedException;
import com.error22.thelta.virtualsystem.java.ConversionUtils;
import com.error22.thelta.virtualsystem.java.IObjectInstance;
import com.error22.thelta.virtualsystem.java.StackFrame;
import com.error22.thelta.virtualsystem.java.StackObject;
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
			manager.defineHook(convertSignature(constructor));
		}

		for (Method method : wrapped.getMethods()) {
			System.out.println(">> " + method.getName());
		}

	}

	public void bind(ExternalManager manager) {
		for (Constructor<?> constructor : wrapped.getConstructors()) {
			manager.bindHook(convertSignature(constructor), sf -> {
				WrappedObjectInstance woi = (WrappedObjectInstance) sf.getLocal(0).getValue();

				int paramCount = constructor.getParameterTypes().length;
				Object[] args = new Object[paramCount];

				for (int i = 0; i < paramCount; i++) {
					args[i] = sf.getLocal(1 + i).getValue();
				}

				try {
					woi.setInstance(constructor.newInstance(args));
				} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					throw new RuntimeException(e);
				}
				
				sf.exit(null);
			});
		}
	}

	private MethodSignature convertSignature(Constructor<?> constructor) {
		Class<?>[] paramTypes = constructor.getParameterTypes();
		IType[] params = new IType[paramTypes.length];

		for (int i = 0; i < paramTypes.length; i++) {
			params[i] = ConversionUtils.convertType(Type.getType(paramTypes[i]));
		}

		return new MethodSignature(name, "<init>", PrimitiveType.Void, params);
	}

	private IObjectInstance createInstance() {
		return new WrappedObjectInstance(this);
	}

}
