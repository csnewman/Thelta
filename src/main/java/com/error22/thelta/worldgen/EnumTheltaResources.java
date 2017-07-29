package com.error22.thelta.worldgen;

public enum EnumTheltaResources {
	blockCopper(new GenerationInformation(1, 9, 10, 0, 40)),
	blockTin(new GenerationInformation(1, 9, 10, 0, 40));

	public GenerationInformation generation;
	
	private EnumTheltaResources(GenerationInformation generation) {
		
	}
}