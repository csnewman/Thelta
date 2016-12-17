package com.error22.thelta.items;

import com.error22.thelta.Thelta;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class QuickItem extends Item {	
	public QuickItem(String itemname) {
		super();
		setRegistryName(itemname);
		setUnlocalizedName(itemname);
		setCreativeTab(CreativeTabs.MISC);
	}
}
