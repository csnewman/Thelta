package com.error22.thelta.testing;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TheltaMainTab extends CreativeTabs {

	public TheltaMainTab(String label) {
		super(label);
	}

	@Override
	public ItemStack getTabIconItem() {
		// TODO Auto-generated method stub
		return new ItemStack(TheltaTesting.testItem);
	}

}
