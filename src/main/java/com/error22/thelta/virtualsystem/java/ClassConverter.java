package com.error22.thelta.virtualsystem.java;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import com.error22.thelta.virtualsystem.java.ir.JavaMethod;

public class ClassConverter extends ClassVisitor {

	public ClassConverter() {
		super(Opcodes.ASM4);
	}

	@Override
	public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
		System.out.println(name + " " + desc + " " + signature + " " + value);
		return super.visitField(access, name, desc, signature, value);
	}

	@Override
	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
		System.out.println("\n" + name + desc);

		JavaMethod method = new JavaMethod();

		return new MethodConverter(method);
	}

}