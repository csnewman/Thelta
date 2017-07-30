package com.error22.thelta.virtualsystem.java;

import java.util.LinkedList;
import java.util.List;

import org.lwjgl.BufferUtils;
import org.lwjgl.Sys;
import org.objectweb.asm.Label;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.InstructionAdapter;

import com.error22.thelta.NotImplementedException;
import com.error22.thelta.virtualsystem.java.instructions.AddInstruction;
import com.error22.thelta.virtualsystem.java.instructions.IInstruction;
import com.error22.thelta.virtualsystem.java.instructions.LoadConstantInstruction;
import com.error22.thelta.virtualsystem.java.instructions.LoadLocalInstruction;
import com.error22.thelta.virtualsystem.java.instructions.ReturnInstruction;
import com.error22.thelta.virtualsystem.java.instructions.StoreLocalInstruction;
import com.error22.thelta.virtualsystem.java.ir.IType;
import com.error22.thelta.virtualsystem.java.ir.JavaMethod;
import com.error22.thelta.virtualsystem.java.ir.PrimitiveType;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class MethodConverter extends InstructionAdapter {
	private JavaMethod method;

	public MethodConverter(JavaMethod method) {
		super(Opcodes.ASM4, null);
		this.method = method;
	}

	private void addInstruction(IInstruction instruction) {
		method.addInstruction(instruction);
	}

	private IType convertType(Type type) {
		if (type == Type.VOID_TYPE) {
			return PrimitiveType.Void;
		} else if (type == Type.INT_TYPE) {
			return PrimitiveType.Int;
		} else if (type == Type.LONG_TYPE) {
			return PrimitiveType.Long;
		} else if (type == Type.FLOAT_TYPE) {
			return PrimitiveType.Float;
		} else if (type == Type.DOUBLE_TYPE) {
			return PrimitiveType.Double;
		} else if (type == OBJECT_TYPE) {
			return PrimitiveType.Object;
		} else {
			throw new IllegalArgumentException(type.toString());
		}
	}

	@Override
	public void iconst(int cst) {
		addInstruction(new LoadConstantInstruction(PrimitiveType.Int, cst));
	}

	@Override
	public void load(int var, Type type) {
		method.ensureLocalExists(var);
		addInstruction(new LoadLocalInstruction(convertType(type), var));
	}

	@Override
	public void store(int var, Type type) {
		method.ensureLocalExists(var);
		addInstruction(new StoreLocalInstruction(convertType(type), var));
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
		addInstruction(new AddInstruction((PrimitiveType) convertType(type)));
	}

	@Override
	public void areturn(Type t) {
		addInstruction(new ReturnInstruction((PrimitiveType) convertType(t)));
	}

	@Override
	public void visitLabel(Label label) {
		System.out.println("label " + label);
	}

}
