package com.error22.thelta.virtualsystem.silver;

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

	public void writeInstruction(short instruction) {
		writeShort(instruction);
		instructionCount++;
	}

	public void writeByte(byte val) {
		memory.writeByte(pageTable, position, val);
		position += 1;
	}

	public void writeShort(short val) {
		memory.writeShort(pageTable, cache, position, val);
		position += 2;
	}

	public void writeInt(int val) {
		memory.writeInt(pageTable, cache, position, val);
		position += 4;
	}

	public void writeLong(long val) {
		memory.writeLong(pageTable, cache, position, val);
		position += 4;
	}

	public void writeFloat(float val) {
		memory.writeFloat(pageTable, cache, position, val);
		position += 4;
	}

	public void writeDouble(double val) {
		memory.writeDouble(pageTable, cache, position, val);
		position += 8;
	}

	public void debugPrintUByte() {
		writeInstruction(Instructions.DEBUG_PRINT_UB);
	}

	public void debugPrintSByte() {
		writeInstruction(Instructions.DEBUG_PRINT_SB);
	}

	public void debugPrintUShort() {
		writeInstruction(Instructions.DEBUG_PRINT_US);
	}

	public void debugPrintSShort() {
		writeInstruction(Instructions.DEBUG_PRINT_SS);
	}

	public void debugPrintUInt() {
		writeInstruction(Instructions.DEBUG_PRINT_UI);
	}

	public void debugPrintSInt() {
		writeInstruction(Instructions.DEBUG_PRINT_SI);
	}

	public void debugPrintULong() {
		writeInstruction(Instructions.DEBUG_PRINT_UL);
	}

	public void debugPrintSLong() {
		writeInstruction(Instructions.DEBUG_PRINT_SL);
	}

	public void debugPrintFloat() {
		writeInstruction(Instructions.DEBUG_PRINT_F);
	}

	public void debugPrintDouble() {
		writeInstruction(Instructions.DEBUG_PRINT_D);
	}

	public void loadConstByte(byte val) {
		writeInstruction(Instructions.LOAD_CONST_B);
		writeByte(val);
	}

	public void loadConstShort(short val) {
		writeInstruction(Instructions.LOAD_CONST_S);
		writeShort(val);
	}

	public void loadConstInt(int val) {
		writeInstruction(Instructions.LOAD_CONST_I);
		writeInt(val);
	}

	public void loadConstLong(long val) {
		writeInstruction(Instructions.LOAD_CONST_L);
		writeLong(val);
	}

	public void loadConstFloat(float val) {
		writeInstruction(Instructions.LOAD_CONST_F);
		writeFloat(val);
	}

	public void loadConstDouble(double val) {
		writeInstruction(Instructions.LOAD_CONST_D);
		writeDouble(val);
	}

	public void addBytes() {
		writeInstruction(Instructions.ADD_B);
	}

	public void addShorts() {
		writeInstruction(Instructions.ADD_S);
	}

	public void addInts() {
		writeInstruction(Instructions.ADD_I);
	}

	public void addLongs() {
		writeInstruction(Instructions.ADD_L);
	}

	public void addFloats() {
		writeInstruction(Instructions.ADD_F);
	}

	public void addDoubles() {
		writeInstruction(Instructions.ADD_D);
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
