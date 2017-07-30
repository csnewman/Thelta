package com.error22.thelta.virtualsystem.java;

import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.InstructionAdapter;

import com.error22.thelta.virtualsystem.java.instructions.AddInstruction;
import com.error22.thelta.virtualsystem.java.instructions.IInstruction;
import com.error22.thelta.virtualsystem.java.instructions.LoadConstantInstruction;
import com.error22.thelta.virtualsystem.java.instructions.LoadLocalInstruction;
import com.error22.thelta.virtualsystem.java.instructions.ReturnInstruction;
import com.error22.thelta.virtualsystem.java.instructions.StoreLocalInstruction;
import com.error22.thelta.virtualsystem.java.ir.JavaMethod;
import com.error22.thelta.virtualsystem.java.ir.PrimitiveType;

public class MethodConverter extends InstructionAdapter {
	private JavaMethod method;

	public MethodConverter(JavaMethod method) {
		super(Opcodes.ASM4, null);
		this.method = method;
	}

	private void addInstruction(IInstruction instruction) {
		method.addInstruction(instruction);
	}

	@Override
	public void iconst(int cst) {
		addInstruction(new LoadConstantInstruction(PrimitiveType.Int, cst));
	}

	@Override
	public void load(int var, Type type) {
		method.ensureLocalExists(var);
		addInstruction(new LoadLocalInstruction(ConversionUtils.convertType(type), var));
	}

	@Override
	public void store(int var, Type type) {
		method.ensureLocalExists(var);
		addInstruction(new StoreLocalInstruction(ConversionUtils.convertType(type), var));
	}

	@Override
	public void invokespecial(String owner, String name, String desc) {
		System.out.println("invokespecial owner:" + owner + "  name:" + name + "   desc:" + desc);
	}

	@Override
	public void getfield(String owner, String name, String desc) {
		// ByteBufUtils.
		System.out.println("getfield owner:" + owner + " name:" + name + " desc:" + desc);
	}

	@Override
	public void putfield(String owner, String name, String desc) {
		System.out.println("putfield owner:" + owner + " name:" + name + " desc:" + desc);
	}

	@Override
	public void add(Type type) {
		addInstruction(new AddInstruction((PrimitiveType) ConversionUtils.convertType(type)));
	}

	@Override
	public void areturn(Type t) {
		addInstruction(new ReturnInstruction((PrimitiveType) ConversionUtils.convertType(t)));
	}

	@Override
	public void visitLabel(Label label) {
		System.out.println("label " + label);
	}

}
