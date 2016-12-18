package com.error22.thelta.minivox.creativetabs;

import com.error22.thelta.minivox.Minivox;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabMinivox extends CreativeTabs {

	public CreativeTabMinivox(String label) {
		super(label);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Minivox.testItem);
	}

}
