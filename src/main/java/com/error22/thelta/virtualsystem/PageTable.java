package com.error22.thelta.virtualsystem;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import scala.NotImplementedError;

public class PageTable {
	private boolean mappingEnabled;
	private Int2ObjectMap<Integer> pageMapping;

	public PageTable() {
		pageMapping = new Int2ObjectOpenHashMap<Integer>();
	}

	public int getPageMapping(int id) {
		if (!pageMapping.containsKey(id)) {
			// TODO: handle unmapped pages
			throw new RuntimeException("Not implemented!");
		}

		return pageMapping.get(id);
	}

	public void mapPage(int id, int to) {
		pageMapping.put(id, (Integer) to);
	}

	public boolean isPageMapped(int id) {
		return pageMapping.containsKey(id);
	}

	public boolean isMappingEnabled() {
		return mappingEnabled;
	}

	public void enablePageMapping() {
		this.mappingEnabled = true;
		// TODO: permission checks
	}

	public void disablePageMapping() {
		this.mappingEnabled = false;
		// TODO: permission checks
	}

}
