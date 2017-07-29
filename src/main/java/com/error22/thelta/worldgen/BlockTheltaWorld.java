package com.error22.thelta.worldgen;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumFacing;

public class BlockTheltaWorld extends Block {
	
	public BlockTheltaWorld(String name) {
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(3f);
		setResistance(5f);
		setCreativeTab(CreativeTabs.REDSTONE);
	}
}
