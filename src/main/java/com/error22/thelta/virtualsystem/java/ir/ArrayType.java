package com.error22.thelta.virtualsystem.java.ir;

import com.error22.thelta.NotImplementedException;
import com.error22.thelta.virtualsystem.java.JavaProgram;

public class ArrayType implements IType {
	private IType type;

	public ArrayType(IType type) {
		this.type = type;
	}

	@Override
	public Object getDefault() {
		throw new NotImplementedException();
	}

	@Override
	public JavaClass getClass(JavaProgram program) {
		throw new NotImplementedException();
	}

	@Override
	public Object wrap(JavaProgram program, Object value) {
		throw new NotImplementedException();
	}

	@Override
	public Object unwrap(JavaProgram program, Object value) {
		throw new NotImplementedException();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		ArrayType other = (ArrayType) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
