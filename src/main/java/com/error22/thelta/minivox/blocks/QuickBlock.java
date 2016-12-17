package com.error22.thelta.minivox.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class QuickBlock extends Block {
	
	public QuickBlock(String itemname) {
		super(Material.ROCK);
		GameRegistry.register(this);
	}

}
