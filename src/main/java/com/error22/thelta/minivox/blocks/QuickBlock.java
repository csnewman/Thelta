package com.error22.thelta.minivox.blocks;

import com.error22.thelta.minivox.Minivox;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class QuickBlock extends Block {
	
	public QuickBlock(String itemname) {
		super(Material.ROCK);
		setUnlocalizedName(itemname);
		setRegistryName(itemname);
		setCreativeTab(Minivox.creativetab);
		GameRegistry.register(this);
	}

}
