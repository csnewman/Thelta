package com.error22.thelta.virtualsystem.silver;

public class SilverCore{
	private Memory memory;
	private PageTable pageTable;
	private int codePointer, stackPointer, stackMax, stackMin;
	private Cache cache;

	public SilverCore(Memory memory) {
		this.memory = memory;
		pageTable = new PageTable();
		cache = new Cache(64);
	}

	public void setupStack(int min, int max, int pointer) {
		stackMin = min;
		stackMax = max;
		stackPointer = pointer;
	}

	public void step() {
		short instruction = memory.readShort(pageTable, cache, codePointer);
		moveCodePointer(2);

		switch (instruction) {
		case Instructions.DEBUG_PRINT_UB:
			System.out.println("[DEBUG] ubyte " + ALU.ubyteToString(popByte()));
			break;
		case Instructions.DEBUG_PRINT_SB:
			System.out.println("[DEBUG] sbyte " + ALU.sbyteToString(popByte()));
			break;
		case Instructions.DEBUG_PRINT_US:
			System.out.println("[DEBUG] ushort " + ALU.ushortToString(popShort()));
			break;
		case Instructions.DEBUG_PRINT_SS:
			System.out.println("[DEBUG] sshort " + ALU.sshortToString(popShort()));
			break;
		case Instructions.DEBUG_PRINT_UI:
			System.out.println("[DEBUG] uint " + ALU.uintToString(popInt()));
			break;
		case Instructions.DEBUG_PRINT_SI:
			System.out.println("[DEBUG] sint " + ALU.sintToString(popInt()));
			break;
		case Instructions.DEBUG_PRINT_UL:
			System.out.println("[DEBUG] ulong " + ALU.ulongToString(popLong()));
			break;
		case Instructions.DEBUG_PRINT_SL:
			System.out.println("[DEBUG] slong " + ALU.slongToString(popLong()));
			break;
		case Instructions.DEBUG_PRINT_F:
			System.out.println("[DEBUG] float " + popFloat());
			break;
		case Instructions.DEBUG_PRINT_D:
			System.out.println("[DEBUG] double " + popDouble());
			break;

		case Instructions.LOAD_CONST_B:
			copyToStack(codePointer, 1);
			moveCodePointer(1);
			break;
		case Instructions.LOAD_CONST_S:
			copyToStack(codePointer, 2);
			moveCodePointer(2);
			break;
		case Instructions.LOAD_CONST_I:
			copyToStack(codePointer, 4);
			moveCodePointer(4);
			break;
		case Instructions.LOAD_CONST_L:
			copyToStack(codePointer, 8);
			moveCodePointer(8);
			break;
		case Instructions.LOAD_CONST_F:
			copyToStack(codePointer, 4);
			moveCodePointer(2);
			break;
		case Instructions.LOAD_CONST_D:
			copyToStack(codePointer, 8);
			moveCodePointer(2);
			break;

		case Instructions.POP_B:
			// TODO: Overflow check
			popByte();
			break;
		case Instructions.POP_S:
			// TODO: Overflow check
			popShort();
			break;
		case Instructions.POP_I:
			// TODO: Overflow check
			popInt();
			break;
		case Instructions.POP_L:
			// TODO: Overflow check
			popLong();
			break;
		case Instructions.POP_F:
			// TODO: Overflow check
			popFloat();
			break;
		case Instructions.POP_D:
			// TODO: Overflow check
			popDouble();
			break;

		case Instructions.ADD_B:
			pushByte(ALU.addBytes(popByte(), popByte()));
			break;
		case Instructions.ADD_S:
			pushShort(ALU.addShorts(popShort(), popShort()));
			break;
		case Instructions.ADD_I:
			pushInt(ALU.addInts(popInt(), popInt()));
			break;
		case Instructions.ADD_L:
			pushLong(ALU.addLongs(popLong(), popLong()));
			break;
		case Instructions.ADD_F:
			pushFloat(popFloat() + popFloat());
			break;
		case Instructions.ADD_D:
			pushDouble(popDouble() + popDouble());
			break;

		default:
			throw new RuntimeException("Unknown instruction " + instruction);
		}

	}

	private void moveStackPointer(int by) {
		stackPointer += by;

		if (stackPointer < stackMin) {
			// TODO: stack underflow
		} else if (stackPointer > stackMax) {
			// TODO: stack overflow
		}
	}

	private void moveCodePointer(int by) {
		codePointer += by;

		// TODO: Check memory region
	}

	private void copyToStack(int position, int size) {
		moveStackPointer(size);
		byte[] data = new byte[size];
		memory.readBlock(pageTable, position, 0, data, size);
		memory.writeBlock(pageTable, stackPointer - size, 0, data, size);
	}

	private void pushByte(byte val) {
		moveStackPointer(1);
		memory.writeByte(pageTable, stackPointer - 1, val);
	}

	private byte popByte() {
		moveStackPointer(-1);
		return memory.readByte(pageTable, stackPointer);
	}

	private void pushShort(short val) {
		moveStackPointer(2);
		memory.writeShort(pageTable, cache, stackPointer - 2, val);
	}

	private short popShort() {
		moveStackPointer(-2);
		return memory.readShort(pageTable, cache, stackPointer);
	}

	private void pushInt(int val) {
		moveStackPointer(4);
		memory.writeInt(pageTable, cache, stackPointer - 4, val);
	}

	private int popInt() {
		moveStackPointer(-4);
		return memory.readInt(pageTable, cache, stackPointer);
	}

	private void pushLong(long val) {
		moveStackPointer(8);
		memory.writeLong(pageTable, cache, stackPointer - 8, val);
	}

	private long popLong() {
		moveStackPointer(-8);
		return memory.readLong(pageTable, cache, stackPointer);
	}

	private void pushFloat(float val) {
		moveStackPointer(4);
		memory.writeFloat(pageTable, cache, stackPointer - 4, val);
	}

	private float popFloat() {
		moveStackPointer(-4);
		return memory.readFloat(pageTable, cache, stackPointer);
	}

	private void pushDouble(double val) {
		moveStackPointer(8);
		memory.writeDouble(pageTable, cache, stackPointer - 8, val);
	}

	private double popDouble() {
		moveStackPointer(-8);
		return memory.readDouble(pageTable, cache, stackPointer);
	}

}
