package com.error22.thelta.virtualsystem.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.objectweb.asm.ClassReader;

import com.error22.thelta.virtualsystem.java.ir.JavaClass;
import com.error22.thelta.virtualsystem.java.ir.JavaMethod;
import com.error22.thelta.virtualsystem.java.ir.MethodSignature;
import com.error22.thelta.virtualsystem.java.ir.PrimitiveType;

public class JavaConverter {

	public static void loadFile(JavaProgram program, String file) throws FileNotFoundException, IOException {
		ClassReader classReader = new ClassReader(new FileInputStream(file));
		classReader.accept(new ClassConverter(program), 0);
	}

	public static void main(String[] args) throws Exception {
		JavaProgram program = new JavaProgram();
		loadFile(program, "C:\\Users\\chand\\eclipse-workspace\\Test1\\bin\\com\\tests\\TestC1.class");

		JavaMethod entryMethod = program.getMethod(new MethodSignature("com/tests/TestC1", "example",
				PrimitiveType.Void, PrimitiveType.Int, PrimitiveType.Int));
		System.out.println(" " + entryMethod);

		JavaThread thread = new JavaThread();
		thread.callMethod(entryMethod, new StackObject(PrimitiveType.Int, 1), new StackObject(PrimitiveType.Int, 2));

		while (true)
			thread.step();

	}

}
