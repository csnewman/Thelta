package com.error22.thelta.common;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class CraftingItem extends Item {
	public CraftingItem(String itemname) {
		super();
		//Here we are creating the item
		setRegistryName(itemname);
		setUnlocalizedName(itemname);
		setCreativeTab(CraftingMaterials.creativeTabCraftingMaterials);
		ForgeRegistries.ITEMS.register(this);
		CraftingMaterials.itemsToBeRegisteredByRender.add(this);
	}
}
