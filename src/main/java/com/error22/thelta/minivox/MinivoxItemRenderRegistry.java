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
    	//register(Minivox.testItem);
    	//register(Item.getItemFromBlock(Minivox.testBlock));

    	/*Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
        .register(item, 0, new ModelResourceLocation(
        		Thelta.MODID + ":" + item.getRegistryName().getResourcePath(), "inventory")
        	);*/
    	
    	for (Item item : registerableItems) {
    		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
            .register(item, 0, new ModelResourceLocation(
            		Thelta.MODID + ":" + item.getRegistryName().getResourcePath(), "inventory")
            	);
    	}
    }
    
    //This is used to let other classes register new items to automatically add renderers to.
    public static void register(Item item) {
    	registerableItems.add(item);
    }
    
}
