package com.error22.thelta.virtualsystem.java.ir;

import java.util.ArrayList;
import java.util.Arrays;

import com.error22.thelta.virtualsystem.java.instructions.IInstruction;

public class MethodSignature {
	private String clazz, name;
	private IType returnType;
	private IType[] arguments;

	public MethodSignature(String clazz, String name, IType returnType, IType... arguments) {
		this.clazz = clazz;
		this.name = name;
		this.returnType = returnType;
		this.arguments = arguments;
	}

	public String getClazz() {
		return clazz;
	}

	public String getName() {
		return name;
	}

	public IType getReturnType() {
		return returnType;
	}

	public IType[] getArguments() {
		return arguments;
	}
	
	public String toNiceString() {
		return clazz+"::"+name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(arguments);
		result = prime * result + ((clazz == null) ? 0 : clazz.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((returnType == null) ? 0 : returnType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MethodSignature other = (MethodSignature) obj;
		if (!Arrays.equals(arguments, other.arguments))
			return false;
		if (clazz == null) {
			if (other.clazz != null)
				return false;
		} else if (!clazz.equals(other.clazz))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (returnType == null) {
			if (other.returnType != null)
				return false;
		} else if (!returnType.equals(other.returnType))
			return false;
		return true;
	}

}
