package com.error22.thelta.minivox.items;

import com.error22.thelta.Thelta;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class QuickItem extends Item {	
	public QuickItem(String itemname) {
		super();
		setRegistryName(itemname);
		setUnlocalizedName(itemname);
		setCreativeTab(com.error22.thelta.minivox.CreativeTabs.minivox);
		GameRegistry.register(this);
	}
}
