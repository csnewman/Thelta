package com.error22.thelta.craftingcomponents;

import com.error22.thelta.minivox.Minivox;
import com.error22.thelta.minivox.MinivoxItemRenderRegistry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingIngredientItem extends Item {	
	public CraftingIngredientItem(String itemname) {
		super();
		//Here we are creating the item
		setRegistryName(itemname);
		setUnlocalizedName(itemname);
		setCreativeTab(CreativeTabs.MISC);
		GameRegistry.register(this);
		
		//(Im just tapping into my class to make it easier)
		//And here we are registering the item to the renderer queue
		MinivoxItemRenderRegistry.register(this);
	}
}
