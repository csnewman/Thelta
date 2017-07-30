package com.error22.thelta.virtualsystem.java.ir;

import java.util.ArrayList;

import com.error22.thelta.virtualsystem.java.instructions.IInstruction;

public class JavaMethod {
	private String name;
	private IType returnType;
	private IType[] arguments;
	private int localCount;
	private ArrayList<IInstruction> instructions;

	public JavaMethod(String name, IType returnType, IType[] arguments) {
		this.name = name;
		instructions = new ArrayList<IInstruction>();
		this.returnType = returnType;
		this.arguments = arguments;
	}
	
	public void ensureLocalExists(int local) {
		if (localCount <= local)
			localCount = local + 1;
	}

	public void addInstruction(IInstruction instruction) {
		instructions.add(instruction);
	}

}
