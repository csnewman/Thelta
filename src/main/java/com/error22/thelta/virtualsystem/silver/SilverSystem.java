package com.error22.thelta.virtualsystem.silver;

import com.error22.thelta.virtualsystem.ICore;
import com.error22.thelta.virtualsystem.Memory;
import com.error22.thelta.virtualsystem.Processor;

public class SilverSystem {
	private Memory memory;
	private Processor processor;

	public SilverSystem() {
		memory = new Memory(2000);
		SilverCore core = new SilverCore(memory);
		processor = new Processor(new ICore[] { core });
	}

	public Processor getProcessor() {
		return processor;
	}

	public Memory getMemory() {
		return memory;
	}

	public static void main(String[] args) {
		SilverSystem system = new SilverSystem();
		Memory memory = system.getMemory();
		Processor processor = system.getProcessor();
		SilverCore core = (SilverCore) processor.getCore(0);

		ProgramWriter writer = new ProgramWriter(memory);
		writer.loadConstByte((byte) 11);
		writer.loadConstByte((byte) 10);
		writer.loadConstByte((byte) 12);
		writer.loadConstByte((byte) -50);
		writer.addBytes();
		writer.addBytes();
		writer.addBytes();
		writer.debugPrintSByte();
		core.setupStack(writer.getPosition(), writer.getPosition() + 100, writer.getPosition());

		System.out.println("Stack start " + writer.getPosition());

		for (int i = 0; i < writer.getInstructionCount(); i++) {
			core.step();
		}

	}
}
