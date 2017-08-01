package com.error22.thelta.virtualsystem.java;

import org.objectweb.asm.Type;
import org.objectweb.asm.commons.InstructionAdapter;

import com.error22.thelta.virtualsystem.java.ir.ArrayType;
import com.error22.thelta.virtualsystem.java.ir.FieldSignature;
import com.error22.thelta.virtualsystem.java.ir.IType;
import com.error22.thelta.virtualsystem.java.ir.MethodSignature;
import com.error22.thelta.virtualsystem.java.ir.ObjectType;
import com.error22.thelta.virtualsystem.java.ir.PrimitiveType;
import com.error22.thelta.virtualsystem.java.ir.StringType;

public class ConversionUtils {

	public static MethodSignature parseMethodSignature(String parent, String name, String desc) {
		IType returnType = ConversionUtils.convertType(Type.getReturnType(desc));
		IType[] arguments = ConversionUtils.convertTypes(Type.getArgumentTypes(desc));
		return new MethodSignature(parent, name, returnType, arguments);
	}

	public static FieldSignature parseFieldSignature(String owner, String name, String desc) {
		return new FieldSignature(owner, name, ConversionUtils.convertType(Type.getType(desc)));
	}

	public static IType[] convertTypes(Type[] types) {
		IType[] out = new IType[types.length];
		for (int i = 0; i < out.length; i++) {
			out[i] = convertType(types[i]);
		}
		return out;
	}

	public static IType convertType(Type type) {
		if (type == Type.VOID_TYPE) {
			return PrimitiveType.Void;
		} else if (type == Type.BOOLEAN_TYPE) {
			return PrimitiveType.Boolean;
		} else if (type == Type.CHAR_TYPE) {
			return PrimitiveType.Char;
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
		} else if (type.getDescriptor().equals("Ljava/lang/String;")) {
			return StringType.INSTANCE;
		} else if (type.getSort() == Type.OBJECT) {
			return new ObjectType(type.getClassName().replaceAll("\\.", "/"));
		} else if (type.getSort() == Type.ARRAY) {
			return new ArrayType(convertType(type.getElementType()));
		} else {
			throw new IllegalArgumentException(type.toString() + " sort=" + type.getSort());
		}
	}

}
