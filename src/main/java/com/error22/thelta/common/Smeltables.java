package com.error22.thelta.common;

import com.error22.thelta.Context;
import com.error22.thelta.TheltaModule;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class Smeltables extends TheltaModule {
	
	public Block blockOreTin;
	public Block blockOreCopper;

	@Override
	public void registerBlocks(Context context) {
		//Register ore blocks here
		blockOreTin = context.createSimpleBlock("oreTin", Material.IRON, CraftingMaterials.materialsTab);
		blockOreCopper = context.createSimpleBlock("oreCopper", Material.IRON, CraftingMaterials.materialsTab);
	}

	@Override
	public void registerRecipes(Context context) {
		//Register smelting recipes here
		GameRegistry.addSmelting(blockOreTin, new ItemStack(CraftingMaterials.itemTinIngot), 1);
		GameRegistry.addSmelting(blockOreCopper, new ItemStack(CraftingMaterials.itemCopperIngot), 1);
	}

	@Override
	public void postInit(Context context) {
		//Register forge ore dictionaries here
		OreDictionary.registerOre("oreCopper", blockOreCopper);
		OreDictionary.registerOre("oreTin", blockOreTin);
	}
}
