package com.error22.thelta.virtualsystem.silver;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Cache {
	// Left public for speed improvement
	public int size;
	public byte[] data;
	public ByteBuffer buffer;

	public Cache(int size) {
		this.size = size;
		data = new byte[size];
		buffer = ByteBuffer.wrap(data);
		buffer.order(ByteOrder.BIG_ENDIAN);
	}
}
