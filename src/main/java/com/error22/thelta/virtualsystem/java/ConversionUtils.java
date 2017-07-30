package com.error22.thelta.virtualsystem.java;

import org.objectweb.asm.Type;
import org.objectweb.asm.commons.InstructionAdapter;

import com.error22.thelta.virtualsystem.java.ir.IType;
import com.error22.thelta.virtualsystem.java.ir.PrimitiveType;

public class ConversionUtils {
	
	public static IType[] convertTypes(Type[] types) {
		IType[] out = new IType[types.length];
		for(int i = 0; i < out.length; i++) {
			out[i] = convertType(types[i]);
		}
		return out;
	}
	
	public static IType convertType(Type type) {
		if (type == Type.VOID_TYPE) {
			return PrimitiveType.Void;
		} else if (type == Type.INT_TYPE) {
			return PrimitiveType.Int;
		} else if (type == Type.LONG_TYPE) {
			return PrimitiveType.Long;
		} else if (type == Type.FLOAT_TYPE) {
			return PrimitiveType.Float;
		} else if (type == Type.DOUBLE_TYPE) {
			return PrimitiveType.Double;
		} else if (type == InstructionAdapter.OBJECT_TYPE) {
			return PrimitiveType.Object;
		} else {
			throw new IllegalArgumentException(type.toString());
		}
	}

}
