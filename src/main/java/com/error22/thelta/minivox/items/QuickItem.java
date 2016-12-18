package com.error22.thelta.minivox.items;

import com.error22.thelta.minivox.Minivox;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class QuickItem extends Item {	
	public QuickItem(String itemname) {
		super();
		//Here we are creating the item
		setRegistryName(itemname);
		setUnlocalizedName(itemname);
		setCreativeTab(Minivox.creativetab);
		GameRegistry.register(this);
	}
}
