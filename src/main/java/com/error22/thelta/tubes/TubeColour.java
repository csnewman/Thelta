package com.error22.thelta.tubes;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.util.IStringSerializable;

public enum TubeColour implements IStringSerializable {
	Generic("generic"), Red("red");

	private String name;

	private TubeColour(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	public static TubeColour getColourByName(String name) {
		if(!names.containsKey(name))
			return Generic;
		return names.get(name);
	}

	private static Map<String, TubeColour> names;
	static {
		names = new HashMap<String, TubeColour>();
		for (TubeColour colour : values()) {
			names.put(colour.getName(), colour);
		}
	}

}
