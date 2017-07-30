package com.error22.thelta.virtualsystem.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.objectweb.asm.ClassReader;

import com.error22.thelta.virtualsystem.java.external.ExternalManager;
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

		ExternalManager manager = program.getExternalManager();
		manager.defineExternalClass("com/tests/Debug");
		
		MethodSignature printInt = new MethodSignature("com/tests/Debug", "printInt", PrimitiveType.Void, PrimitiveType.Int);
		manager.defineHook(printInt);
		manager.bindHook(printInt, sf -> {
			StackObject so = sf.getLocal(0);
			
			System.out.println("DEBUG: (INT) "+so.getValue());
			
			sf.exit(null);
		});

		JavaMethod entryMethod = program
				.getMethod(new MethodSignature("com/tests/TestC1", "entry", PrimitiveType.Void));
		System.out.println(" " + entryMethod);

		JavaThread thread = new JavaThread(program);
		thread.callMethod(entryMethod, new StackObject(PrimitiveType.Int, 30), new StackObject(PrimitiveType.Int, 2));

		while (true)
			thread.step();

	}

}
