package com.error22.thelta.virtualsystem.java;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import com.error22.thelta.virtualsystem.java.ir.IType;
import com.error22.thelta.virtualsystem.java.ir.JavaClass;
import com.error22.thelta.virtualsystem.java.ir.JavaMethod;

public class ClassConverter extends ClassVisitor {
	private JavaClass clazz;

	public ClassConverter() {
		super(Opcodes.ASM4);
	}

	@Override
	public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
		System.out.println("visit");
		clazz = new JavaClass();
	}

	@Override
	public void visitOuterClass(String owner, String name, String desc) {
		System.out.println("visitOuterClass");
	}

	@Override
	public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
		System.out.println(name + " " + desc + " " + signature + " " + value);
		return super.visitField(access, name, desc, signature, value);
	}

	@Override
	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
		System.out.println("\n" + name + desc);

		IType returnType = ConversionUtils.convertType(Type.getReturnType(desc));
		IType[] arguments = ConversionUtils.convertTypes(Type.getArgumentTypes(desc));
		
		JavaMethod method = new JavaMethod(name, returnType, arguments);
		clazz.addMethod(method);
		return new MethodConverter(method);
	}

}