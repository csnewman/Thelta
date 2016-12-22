package com.error22.thelta.virtualsystem;

public class VirtualSystem {
	private Memory memory;
	private Processor processor;

	public VirtualSystem() {
		memory = new Memory(2000);
		processor = new Processor(this, 1);
	}

	public Processor getProcessor() {
		return processor;
	}

	public Memory getMemory() {
		return memory;
	}

	public static void main(String[] args) {
		VirtualSystem system = new VirtualSystem();
		Memory memory = system.getMemory();
		Processor processor = system.getProcessor();
		Core core = processor.getCore(0);

		ProgramWriter writer = new ProgramWriter(memory);
		writer.loadByte((byte) 2);
		writer.loadByte((byte) 3);
		writer.addBytes();
		writer.debugPrintByte();
		core.setupStack(writer.getPosition(), writer.getPosition() + 100, writer.getPosition());
		
		for(int i = 0; i < writer.getInstructionCount(); i++){
			core.step();
		}

	}
}
