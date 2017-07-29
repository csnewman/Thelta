package com.error22.thelta.worldgen;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class PutsInWorld implements IWorldGenerator {
	
	@Nullable
	private WorldGenMinable copperGenerator;
	@Nullable
	private WorldGenMinable tinGenerator;
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		generateWorld(random, chunkX, chunkZ, world);
	}
	
	public void generateWorld(Random random, int chunkX, int chunkZ, World world) {
	
		if (apatiteGenerator == null || copperGenerator == null || tinGenerator == null) {
			BlockResourceOre resourcesBlock = PluginCore.getBlocks().resources;

			IBlockState apatiteBlockState = resourcesBlock.getStateFromMeta(EnumResourceType.APATITE.getMeta());
			IBlockState copperBlockState = resourcesBlock.getStateFromMeta(EnumResourceType.COPPER.getMeta());
			IBlockState tinBlockState = resourcesBlock.getStateFromMeta(EnumResourceType.TIN.getMeta());
			apatiteGenerator = new WorldGenMinable(apatiteBlockState, 36);
			copperGenerator = new WorldGenMinable(copperBlockState, 6);
			tinGenerator = new WorldGenMinable(tinBlockState, 6);
		}

		
		// shift to world coordinates
		int x = chunkX << 4;
		int y = chunkZ << 4;
	
		// / COPPER
		if (EnumTheltaResources.blockCopper != null) {
			for (int i = 0; i < 20; i++) {
				int randPosX = x + random.nextInt(16);
				int randPosY = random.nextInt(76) + 32;
				int randPosZ = y + random.nextInt(16);
				copperGenerator.generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
			}
		}
	
		// / TIN
		if (EnumTheltaResources.blockTin != null) {
			for (int i = 0; i < 18; i++) {
				int randPosX = x + random.nextInt(16);
				int randPosY = random.nextInt(76) + 16;
				int randPosZ = y + random.nextInt(16);
				tinGenerator.generate(world, random, new BlockPos(randPosX, randPosY, randPosZ));
			}
		}
	}
}