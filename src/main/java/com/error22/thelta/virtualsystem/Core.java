package com.error22.thelta.virtualsystem;

import java.nio.ByteBuffer;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;

public class Core {
//	private Int2ObjectMap<Integer> pageMapping;
	private Memory memory;
	private PageTable pageTable;
	private int codePointer, stackPointer, stackMax, stackMin;
	private Cache cache;
	
	public Core(Memory memory) {
		this.memory = memory;
		pageTable = new PageTable();
		cache = new Cache(64);
	}
	
	public void setupStack(int min, int max, int pointer){
		stackMin = min;
		stackMax = max;
		stackPointer = pointer;
	}
	
	private void moveStackPointer(int by){
		stackPointer += by;
		
		if(stackPointer < stackMin){
			//TODO: stack underflow
		}else if(stackPointer > stackMax){
			//TODO: stack overflow
		}
	}
	
	private void pushByte(byte val){
		moveStackPointer(1);
		memory.writeByte(pageTable, stackPointer, val);
	}
	
	private byte popByte(){
		byte val = memory.readByte(pageTable, stackPointer);
		moveStackPointer(-1);
		return val;
	}
	
	private short popShort(){
		short val = memory.readShort(pageTable, cache, stackPointer);
		moveStackPointer(-2);
		return val;
	}
	
	private int popInt(){
		int val = memory.readInt(pageTable, cache, stackPointer);
		moveStackPointer(-4);
		return val;
	}
	
	private float popFloat(){
		float val = memory.readFloat(pageTable, cache, stackPointer);
		moveStackPointer(-8);
		return val;
	}
	
	private double popDouble(){
		double val = memory.readDouble(pageTable, cache, stackPointer);
		moveStackPointer(-8);
		return val;
	}
	
	public void step() {
		short instruction = memory.readShort(pageTable, cache, codePointer);
		codePointer += 2;

		if(instruction == Instructions.DEBUG_PRINT_B){
			byte val = popByte();
			System.out.println("[DEBUG] byte "+val);
		}else if(instruction == Instructions.LOAD_B){
			//TODO: Overflow check
			pushByte(memory.readByte(pageTable, codePointer));
			codePointer += 1;
		}else if(instruction == Instructions.ADD_B){
			//TODO: Overflow check
			pushByte((byte)(popByte() + popByte()));
		}else{
			throw new RuntimeException("Unknown instruction");
		}
		

	}

}
