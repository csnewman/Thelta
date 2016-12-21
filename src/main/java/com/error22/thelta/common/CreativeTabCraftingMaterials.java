package com.error22.thelta.common;

import com.error22.thelta.machines.Machines;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabCraftingMaterials extends CreativeTabs {

	public CreativeTabCraftingMaterials(String label) {
		super(label);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(CraftingMaterials.itemElectricMotor);
	}

}
