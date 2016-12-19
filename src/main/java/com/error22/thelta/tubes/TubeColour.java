package com.error22.thelta.tubes;

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
}
