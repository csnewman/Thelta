package com.error22.thelta.minivox.blocks;

import com.error22.thelta.minivox.Minivox;
import com.error22.thelta.minivox.MinivoxItemRenderRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class QuickBlock extends Block {
	
	public ItemBlock itemBlock;
	
	public QuickBlock(String itemname) {
		super(Material.ROCK);
		
		//Here we are creating the block
		setUnlocalizedName(itemname);
		setRegistryName(itemname);
		setCreativeTab(Minivox.creativetab);
		
		registerSimpleBlock(this);
	}

	private static void registerSimpleBlock(Block block) {
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(block);
		GameRegistry.register(item);
		MinivoxItemRenderRegistry.register(item);
	}

}