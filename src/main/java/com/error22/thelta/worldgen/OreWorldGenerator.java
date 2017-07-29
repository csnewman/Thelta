package com.error22.thelta.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreWorldGenerator implements IWorldGenerator {
	
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		//We set the switch to manual for now.
		//@TODO read the dimension id and put it in the switch statement.
		switch (0){
		case 0:
			generateSurface(random, chunkX * 16, chunkZ * 16, world);
			break;
//		case 1:
//			generateEnd(random, chunkX * 16, chunkZ * 16, world);
//			break;
//		case -1:
//			generateNether(random, chunkX * 16, chunkZ * 16, world);
//			break;
//		default:
//			;
		}
	}
	
	public void generateSurface(final Random random, final int chunkX,
			final int chunkZ, final World world) {
		// Add Overworld Generation
		for (EnumBlockOre ore : EnumBlockOre.values()) {
			if (ore.generation == null) {
				continue;
			}
		}
	}
	
//	public void generateEnd(Random random, int chunkX, int chunkZ, World world) {
//		// Add End Generation
//	}
//	
//	public void generateNether(Random random, int chunkX, int chunkZ,
//			World world) {
//		// Add Nether Generation
//	}
//	
//	public void addOreSpawn(Block block, World world, Random random,
//			int blockXPos, int blockZPos, int minVainSize, int maxVainSize,
//			int chancesToSpawn, int minY, int maxY, Block replaces) {
//		for (int i = 0; i < chancesToSpawn; i++) {
//			int posX = blockXPos + random.nextInt(16);
//			int posY = minY + random.nextInt(maxY - minY);
//			int posZ = blockZPos + random.nextInt(16);
//			new WorldGenMinable(block, minVainSize
//					+ random.nextInt(maxVainSize - minVainSize), replaces)
//					.generate(world, random, posX, posY, posZ);
//		}
//	}
}
