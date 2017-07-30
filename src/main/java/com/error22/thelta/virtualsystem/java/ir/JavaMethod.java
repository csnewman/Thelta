package com.error22.thelta.virtualsystem.java.ir;

import java.util.ArrayList;

import com.error22.thelta.virtualsystem.java.instructions.IInstruction;

public class JavaMethod {
	private MethodSignature signature;
	private ArrayList<IInstruction> instructions;

	public JavaMethod(MethodSignature signature) {
		this.signature = signature;
		instructions = new ArrayList<IInstruction>();
	}
	
	public void addInstruction(IInstruction instruction) {
		instructions.add(instruction);
	}
	
	public IInstruction[] getInstructions() {
		return instructions.toArray(new IInstruction[0]);
	}
	
	public MethodSignature getSignature() {
		return signature;
	}

}
