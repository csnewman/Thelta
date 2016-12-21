package com.error22.thelta.virtualsystem;

public class VirtualSystem {
	private MemoryManager memory;
	
	public VirtualSystem() {
		memory = new MemoryManager(2000);
	}
	
	public MemoryManager getMemory() {
		return memory;
	}
}
