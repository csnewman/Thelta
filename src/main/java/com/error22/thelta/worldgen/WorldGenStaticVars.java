package com.error22.thelta.worldgen;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class WorldGenStaticVars {
	public static ArrayList<WorldGeneratorOreInstance> worldGenInstances = new ArrayList<WorldGeneratorOreInstance>();
	
	public static WorldGeneratorOreInstance registerNewWorldGenerator(Block targetBlock, int minHeight, int maxHeight, int veinSize, int spawnAttempts) {
		WorldGeneratorOreInstance inst = new WorldGeneratorOreInstance();
		inst.targetBlock = targetBlock;
		inst.minHeight = minHeight;
		inst.maxHeight = maxHeight;
		inst.size = veinSize;
		inst.spawnAttempts = spawnAttempts;
		//Here we are adding the world gen instance to the array list, so we can call it when we are ready to generate the ore.
		worldGenInstances.add(inst);
		return inst;
	}
}
