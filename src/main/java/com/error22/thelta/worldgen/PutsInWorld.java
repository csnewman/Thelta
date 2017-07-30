package com.error22.thelta.worldgen;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class PutsInWorld implements IWorldGenerator{

	public Block oreCopper, oreTin;	
	
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.getDimension()){
            case -1: //Nether
                generateNether(world, random, chunkX, chunkZ);
                break;
            case 0: //Overworld
                generateSurface(world, random, chunkX, chunkZ);
                break;
            case 1: //End
                generateEnd(world, random, chunkX, chunkZ);
                break;
        }

    }

	private void generateNether(World world, Random rand, int x, int z) {
		// TODO Auto-generated method stub
		
        }

    private void generateSurface(World world, Random rand, int x, int z) {
		// TODO Auto-generated method stub

    }

    private void generateEnd(World world, Random random, int chunkX, int chunkZ) {
		// TODO Auto-generated method stub
		
	}


    public void generateOre(Block block, World world, Random random, int chunkX, int chunkZ, int minVeinSize, int maxVeinSize, int chance, int minY, int maxY, Block generateIn)
    {
        int veinSize = minVeinSize + random.nextInt(maxVeinSize - minVeinSize);
        int heightRange = maxY - minY;
        WorldGenMinable gen = new WorldGenMinable(block.getDefaultState(), veinSize, BlockMatcher.forBlock(generateIn));
        for (int i = 0; i < chance; i++){
            int xRand = chunkX * 16 + random.nextInt(16);
            int yRand = random.nextInt(heightRange) + minY;
            int zRand = chunkZ * 16 + random.nextInt(16);
            gen.generate(world, random, new BlockPos(xRand, yRand, zRand));
        }
    }

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			net.minecraft.world.gen.IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		// TODO Auto-generated method stub
		
	}

}