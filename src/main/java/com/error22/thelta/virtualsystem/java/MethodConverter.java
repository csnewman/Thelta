package com.error22.thelta.virtualsystem.java;

import java.util.ArrayList;
import java.util.List;

import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.InstructionAdapter;

import com.error22.thelta.NotImplementedException;
import com.error22.thelta.virtualsystem.java.instructions.AddInstruction;
import com.error22.thelta.virtualsystem.java.instructions.GetFieldInstruction;
import com.error22.thelta.virtualsystem.java.instructions.GetStaticInstruction;
import com.error22.thelta.virtualsystem.java.instructions.IInstruction;
import com.error22.thelta.virtualsystem.java.instructions.InvokeSpecialInstruction;
import com.error22.thelta.virtualsystem.java.instructions.InvokeStaticInstruction;
import com.error22.thelta.virtualsystem.java.instructions.LoadConstantInstruction;
import com.error22.thelta.virtualsystem.java.instructions.LoadLocalInstruction;
import com.error22.thelta.virtualsystem.java.instructions.PutFieldInstruction;
import com.error22.thelta.virtualsystem.java.instructions.PutStaticInstruction;
import com.error22.thelta.virtualsystem.java.instructions.ReturnInstruction;
import com.error22.thelta.virtualsystem.java.instructions.StoreLocalInstruction;
import com.error22.thelta.virtualsystem.java.ir.JavaMethod;
import com.error22.thelta.virtualsystem.java.ir.PrimitiveType;
import com.error22.thelta.virtualsystem.java.ir.StringType;

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
	public void visitInsn(int opcode) {
		if (!SUPPORTED_OPS.contains(opcode))
			throw new NotImplementedException("OP: " + opcode);
		super.visitInsn(opcode);
	}

	@Override
	public void visitFieldInsn(int opcode, String owner, String name, String desc) {
		if (!SUPPORTED_OPS.contains(opcode))
			throw new NotImplementedException("OP: " + opcode);
		super.visitFieldInsn(opcode, owner, name, desc);
	}

	@Override
	public void visitIntInsn(int opcode, int operand) {
		if (!SUPPORTED_OPS.contains(opcode))
			throw new NotImplementedException("OP: " + opcode);
		super.visitIntInsn(opcode, operand);
	}

	@Override
	public void visitJumpInsn(int opcode, Label label) {
		if (!SUPPORTED_OPS.contains(opcode))
			throw new NotImplementedException("OP: " + opcode);
		super.visitJumpInsn(opcode, label);
	}

	@Override
	public void visitMethodInsn(int opcode, String owner, String name, String desc) {
		if (!SUPPORTED_OPS.contains(opcode))
			throw new NotImplementedException("OP: " + opcode);
		super.visitMethodInsn(opcode, owner, name, desc);
	}

	@Override
	public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
		if (!SUPPORTED_OPS.contains(opcode))
			throw new NotImplementedException("OP: " + opcode);
		super.visitMethodInsn(opcode, owner, name, desc, itf);
	}

	@Override
	public void visitTypeInsn(int opcode, String type) {
		if (!SUPPORTED_OPS.contains(opcode))
			throw new NotImplementedException("OP: " + opcode);
		super.visitTypeInsn(opcode, type);
	}

	@Override
	public void visitVarInsn(int opcode, int var) {
		if (!SUPPORTED_OPS.contains(opcode))
			throw new NotImplementedException("OP: " + opcode);
		super.visitVarInsn(opcode, var);
	}

	@Override
	public void iconst(int cst) {
		addInstruction(new LoadConstantInstruction(PrimitiveType.Int, cst));
	}

	@Override
	public void aconst(Object cst) {
		if (cst == null)
			addInstruction(new LoadConstantInstruction(PrimitiveType.Object, null));
		else
			addInstruction(new LoadConstantInstruction(StringType.INSTANCE, cst));
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
	public void invokestatic(String owner, String name, String desc) {
		addInstruction(new InvokeStaticInstruction(ConversionUtils.parseMethodSignature(owner, name, desc)));
	}

	@Override
	public void invokespecial(String owner, String name, String desc) {
		addInstruction(new InvokeSpecialInstruction(ConversionUtils.parseMethodSignature(owner, name, desc)));
	}

	@Override
	public void getfield(String owner, String name, String desc) {
		addInstruction(new GetFieldInstruction(ConversionUtils.parseFieldSignature(owner, name, desc)));
	}

	@Override
	public void putfield(String owner, String name, String desc) {
		addInstruction(new PutFieldInstruction(ConversionUtils.parseFieldSignature(owner, name, desc)));
	}

	@Override
	public void getstatic(String owner, String name, String desc) {
		addInstruction(new GetStaticInstruction(ConversionUtils.parseFieldSignature(owner, name, desc)));
	}

	@Override
	public void putstatic(String owner, String name, String desc) {
		addInstruction(new PutStaticInstruction(ConversionUtils.parseFieldSignature(owner, name, desc)));
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

	private static List<Integer> SUPPORTED_OPS;
	static {
		SUPPORTED_OPS = new ArrayList<Integer>();
		SUPPORTED_OPS.add(Opcodes.ICONST_M1);
		SUPPORTED_OPS.add(Opcodes.ICONST_0);
		SUPPORTED_OPS.add(Opcodes.ICONST_1);
		SUPPORTED_OPS.add(Opcodes.ICONST_2);
		SUPPORTED_OPS.add(Opcodes.ICONST_3);
		SUPPORTED_OPS.add(Opcodes.ICONST_4);
		SUPPORTED_OPS.add(Opcodes.ICONST_5);
		SUPPORTED_OPS.add(Opcodes.BIPUSH);
		SUPPORTED_OPS.add(Opcodes.SIPUSH);
		SUPPORTED_OPS.add(Opcodes.ILOAD);
		SUPPORTED_OPS.add(Opcodes.LLOAD);
		SUPPORTED_OPS.add(Opcodes.FLOAD);
		SUPPORTED_OPS.add(Opcodes.DLOAD);
		SUPPORTED_OPS.add(Opcodes.ALOAD);
		SUPPORTED_OPS.add(Opcodes.ISTORE);
		SUPPORTED_OPS.add(Opcodes.LSTORE);
		SUPPORTED_OPS.add(Opcodes.FSTORE);
		SUPPORTED_OPS.add(Opcodes.DSTORE);
		SUPPORTED_OPS.add(Opcodes.ASTORE);
		SUPPORTED_OPS.add(Opcodes.IADD);
		SUPPORTED_OPS.add(Opcodes.LADD);
		SUPPORTED_OPS.add(Opcodes.FADD);
		SUPPORTED_OPS.add(Opcodes.DADD);
		SUPPORTED_OPS.add(Opcodes.IRETURN);
		SUPPORTED_OPS.add(Opcodes.LRETURN);
		SUPPORTED_OPS.add(Opcodes.FRETURN);
		SUPPORTED_OPS.add(Opcodes.DRETURN);
		SUPPORTED_OPS.add(Opcodes.ARETURN);
		SUPPORTED_OPS.add(Opcodes.RETURN);
		SUPPORTED_OPS.add(Opcodes.INVOKESTATIC);
		SUPPORTED_OPS.add(Opcodes.INVOKESPECIAL);
		SUPPORTED_OPS.add(Opcodes.GETFIELD);
		SUPPORTED_OPS.add(Opcodes.PUTFIELD);
		SUPPORTED_OPS.add(Opcodes.GETSTATIC);
		SUPPORTED_OPS.add(Opcodes.PUTSTATIC);
	}

}
