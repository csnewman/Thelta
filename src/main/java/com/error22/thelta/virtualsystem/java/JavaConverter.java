package com.error22.thelta.virtualsystem.java;

import java.io.FileInputStream;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Label;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.InstructionAdapter;

public class JavaConverter {
	
	public static void main(String[] args) throws Exception{
		ClassReader classReader = new ClassReader(
				new FileInputStream("C:\\Users\\chand\\eclipse-workspace\\Test1\\bin\\com\\tests\\TestC1.class"));
		classReader.accept(new ClassConverter(), 0);
	}

}
