package com.error22.thelta.common;

import com.error22.thelta.machines.Machines;
import com.error22.thelta.minivox.Minivox;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingItem extends Item {
	public CraftingItem(String itemname) {
		super();
		//Here we are creating the item
		setRegistryName(itemname);
		setUnlocalizedName(itemname);
		setCreativeTab(Machines.creativeTabCraftingMaterials);
		GameRegistry.register(this);
	}
}
