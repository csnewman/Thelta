package com.error22.thelta.minivox.creativetabs;

import com.error22.thelta.minivox.Minivox;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabMinivox extends CreativeTabs {

	public CreativeTabMinivox(String label) {
		super(label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack getTabIconItem() {
		// TODO Auto-generated method stub
		return new ItemStack(Minivox.testItem);
	}

}
