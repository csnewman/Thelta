package com.error22.thelta.tubes;

import net.minecraft.util.IStringSerializable;

public enum TubeMode implements IStringSerializable {
	Joint("joint"), X("x"), Y("y"), Z("z");

	private String name;

	private TubeMode(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
}