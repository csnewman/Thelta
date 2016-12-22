package com.error22.thelta.virtualsystem;

public class ProgramWriter {
	private Memory memory;
	private PageTable pageTable;
	private Cache cache;
	private int position;
	private int instructionCount;

	public ProgramWriter(Memory memory) {
		this.memory = memory;
		pageTable = new PageTable();
		cache = new Cache(64);
	}

	public void writeByte(byte val) {
		memory.writeByte(pageTable, position, val);
		position += 1;
	}

	public void writeInstruction(short instruction) {
		writeShort(instruction);
		instructionCount++;
	}
	
	public void writeShort(short val) {
		memory.writeShort(pageTable, cache, position, val);
		position += 2;
	}

	public void loadByte(byte val) {
		writeInstruction(Instructions.LOAD_B);
		writeByte(val);
	}

	public void addBytes() {
		writeInstruction(Instructions.ADD_B);
	}

	public void debugPrintByte() {
		writeInstruction(Instructions.DEBUG_PRINT_B);
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getPosition() {
		return position;
	}

	public int getInstructionCount() {
		return instructionCount;
	}

	public void setInstructionCount(int instructionCount) {
		this.instructionCount = instructionCount;
	}

}
