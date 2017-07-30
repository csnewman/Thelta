package com.error22.thelta.worldgen;

import java.util.Random;

import com.error22.thelta.Context;
import com.error22.thelta.TheltaModule;
import com.error22.thelta.worldgen.PutsInWorld;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TheltaWorld extends TheltaModule {

	public static Block oreCopper, oreTin;
	public static CreativeTabs creativetab;

	@Override
	public void init(Context context) {
		creativetab = context.createTabWithBlock("World Generation", () -> oreCopper);
	}
	public void registerBlocks(Context context) {
		oreCopper = context.createSimpleBlock("thelta_Ore_Copper", Material.ROCK, creativetab);
		oreTin = context.createSimpleBlock("thelta_Ore_Tin", Material.ROCK, creativetab);
	}

	public void postinit() {
		/*
		PutsInWorld TinOre = new PutsInWorld().generateOre(oreTin, world, rand, x, z, 2, 9, 20, 0, 64, Blocks.STONE);
		PutsInWorld CopperOre = new PutsInWorld().generateOre(oreCopper, world, rand, x, z, 2, 9, 20, 0, 64, Blocks.STONE);
		GameRegistry.registerWorldGenerator(TinOre, 0);
		GameRegistry.registerWorldGenerator(CopperOre, 0);*/
	}
}
