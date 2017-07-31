package com.error22.thelta.virtualsystem.java.ir;

import java.util.HashMap;
import java.util.Map;

import com.error22.thelta.virtualsystem.java.IObjectInstance;
import com.error22.thelta.virtualsystem.java.JavaProgram;
import com.error22.thelta.virtualsystem.java.StandardObjectInstance;

public class JavaClass {
	private JavaProgram program;
	private String name;
	private String superName;
	private String[] interfaces;
	private Map<MethodSignature, JavaMethod> methods;
	private Map<FieldSignature, StaticField> staticFields;
	private boolean canBeExtended;

	public JavaClass(JavaProgram program, String name, String superName, String[] interfaces) {
		this.program = program;
		this.name = name;
		this.superName = superName;
		this.interfaces = interfaces;
		methods = new HashMap<MethodSignature, JavaMethod>();
		staticFields = new HashMap<FieldSignature, StaticField>();
	}

	public IObjectInstance createInstance() {
		return new StandardObjectInstance(this);
	}

	public void addStaticField(StaticField field) {
		staticFields.put(field.getSignature(), field);
	}

	public StaticField getStaticField(FieldSignature signature) {
		return staticFields.get(signature);
	}

	public void addMethod(JavaMethod method) {
		methods.put(method.getSignature(), method);
	}

	public JavaMethod getMethod(MethodSignature signature) {
		return methods.get(signature);
	}

	public JavaMethod findMethod(MethodSignature signature) {
		for (JavaMethod method : methods.values()) {
			if (method.getSignature().matches(signature)) {
				return method;
			}
		}
		if (superName == null)
			throw new RuntimeException("Failed to find method " + signature.toNiceString());
		return program.getClass(superName).findMethod(signature);
	}

	public String getName() {
		return name;
	}

	public boolean isParent(String clazz) {
		if (superName == null)
			return false;
		if (superName.equals(clazz))
			return true;
		return program.getClass(superName).isParent(clazz);
	}

	public boolean canBeExtended() {
		return canBeExtended;
	}

	public void setCanBeExtended(boolean canBeExtended) {
		this.canBeExtended = canBeExtended;
	}

}
