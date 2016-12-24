package com.error22.thelta.machines.creativetabs;

import com.error22.thelta.machines.Machines;
import com.error22.thelta.minivox.Minivox;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabMachines extends CreativeTabs {

	public CreativeTabMachines(String label) {
		super(label);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Machines.blockConvayorT1);
	}

}
