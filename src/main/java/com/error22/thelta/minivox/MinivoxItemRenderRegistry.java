package com.error22.thelta.minivox;

import java.util.ArrayList;
import java.util.List;

import com.error22.thelta.Thelta;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class MinivoxItemRenderRegistry {
	
	private static List<Item> registerableItems = new ArrayList<Item>();
	
    public static void registerItemRenderer() {
    	/*
    	 * I was having issues trying to bind the renderer to the item in the pre-init method,
    	 * so i just added the items to a list, and iterated through it, registering a model
    	 * for each item in the list.
    	 */
    	
    	//Here we are registering the new item renderers
    	for (Item item : registerableItems) {
    		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
            .register(item, 0, new ModelResourceLocation(
            		Thelta.MODID + ":" + item.getRegistryName().getResourcePath(), "inventory")
            	);
    	}    	
    	//Freeing up any used memory, tossing it into the garbage collection :P
    	registerableItems = null;
    }
    
    //This is used to let other classes register new items to automatically add renderers to.
    public static void register(Item item) {
    	registerableItems.add(item);
    }
    
}
