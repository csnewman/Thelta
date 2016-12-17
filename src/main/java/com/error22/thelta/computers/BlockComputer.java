package com.error22.thelta.computers;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockComputer extends Block {

	public BlockComputer(String name) {
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);

		setHardness(3f);
		setResistance(5f);
		setCreativeTab(CreativeTabs.REDSTONE);
	}

}
