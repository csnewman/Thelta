package com.error22.thelta.virtualsystem;

import java.nio.ByteBuffer;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;

public class Core {
	private Int2ObjectMap<Integer> pageMapping;
	private Memory memory;
	private Context context;
	private int codePointer;

	public void step() {
		byte instruction = memory.readByte(context, codePointer);
		codePointer += 1;

		switch (instruction) {
		case (byte) 0:

			break;
		default:
			break;
		}

	}

}
