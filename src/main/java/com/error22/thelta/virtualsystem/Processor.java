package com.error22.thelta.virtualsystem;

public class Processor {
	private VirtualSystem system;
	private Memory memory;
	private int coreCount;

	public Processor(VirtualSystem system, int coreCount) {
		this.system = system;
		memory = system.getMemory();
		this.coreCount = coreCount;
	}

}
