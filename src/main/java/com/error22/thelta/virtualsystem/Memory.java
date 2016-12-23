package com.error22.thelta.virtualsystem;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

public class Memory {
	private static final boolean DEBUG = false;
	private Int2ObjectMap<MemoryPage> pages;
	private int maxPageId, maxAddress;

	public Memory(int maxPageId) {
		pages = new Int2ObjectOpenHashMap<MemoryPage>();
		this.maxPageId = maxPageId;
		maxAddress = MemoryPage.size * maxPageId;
	}

	public void allocatePages(int startId, int count) {
		debug("Allocating pages " + startId + " to " + (startId + count) + " (" + count + ")");
		for (int i = 0; i < count; i++) {
			int id = startId + i;
			if (pages.containsKey(id)) {
				pages.put(id, new MemoryPage(id));
			}
		}
	}

	public short readShort(PageTable pageTable, Cache cache, int location) {
		readBlock(pageTable, location, 0, cache.data, 2);
		return cache.buffer.getShort(0);
	}

	public void writeShort(PageTable pageTable, Cache cache, int location, short value) {
		cache.buffer.putShort(0, value);
		writeBlock(pageTable, location, 0, cache.data, 2);
	}

	public int readInt(PageTable pageTable, Cache cache, int location) {
		readBlock(pageTable, location, 0, cache.data, 4);
		return cache.buffer.getInt(0);
	}

	public void writeInt(PageTable pageTable, Cache cache, int location, int value) {
		cache.buffer.putInt(0, value);
		writeBlock(pageTable, location, 0, cache.data, 4);
	}

	public long readLong(PageTable pageTable, Cache cache, int location) {
		readBlock(pageTable, location, 0, cache.data, 8);
		return cache.buffer.getLong(0);
	}

	public void writeLong(PageTable pageTable, Cache cache, int location, long value) {
		cache.buffer.putLong(0, value);
		writeBlock(pageTable, location, 0, cache.data, 8);
	}

	public float readFloat(PageTable pageTable, Cache cache, int location) {
		readBlock(pageTable, location, 0, cache.data, 4);
		return cache.buffer.getFloat(0);
	}

	public void writeFloat(PageTable pageTable, Cache cache, int location, float value) {
		cache.buffer.putFloat(value);
		writeBlock(pageTable, location, 0, cache.data, 4);
	}

	public double readDouble(PageTable pageTable, Cache cache, int location) {
		readBlock(pageTable, location, 0, cache.data, 8);
		return cache.buffer.getDouble(0);
	}

	public void writeDouble(PageTable pageTable, Cache cache, int location, double value) {
		cache.buffer.putDouble(value);
		writeBlock(pageTable, location, 0, cache.data, 8);
	}

	public byte readByte(PageTable pageTable, int location) {
		// TODO: bound checking
		return getPage(pageTable, getPageId(location)).readByte(getPageOffset(location));
	}

	public void writeByte(PageTable pageTable, int location, byte data) {
		// TODO: bound checking
		getPage(pageTable, getPageId(location)).writeByte(getPageOffset(location), data);
	}

	public byte[] readBlock(PageTable pageTable, int start, int size) {
		byte[] result = new byte[size];
		readBlock(pageTable, start, 0, result, size);
		return result;
	}

	public void writeBlock(PageTable pageTable, int start, byte[] data) {
		writeBlock(pageTable, start, 0, data, data.length);
	}

	public void readBlock(PageTable pageTable, int start, int dst, byte[] out, int size) {
		debug("Reading block from " + start + " to " + (size + size) + " (" + size + ")");
		// TODO: bound checking

		MemoryPage page;
		int startPage = getPageId(start);
		int endPage = getPageId(start + size);

		page = getPage(pageTable, startPage);
		if (startPage == endPage) {
			page.readBlock(start - page.getStart(), dst, out, size);
			return;
		}
		page.readBlock(start - page.getStart(), dst, out, MemoryPage.size);

		int curPos = MemoryPage.size;
		for (int currentPage = start + 1; currentPage < endPage; currentPage++) {
			page = getPage(pageTable, getPageId(curPos));
			page.readBlock(0, dst + curPos, out, MemoryPage.size);
			curPos += MemoryPage.size;
		}

		page = getPage(pageTable, endPage);
		page.readBlock(0, curPos, out, size - curPos);
	}

	public void writeBlock(PageTable pageTable, int start, int src, byte[] data, int size) {
		debug("Writing block from " + start + " to " + (size + size) + " (" + size + ")");
		// TODO: bound checking

		MemoryPage page;
		int startPage = getPageId(start);
		int endPage = getPageId(start + size);

		page = getPage(pageTable, startPage);
		if (startPage == endPage) {
			page.writeBlock(start - page.getStart(), src, data, size);
			return;
		}
		page.writeBlock(start - page.getStart(), src, data, MemoryPage.size);

		int curPos = MemoryPage.size;
		for (int currentPage = start + 1; currentPage < endPage; currentPage++) {
			page = getPage(pageTable, getPageId(curPos));
			page.writeBlock(0, src + curPos, data, MemoryPage.size);
			curPos += MemoryPage.size;
		}

		page = getPage(pageTable, endPage);
		page.writeBlock(0, curPos, data, size - curPos);
	}

	public MemoryPage getPage(PageTable pageTable, int id) {
		if (id > maxPageId) {
			// TODO: throw out of memory error
		} else if (id < 0) {
			// TODO: throw invalid page id error
		}

		if (pageTable.isMappingEnabled()) {
			id = pageTable.getPageMapping(id);
		}

		if (pages.containsKey(id))
			return pages.get(id);
		MemoryPage page = new MemoryPage(id);
		pages.put(id, page);
		return page;
	}

	public int getPageId(int location) {
		// TODO: bound checking
		return location / MemoryPage.size;
	}

	public int getPageOffset(int location) {
		// TODO: bound checking
		return location % MemoryPage.size;
	}

	public int getMaxAddress() {
		return maxAddress;
	}

	public int getMaxPageId() {
		return maxPageId;
	}

	private void debug(String text) {
		if (DEBUG)
			System.out.println("[MEMORY] " + text);
	}

}
