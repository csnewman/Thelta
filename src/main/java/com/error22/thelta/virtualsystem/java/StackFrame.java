package com.error22.thelta.virtualsystem.java;

import java.util.Stack;

import com.error22.thelta.virtualsystem.java.instructions.IInstruction;
import com.error22.thelta.virtualsystem.java.ir.JavaMethod;

public class StackFrame {
	private JavaThread thread;
	private JavaMethod method;
	private IInstruction[] instructions;
	private int instructionPointer;
	private StackObject[] locals;
	private Stack<StackObject> stack;

	public StackFrame(JavaThread thread, JavaMethod method) {
		this.thread = thread;
		this.method = method;
		instructions = method.getInstructions();
		stack = new Stack<StackObject>();
	}

	public void init() {
		locals = new StackObject[method.getLocalCount()];
	}

	public void step() {
		IInstruction instruction = instructions[instructionPointer];
		instructionPointer++;
		instruction.execute(this);
	}
	
	public JavaThread getThread() {
		return thread;
	}

	public JavaMethod getMethod() {
		return method;
	}

	public void setLocal(int index, StackObject object) {
		locals[index] = object;
	}

	public StackObject getLocal(int index) {
		return locals[index];
	}

	public void push(StackObject object) {
		stack.push(object);
	}

	public StackObject pop() {
		return stack.pop();
	}

	public void setInstructionPointer(int instructionPointer) {
		this.instructionPointer = instructionPointer;
	}

	public void exit(StackObject result) {
		thread.exitFrame(result);
	}

}
