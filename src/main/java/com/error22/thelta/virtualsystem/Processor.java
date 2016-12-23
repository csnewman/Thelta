package com.error22.thelta.virtualsystem;

public class Processor {
	private VirtualSystem system;
	private Memory memory;
	private int coreCount;
	private Core[] cores;

	public Processor(VirtualSystem system, int coreCount) {
		this.system = system;
		memory = system.getMemory();
		this.coreCount = coreCount;
		cores = new Core[coreCount];
		for (int i = 0; i < coreCount; i++) {
			cores[i] = new Core(memory);
		}
	}

	public Core getCore(int count) {
		return cores[count];
	}

}
