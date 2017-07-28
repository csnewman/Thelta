package com.error22.thelta.minivox.blocks;

import com.error22.thelta.minivox.Minivox;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class QuickBlock extends Block {
	
	public Item blockItem;
	
	public QuickBlock(String itemname) {
		super(Material.ROCK);
		
		//Here we are creating the block
		setUnlocalizedName(itemname);
		setRegistryName(itemname);
		setCreativeTab(Minivox.creativetab);
		
		blockItem = registerSimpleBlock();
	}

	
	//Copied from newmans code (did i use this?)
	private ItemBlock registerSimpleBlock() {
		ItemBlock item = new ItemBlock(this);
		item.setRegistryName(getRegistryName());
		ForgeRegistries.BLOCKS.register(this);
		ForgeRegistries.ITEMS.register(item);
		return item;
	}
	

}