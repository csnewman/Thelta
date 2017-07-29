package com.error22.thelta.virtualsystem.java;

import java.io.FileInputStream;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.InstructionAdapter;

public class JavaConverter {
	
	public static class TestVisitor extends ClassVisitor{

		public TestVisitor() {
			super(Opcodes.ASM4);
		}
		
		@Override
		public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
			System.out.println("\n"+name+desc);
			
			return new TestInstructions();
		}
		
	}
	
	public static class TestInstructions extends InstructionAdapter {

		public TestInstructions() {
			super(Opcodes.ASM4, new MethodVisitor(Opcodes.ASM4) {
			});
		}
		
		@Override
		public void iconst(int cst) {
			System.out.println("const "+cst);
		}
		
		
	}

	public static void main(String[] args) throws Exception{
		ClassReader classReader = new ClassReader(
				new FileInputStream("C:\\Users\\chand\\eclipse-workspace\\Test1\\bin\\com\\tests\\TestC1.class"));
		classReader.accept(new TestVisitor(), 0);
	}

}
