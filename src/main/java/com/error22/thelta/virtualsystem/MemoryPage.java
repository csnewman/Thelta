package com.error22.thelta.virtualsystem;

import java.util.Random;

import com.google.common.primitives.UnsignedInteger;
import com.google.common.primitives.UnsignedInts;

public class MemoryPage {
	private static Random random = new Random();
	private static final boolean DEBUG = false;
	public static final int size = 512;
	private int id, start;
	private byte[] content;

	public MemoryPage(int id) {
		this.id = id;
		start = id * size;
		content = new byte[size];
		random.nextBytes(content);
	}
	
	public void writeBlock(int start, int src, byte[] data, int size) {
		debug("Writing from " + start + " to " + (start + size) + " (" + size + ")");
		System.arraycopy(data, src, content, start, size);
	}

	public void readBlock(int start, int dst, byte[] out, int size) {
		debug("Reading from " + start + " to " + (start + size) + " (" + size + ")");
		System.arraycopy(content, start, out, dst, size);
	}
	
	public void writeByte(int location, byte data) {
		debug("Writing to " + location);
		content[location] = data;
	}
	
	public byte readByte(int location) {
		debug("Reading from " + location);
		return content[location];
	}

	public int getStart() {
		return start;
	}

	public byte[] getContent() {
		return content;
	}
	
	private void debug(String text) {
		if (DEBUG)
			System.out.println("[PAGE="+id+"] "+text);
	}

}
