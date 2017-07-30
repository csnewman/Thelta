package com.error22.thelta.common;

import com.error22.thelta.Context;
import com.error22.thelta.TheltaModule;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class Smeltables extends TheltaModule {

	public static Block blockOreCopper;
	public static Block blockOreTin;
	public static Block blockOreUranium;
	
	@Override
	public void registerBlocks(Context context) {
		//Register ore blocks here
		blockOreCopper = createOre(context, "oreCopper", Material.IRON, CraftingMaterials.materialsTab);
		blockOreTin = createOre(context, "oreTin", Material.IRON, CraftingMaterials.materialsTab);
		blockOreUranium = createOre(context, "oreUranium", Material.IRON, CraftingMaterials.materialsTab);
	}

	@Override
	public void registerRecipes(Context context) {
		//Register smelting recipes here
		GameRegistry.addSmelting(blockOreCopper, new ItemStack(CraftingMaterials.itemCopperIngot), 1);
		GameRegistry.addSmelting(blockOreTin, new ItemStack(CraftingMaterials.itemTinIngot), 1);
		GameRegistry.addSmelting(blockOreUranium, new ItemStack(CraftingMaterials.itemUraniumIngot), 50);
	}

	@Override
	public void postInit(Context context) {
		//Register forge ore dictionaries here
		OreDictionary.registerOre("oreTin", blockOreTin);
		OreDictionary.registerOre("oreCopper", blockOreCopper);
		OreDictionary.registerOre("oreUranium", blockOreUranium);
	}
	
	public Block createOre(Context context, String name, Material material, CreativeTabs tab) {
		return createOre(context, name, material, tab, 5f);
	}
	
	public Block createOre(Context context, String name, Material material, CreativeTabs tab, float hardness) {
		return createOre(context, name, material, tab, hardness, 2);
	}
	
	public Block createOre(Context context, String name, Material material, CreativeTabs tab, float hardness, int harvestLevel) {
		return createOre(context, name, material, tab, hardness, harvestLevel, "pickaxe");
	}
	
	public Block createOre(Context context, String name, Material material, CreativeTabs tab, float hardness, int harvestLevel, String toolClass) {
		Block ore = context.createSimpleBlock(name, material, tab);
		ore.setHardness(hardness);
		ore.setHarvestLevel(toolClass, harvestLevel);
		return ore;
	}
}
