package com.error22.thelta.virtualsystem.java.ir;

import java.util.ArrayList;

import com.error22.thelta.virtualsystem.java.instructions.IInstruction;

public class JavaMethod {
	private MethodSignature signature;
	private int localCount;
	private ArrayList<IInstruction> instructions;

	public JavaMethod(MethodSignature signature) {
		this.signature = signature;
		instructions = new ArrayList<IInstruction>();
	}

	public void ensureLocalExists(int local) {
		if (localCount <= local)
			localCount = local + 1;
	}

	public void addInstruction(IInstruction instruction) {
		instructions.add(instruction);
	}
	
	public MethodSignature getSignature() {
		return signature;
	}

}
