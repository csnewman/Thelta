package com.error22.thelta.minivox.blocks;

import com.error22.thelta.minivox.Minivox;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class QuickBlock extends Block {
	
	public QuickBlock(String itemname) {
		super(Material.ROCK);
		
		//Here we are creating the block
		setUnlocalizedName(itemname);
		setRegistryName(itemname);
		setCreativeTab(Minivox.creativetab);
	}

	

}