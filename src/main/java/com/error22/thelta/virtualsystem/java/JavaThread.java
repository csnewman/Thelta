package com.error22.thelta.virtualsystem.java;

import java.util.Stack;

import com.error22.thelta.virtualsystem.java.ir.JavaMethod;

public class JavaThread {
	private Stack<StackFrame> frames;

	public JavaThread() {
		frames = new Stack<StackFrame>();
	}

	public void callMethod(JavaMethod method, StackObject... arguments) {
		StackFrame frame = new StackFrame(this, method);
		frame.init();
		for (int i = 0; i < arguments.length; i++) {
			frame.setLocal(i, arguments[i]);
		}
		frames.push(frame);
	}

	public void step() {
		frames.peek().step();
	}

	public void exitFrame(StackObject result) {
		frames.pop();
		if (result != null)
			frames.peek().push(result);
	}

}
