package com.error22.thelta.virtualsystem;

import java.util.Random;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

public class MemoryManager {
	private static final boolean DEBUG = false;
	private Int2ObjectMap<MemoryPage> pages;
	private int maxPageId, maxAddress;

	public MemoryManager(int maxPageId) {
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
	
	public byte readByte(int location) {
		// TODO: bound checking
		return getPage(getPageId(location)).readByte(getPageOffset(location));
	}

	public void writeByte(int location, byte data) {
		// TODO: bound checking
		getPage(getPageId(location)).writeByte(getPageOffset(location), data);
	}

	public byte[] readBlock(int start, int size) {
		byte[] result = new byte[size];
		readBlock(start, 0, result, size);
		return result;
	}

	public void readBlock(int start, int dst, byte[] out, int size) {
		debug("Reading block from " + start + " to " + (size + size) + " (" + size + ")");
		// TODO: bound checking

		MemoryPage page;
		int startPage = getPageId(start);
		int endPage = getPageId(start + size);

		page = getPage(startPage);
		if (startPage == endPage) {
			page.readBlock(start - page.getStart(), dst, out, size);
			return;
		}
		page.readBlock(start - page.getStart(), dst, out, MemoryPage.size);

		int curPos = MemoryPage.size;
		for (int currentPage = start + 1; currentPage < endPage; currentPage++) {
			page = getPage(getPageId(curPos));
			page.readBlock(0, dst + curPos, out, MemoryPage.size);
			curPos += MemoryPage.size;
		}

		page = getPage(endPage);
		page.readBlock(0, curPos, out, size - curPos);
	}
	
	
	public void writeBlock(int start, int src, byte[] data, int size) {
		debug("Writing block from " + start + " to " + (size + size) + " (" + size + ")");
		// TODO: bound checking

		MemoryPage page;
		int startPage = getPageId(start);
		int endPage = getPageId(start + size);

		page = getPage(startPage);
		if (startPage == endPage) {
			page.writeBlock(start - page.getStart(), src, data, size);
			return;
		}
		page.writeBlock(start - page.getStart(), src, data, MemoryPage.size);

		int curPos = MemoryPage.size;
		for (int currentPage = start + 1; currentPage < endPage; currentPage++) {
			page = getPage(getPageId(curPos));
			page.writeBlock(0, src + curPos, data, MemoryPage.size);
			curPos += MemoryPage.size;
		}

		page = getPage(endPage);
		page.writeBlock(0, curPos, data, size - curPos);
	}

	public MemoryPage getPage(int id) {
		if (id > maxPageId) {
			// TODO: throw out of memory error
		} else if (id < 0) {
			// TODO: throw invalid page id error
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
