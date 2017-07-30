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

	public void init(StackObject[] arguments) {
		locals = arguments;
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
	
	private void ensureLocalExists(int index) {
		if(locals.length <= index) {
			StackObject[] newLocals = new StackObject[index + 1];
			System.arraycopy(locals, 0, newLocals, 0, locals.length);
			locals = newLocals;
		}
	}

	public void setLocal(int index, StackObject object) {
		ensureLocalExists(index);
		locals[index] = object;
	}

	public StackObject getLocal(int index) {
		ensureLocalExists(index);
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
