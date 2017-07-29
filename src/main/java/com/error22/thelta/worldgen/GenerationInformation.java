package com.error22.thelta.worldgen;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class GenerationInformation {
	public int minVainSize, maxVainSize, chancesToSpawn, minY, maxY;
	public Block replaces;
	
	public GenerationInformation(int minVainSize, int maxVainSize, int chancesToSpawn, int minY, int maxY, Block replaces) {
		this.minVainSize = minVainSize;
		this.maxVainSize = maxVainSize;
		this.chancesToSpawn = chancesToSpawn;
		this.minY = minY;
		this.maxY = maxY;
		this.replaces = replaces;
	}
	
	public GenerationInformation(int minVainSize, int maxVainSize, int chancesToSpawn, int minY, int maxY) {
		this(minVainSize, maxVainSize, chancesToSpawn, minY, maxY, Blocks.STONE);
	}
}
