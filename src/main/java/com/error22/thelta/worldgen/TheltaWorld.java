package com.error22.thelta.worldgen;

import java.util.Random;

import com.error22.thelta.Context;
import com.error22.thelta.TheltaModule;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TheltaWorld extends TheltaModule {

	public static PutsInWorld piw;
	public static Block blockCopper;
	public static Block blockTin;
	public static Block plantRubber;
	public static CreativeTabs creativetab;

	@Override
	public void init(Context context) {
		creativetab = context.createTabWithBlock("World Generation", () -> blockCopper);
	}
	public void registerBlocks(Context context) {
		blockCopper = context.createSimpleBlock("thelta_Ore_Copper", Material.ROCK, creativetab);
		blockTin = context.createSimpleBlock("thelta_Ore_Tin", Material.ROCK, creativetab);
		plantRubber = context.createSimpleBlock("thelta_Plant_Rubber", Material.GRASS, creativetab);
	}
}
