package com.error22.thelta.virtualsystem;

public class VirtualSystem {
	private Memory memory;

	public VirtualSystem() {
		memory = new Memory(2000);
	}

	public Memory getMemory() {
		return memory;
	}
}
