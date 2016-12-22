package com.error22.thelta.machines.blocks;

import com.error22.thelta.common.CraftingMaterials;
import com.error22.thelta.machines.Machines;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockBasic extends Block {
	
	public Item blockItem;
	
	public BlockBasic(String itemname) {
		super(Material.ROCK);
		
		//Here we are creating the block
		setUnlocalizedName(itemname);
		setRegistryName(itemname);
		setCreativeTab(Machines.creativetab);
		
		blockItem = registerSimpleBlock();
	}

	
	//Copied from newmans code (did i use this?)
	private ItemBlock registerSimpleBlock() {
		ItemBlock item = new ItemBlock(this);
		item.setRegistryName(getRegistryName());
		GameRegistry.register(this);
		GameRegistry.register(item);
		
		CraftingMaterials.itemsToBeRegisteredByRender.add(item);
		return item;
	}
	

}